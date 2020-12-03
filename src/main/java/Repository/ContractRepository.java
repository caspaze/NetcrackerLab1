package Repository;

import Contracts.*;
import Repository.Validate.*;
import Repository.Validate.ContractNumberValidator;
import Repository.Validate.EndDateValidator;
import Repository.Validate.StartDateValidator;
import Repository.Validate.UserValidator;
import Repository.Validate.ValidateInternetContract.ConnectionSpeedValidator;
import Repository.Validate.ValidateInternetContract.InternetContractValidator;
import Repository.Validate.ValidateMobileConnectionContract.GbInternetValidator;
import Repository.Validate.ValidateMobileConnectionContract.MinutesQuantityValidator;
import Repository.Validate.ValidateMobileConnectionContract.MobileConnectionValidator;
import Repository.Validate.ValidateMobileConnectionContract.SMSQuantityValidator;
import Repository.Validate.ValidateTelevisionContract.ChannelPackagesValidator;
import Repository.Validate.ValidateTelevisionContract.TelevisionContractValidator;
import Repository.sort.ISorter;
import Repository.sort.MergeSorter;
import Users.User;
import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Vadim Novoselov
 */
public class ContractRepository {
    /**
     * An array of the Contract type that contains contracts
     */
    private Contract[] repository = new Contract[delta];

    /**
     * Field that stores the number of contracts added to the repository
     */
    private int contractsQuantity;
    /**
     * Variable that determines how much the repository will grow when it is full
     */
    private static final int delta=20;

    private ISorter sorter;
    /**
     * Constructor-creates a ContractRepository object and initializes the repository field
     */
    public ContractRepository()
    {

    }
    public int getContractsQuantity()
    {
        return contractsQuantity;
    }

    /**
     * Function for adding a new contract to the repository
     * @param contract The contract that will be added to the repository. The contract class must be a descendant of the abstract Contract class
     */
    public void addContract(Contract contract){

        if (contractsQuantity >= repository.length) {
            repository = resizeRepository();
        }
        repository[contractsQuantity]=contract;
        contractsQuantity++;
    }

    /**
     * A function that changes the size of the current repository. Called when the repository is already full when adding a new contract. Increases the repository size by delta
     * @return Returns the repository with the increased size.
     */
    private Contract[] resizeRepository(){

        Contract[] newRepository = new Contract[contractsQuantity+delta];
        for(int i=0;i<repository.length;i++){

            newRepository[i]=repository[i];
        }
        return newRepository;
    }

    /**
     * Function for deleting a contract from the repository
     * @param contractId Value of the contract id to delete
     * @return Returns true if the contract was successfully deleted, false if the contract with the passed id value does not exist in the repository.
     */
    public boolean deleteContract(int contractId){

        int i=0;
        for(i=0;i<contractsQuantity;i++){

            if(repository[i].getContractId()==contractId){

                break;
            }
        }
        if(i==contractsQuantity)
            return false;
        for(int j=i;j< repository.length-1;j++){

            repository[j]=repository[j+1];

        }
        contractsQuantity--;
        return true;
    }

    /**
     * Function for getting a contract from the repository
     * @param id Id of the contract to get
     * @return Returns a contract if a contract with the passed id value was found, null-if such contract does not exist in the repository.
     */
    public Contract getContractOnId(int id){

        Contract contract;
        for(int i =0;i<contractsQuantity;i++){

            if(repository[i].getContractId()==id){

                return repository[i];
            }
        }
        return null;
    }

    /**
     * Функция поиска в репозитории по передаваемому предикату
     * @param pred - предикат по которому будет происходить поиск
     * @return объект ContractRepository с найденными объектами
     */
    public ContractRepository search(Predicate<Contract> pred){
        ContractRepository foundObjRepository = new ContractRepository();
        for(int i=0;i< contractsQuantity;i++){
            if(pred.test(repository[i])){
                foundObjRepository.addContract(repository[i]);
            }
        }
        return foundObjRepository;
    }


    /**
     * Функция сортировки слиянием. Временная сложность - O(n*log(n))
     * @param comp компаратор, по которму будет происходить сортировка
     */
    public void sort(Comparator<Contract> comp){
        MergeSorter mergeSorter = new MergeSorter(repository,contractsQuantity);
        sorter = (ISorter) mergeSorter;
        sorter.sort(comp);
    }

    /**
     * Функция загрузчик контрактов из csv файла. Не добавляет контракт, если контракт этого типа и с таким же владельцем уже существует в репозитории.
     * @param file Путь к файлу с данными
     * @return true - все контракты были успешно добавлены. false - были найдены дубиликаты
     * @throws IOException
     */
    public boolean downloadContract(String file) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(file), ',' , '"' , 0);
        boolean allSuccessfullyAdded = true;
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            if (nextLine != null) {
                LocalDate startDate = LocalDate.parse(nextLine[0]);
                LocalDate endDate = LocalDate.parse(nextLine[1]);
                String name = nextLine[2];
                String gender = nextLine[3];
                LocalDate birthDate = LocalDate.parse(nextLine[4]);
                int passportSeries = Integer.parseInt(nextLine[5]);
                int passportNumber = Integer.parseInt(nextLine[6]);
                String contractType = nextLine[7];
                User user = new User();
                user.setFio(name);
                user.setBirthDate(birthDate);
                user.setGender(gender);
                user.setPassportSeries(passportSeries);
                user.setPassportNumber(passportNumber);

                List<Validator> validators = new ArrayList<>();
                validators.add(new StartDateValidator());
                validators.add(new EndDateValidator());
                validators.add(new ContractNumberValidator());
                validators.add(new UserValidator());
                switch(contractType){
                    case "DigitalTelevisionContract":{
                        DigitalTelevisionContract contract = new DigitalTelevisionContract();
                        contract.setContractStartDate(startDate);
                        contract.setContractEndDate(endDate);
                        contract.setContractOwner(user);
                        switch(nextLine[8]){
                            case "MinimumChannels":{
                                contract.setChannelsPackage(ChannelPackages.MinimumChannels);
                                break;
                            }
                            case "AverageChannels":{
                                contract.setChannelsPackage(ChannelPackages.AverageChannels);
                                break;
                            }
                            case "MaximumChannels":{
                                contract.setChannelsPackage(ChannelPackages.MaximumChannels);
                                break;
                            }
                        }
                        List<TelevisionContractValidator> televisionValidators= new ArrayList<>();
                        televisionValidators.add(new ChannelPackagesValidator());
                        boolean validated = true;
                        for(Validator v:validators){
                            Message message = v.validate(contract);
                            System.out.println(message.toString());
                            if(message.getStatus().equals(Status.ERROR)){
                                validated = false;
                            }
                        }
                        for(TelevisionContractValidator v:televisionValidators){
                            Message message = v.validate(contract);
                            System.out.println(message.toString());
                            if(message.getStatus().equals(Status.ERROR)){
                                validated = false;
                            }
                        }

                        if(!isContractExist(contract) && validated){
                            addContract(contract);
                        }
                        break;
                    }
                    case "InternetContract":{
                        InternetContract contract = new InternetContract();
                        contract.setContractStartDate(startDate);
                        contract.setContractEndDate(endDate);
                        contract.setContractOwner(user);
                        contract.setConnectionSpeed(Double.parseDouble(nextLine[8]));

                        List<InternetContractValidator> internetValidators = new ArrayList<>();
                        internetValidators.add(new ConnectionSpeedValidator());
                        boolean validated = true;
                        for(Validator v:validators){
                            Message message = v.validate(contract);
                            System.out.println(message.toString());
                            if(message.getStatus().equals(Status.ERROR)){
                                validated = false;
                            }
                        }
                        for(InternetContractValidator v:internetValidators){
                            Message message = v.validate(contract);
                            System.out.println(message.toString());
                            if(message.getStatus().equals(Status.ERROR)){
                                validated = false;
                            }
                        }

                        if(!isContractExist(contract) && validated){
                            addContract(contract);
                        }
                        break;
                    }
                    case "MobileConnectionContract":{
                        MobileConnectionContract contract = new MobileConnectionContract();
                        contract.setContractStartDate(startDate);
                        contract.setContractEndDate(endDate);
                        contract.setContractOwner(user);

                        contract.setMinutesQuantity(Integer.parseInt(nextLine[8]));
                        contract.setSMSQuantity(Integer.parseInt(nextLine[9]));
                        contract.setGbInternetQuantity(Integer.parseInt(nextLine[10]));

                        List<MobileConnectionValidator> mobileConnectionValidators = new ArrayList<>();
                        mobileConnectionValidators.add(new MinutesQuantityValidator());
                        mobileConnectionValidators.add(new SMSQuantityValidator());
                        mobileConnectionValidators.add(new GbInternetValidator());
                        boolean validated = true;
                        for(Validator v:validators){
                            Message message = v.validate(contract);
                            System.out.println(message.toString());
                            if(message.getStatus().equals(Status.ERROR)){
                                validated = false;
                            }
                        }
                        for(MobileConnectionValidator v:mobileConnectionValidators){
                            Message message = v.validate(contract);
                            System.out.println(message.toString());
                            if(message.getStatus().equals(Status.ERROR)){
                                validated = false;
                            }
                        }

                        if(!isContractExist(contract) && validated){
                            addContract(contract);
                        }
                        break;
                    }
                    default:{
                        allSuccessfullyAdded = false;
                    }
                }
            }
        }
        return allSuccessfullyAdded;
    }

    /**
     * Функция проверки существования контракта в репозитории по имени владельца и типу контракта
     * @param contract Контракт, который будет искаться в репозитории
     * @return true - переданный контракт был найден. false - не был найден.
     */
    private boolean isContractExist(Contract contract){
        for(int i =0; i< contractsQuantity;i++){
            if(repository[i].getContractOwner().getFio().equals(contract.getContractOwner().getFio()) &&
                    repository[i].getClass().getSimpleName().equals(contract.getClass().getSimpleName())){
                return true;
            }
        }
        return false;
    }
    public void show()
    {
        for(int i=0;i<contractsQuantity;i++){
            System.out.println(repository[i].toString());

        }
    }

}

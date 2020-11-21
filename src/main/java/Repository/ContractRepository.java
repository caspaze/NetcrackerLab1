package Repository;

import Contracts.*;
import Users.User;
import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
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

    /**
     * Constructor-creates a ContractRepository object and initializes the repository field
     */
    public ContractRepository() {

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
     * Функция сортировки пузырьком. Временная сложность - O(n^2)
     * @param comp компаратор, по которму будет происходить сортировка
     */
    public void bubbleSort(Comparator<Contract> comp){
        for (int i=0;i<contractsQuantity-1;i++){
            for(int j=0;j<contractsQuantity-1;j++){
                if(comp.compare(repository[j],repository[j+1]) > 0){
                    Contract t = repository[j];
                    repository[j] = repository[j+1];
                    repository[j+1] = t;
                }
            }
        }
    }

    /**
     * Функция сортировки слиянием. Временная сложность - O(n*log(n))
     * @param comp компаратор, по которму будет происходить сортировка
     */
    public void mergeSort(Comparator<Contract> comp){
        sort(repository,0,contractsQuantity-1,comp);
    }

    /**
     *
     * @param array сортируемый массив
     * @param left левая граница массива
     * @param right правая граница массива
     * @param comp компаратор, по которму будет происходить сортировка
     */
    private void sort(Contract[] array, int left, int right,Comparator<Contract> comp){
        if (right <= left) return;
        int mid = (left+right)/2;
        sort(array, left, mid,comp);
        sort(array, mid+1, right,comp);
        merge(array, left, mid, right,comp);
    }

    /**
     * Функция слияния
     * @param array сортируемый массив
     * @param left левая граница массива
     * @param mid середина массива
     * @param right правая граница массива
     * @param comp компаратор, по которму будет происходить сортировка
     */
    private void merge(Contract[] array, int left, int mid, int right,Comparator<Contract> comp){
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;

        // создаем временные подмассивы
        Contract leftArray[] = new Contract [lengthLeft];
        Contract rightArray[] = new Contract [lengthRight];

        // копируем отсортированные массивы во временные
        for (int i = 0; i < lengthLeft; i++)
            leftArray[i] = array[left+i];
        for (int i = 0; i < lengthRight; i++)
            rightArray[i] = array[mid+i+1];

        // итераторы содержат текущий индекс временного подмассива
        int leftIndex = 0;
        int rightIndex = 0;

        // копируем из leftArray и rightArray обратно в массив
        for (int i = left; i < right + 1; i++) {
            // если остаются нескопированные элементы в R и L, копируем минимальный
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (comp.compare(leftArray[leftIndex],rightArray[rightIndex])<0) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            // если все элементы были скопированы из rightArray, скопировать остальные из leftArray
            else if (leftIndex < lengthLeft) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            }
            // если все элементы были скопированы из leftArray, скопировать остальные из rightArray
            else if (rightIndex < lengthRight) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
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

                switch(contractType){
                    case "DigitalTelevisionContract":{
                        DigitalTelevisionContract contract = new DigitalTelevisionContract();
                        contract.setContractStartDate(startDate);
                        contract.setContractEndDate(endDate);
                        contract.setContractOwner(user);
                        switch(nextLine[8]){
                            case "Minimum Channels":{
                                contract.setChannelsPackage(ChannelPackages.MinimumChannels);
                                break;
                            }
                            case "Average Channels":{
                                contract.setChannelsPackage(ChannelPackages.AverageChannels);
                                break;
                            }
                            case "Maximum Channels":{
                                contract.setChannelsPackage(ChannelPackages.MaximumChannels);
                                break;
                            }
                        }
                        if(!isContractExist(contract)){
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

                        if(!isContractExist(contract)){
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

                        if(!isContractExist(contract)){
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

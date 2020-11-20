package Repository;

import Contracts.Contract;

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
    public void showContracts()
    {
        for(int i=0;i<contractsQuantity;i++)
        {
            System.out.println(repository[i].getContractId());
        }
    }

    public ContractRepository search(Predicate<Contract> pred){
        ContractRepository foundObjRepository = new ContractRepository();
        for(int i=0;i< contractsQuantity;i++){
            if(pred.test(repository[i])){
                foundObjRepository.addContract(repository[i]);
            }
        }
        return foundObjRepository;
    }

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

    public void mergeSort(Comparator<Contract> comp){
        sort(repository,0,contractsQuantity-1,comp);
    }
    private void sort(Contract[] array, int left, int right,Comparator<Contract> comp){
        if (right <= left) return;
        int mid = (left+right)/2;
        sort(array, left, mid,comp);
        sort(array, mid+1, right,comp);
        merge(array, left, mid, right,comp);
    }
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

}

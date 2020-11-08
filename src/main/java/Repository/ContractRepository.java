package Repository;

import Contracts.Contract;

/**
 * @author Vadim Novoselov
 */
public class ContractRepository {
    /**
     * An array of the Contract type that contains contracts
     */
    private Contract[] repository = new Contract[delta];

    public Contract[] getRepository() {

        return this.repository;
    }

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


}

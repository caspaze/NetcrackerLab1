package Repository;

import Contracts.Contract;

public class ContractRepository {
    private Contract[] repository;
    private int contractsQuantity;
    private int delta=20;
    public ContractRepository()
    {
        repository = new Contract[delta];
    }
    public void addContract(Contract contract)
    {
        if(contractsQuantity<repository.length)
        {
            repository[contractsQuantity]=contract;
            contractsQuantity++;
        }
        else
        {
            repository = resizeRepository();
            repository[contractsQuantity]=contract;
            contractsQuantity++;
        }

    }
    private Contract[] resizeRepository()
    {
        Contract[] newRepository = new Contract[contractsQuantity+delta];
        for(int i=0;i<repository.length;i++)
        {
            newRepository[i]=repository[i];
        }
        return newRepository;
    }
    public void showContracts()
    {
        for(int i =0;i< contractsQuantity;i++)
        {
            /*if(repository[i]==null)
            {
                System.out.print("* ");
            }
            else
            {
                System.out.print(repository[i].getContractId() + " ");
            }*/
            System.out.print(repository[i].getContractId() + " ");
        }
        //System.out.println("Repository size = " + repository.length);
    }
    public boolean deleteContract(int contractId)
    {
        int i=0;
        for(i=0;i<contractsQuantity;i++)
        {
            if(repository[i].getContractId()==contractId)
            {
                break;
            }
        }
        if(i==contractsQuantity)
            return false;
        for(int j=i;j< repository.length-1;j++)
        {
            repository[j]=repository[j+1];

        }
        contractsQuantity--;
        return true;
    }
    public Contract getContractOnId(int id)
    {
        Contract contract;
        for(int i =0;i<contractsQuantity;i++)
        {
            if(repository[i].getContractId()==id)
            {
                return repository[i];
            }
        }
        return null;
    }

}

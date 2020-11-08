package Repository.Sort;

import Contracts.Contract;
import Repository.ContractRepository;

import java.util.Comparator;

public class BubbleSorter implements ISorter{
    @Override
    public void sort(ContractRepository repository, Comparator<Contract> comp){

        Contract[] contracts = repository.getRepository();
        for (int i=0;i<repository.getContractsQuantity()-1;i++){
            for(int j=0;j<repository.getContractsQuantity()-1;j++){
                if(comp.compare(contracts[j],contracts[j+1]) > 0){
                    Contract t = contracts[j];
                    contracts[j] = contracts[j+1];
                    contracts[j+1] = t;
                }
            }
        }
    }
}

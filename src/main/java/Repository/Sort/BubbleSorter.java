package Repository.Sort;

import Contracts.Contract;
import Repository.ContractRepository;

import java.util.Comparator;
/**
 * @author Vadim Novoselov
 */
public class BubbleSorter implements ISorter{
    /**
     * Sort function. Uses bubble sort algorithm. Complexity - O(n^2)
     * @param repository Repository with sorting objects
     * @param comp parameter, on which objects will be compared
     */
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

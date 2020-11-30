package Repository;

import Contracts.Contract;

import java.util.ArrayList;
import java.util.Comparator;

public class BubbleSorter implements ISorter{
    public Contract[] repository;
    public int contractsQuantity;
    public BubbleSorter(Contract[] repository, int contractsQuantity){
        this.repository = repository;
        this.contractsQuantity = contractsQuantity;
    }
    /**
     * Функция сортировки пузырьком. Временная сложность - O(n^2)
     * @param comp компаратор, по которму будет происходить сортировка
     */
    @Override
    public void sort(Comparator<Contract> comp){
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
}

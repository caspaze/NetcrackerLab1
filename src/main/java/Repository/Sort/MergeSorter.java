package Repository.Sort;

import Contracts.Contract;
import Repository.ContractRepository;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSorter implements ISorter{
    @Override
    public void sort(ContractRepository repository, Comparator<Contract> comp)
    {
        Contract[] contracts = repository.getRepository();
        mergeSort(contracts, repository.getContractsQuantity(), comp);
    }
    private void mergeSort(Contract[]a, int n,Comparator<Contract> comp) {
        if (n < 2) {
            return;
        }
        int mid = n/2;
        Contract[]l = new Contract[mid];
        Contract[]r = new Contract[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i]= a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid]= a[i];
        }
        mergeSort(l, mid,comp);
        mergeSort(r, n - mid, comp);

        merge(a, l, r, mid, n - mid,comp);
    }
    private void merge(Contract[]a, Contract[]l, Contract[]r, int left, int right,Comparator<Contract> comp) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (comp.compare(l[i],r[i])<0){ //using comparator
                a[k++]= l[i++];
            }
            else {
                a[k++]= r[j++];
            }
        }
        while (i < left) {
            a[k++]= l[i++];
        }
        while (j < right) {
            a[k++]= r[j++];
        }
    }
}

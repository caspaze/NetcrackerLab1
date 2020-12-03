package Repository.sort;

import Contracts.Contract;

import java.util.Comparator;

public interface ISorter {
    public void sort(Comparator<Contract> comp);
}

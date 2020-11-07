package Repository.Sort;

import Contracts.Contract;
import Repository.ContractRepository;

import java.util.Comparator;

public interface ISorter {
    public void sort(ContractRepository repository, Comparator<Contract> comp);
}

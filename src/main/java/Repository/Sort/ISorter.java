package Repository.Sort;

import Contracts.Contract;
import Repository.ContractRepository;

import java.util.Comparator;
/**
 * @author Vadim Novoselov
 */
public interface ISorter {
    /**
     * Sort function
     * @param repository
     * @param comp
     */
    public void sort(ContractRepository repository, Comparator<Contract> comp);
}

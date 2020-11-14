package Repository.Sort;

import Contracts.Contract;

import java.util.Comparator;
/**
 * @author Vadim Novoselov
 */
public class Comparators {
    /**
     * Compares two contracts on id
     */
    public static Comparator<Contract> contractId = (c1, c2) -> c1.getContractId() - c2.getContractId();
    /**
     * Compares two contracts on start date
     */
    public static Comparator<Contract> contractStartDate = new Comparator<Contract>() {
        @Override
        public int compare(Contract o1, Contract o2) {
            if(o1.getContractStartDate().isBefore(o2.getContractStartDate())){

                return 1;
            }
            if(o1.getContractStartDate().isAfter(o2.getContractStartDate())){

                return -1;
            }
            return 0;
        }
    };
    /**
     * Compares two contracts on end date
     */
    public static Comparator<Contract> contractEndDate = new Comparator<Contract>() {
        @Override
        public int compare(Contract o1, Contract o2) {
            if(o1.getContractEndDate().isBefore(o2.getContractEndDate())){

                return 1;
            }
            if(o1.getContractEndDate().isAfter(o2.getContractEndDate())){

                return -1;
            }
            return 0;
        }
    };
    /**
     * Compares two contracts on contract number
     */
    public static Comparator<Contract> contractNumber = (c1,c2) -> c1.getContractNumber() - c2.getContractNumber();

}

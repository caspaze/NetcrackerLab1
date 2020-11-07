package Repository;

import Contracts.Contract;

import java.util.Comparator;

public class Comparators {
    public static Comparator<Contract> contractIdComp = (c1, c2) -> c1.getContractId() - c2.getContractId();
    public static Comparator<Contract> contractStartDateComp = new Comparator<Contract>() {
        @Override
        public int compare(Contract o1, Contract o2) {
            if(o1.getContractStartDate().getTime() < o2.getContractStartDate().getTime())
            {
                return 1;
            }
            if(o1.getContractStartDate().getTime() > o2.getContractStartDate().getTime())
            {
                return -1;
            }
            return 0;
        }
    };
    public static Comparator<Contract> contractEndDateComp = new Comparator<Contract>() {
        @Override
        public int compare(Contract o1, Contract o2) {
            if(o1.getContractEndDate().getTime() < o2.getContractEndDate().getTime())
            {
                return 1;
            }
            if(o1.getContractEndDate().getTime() > o2.getContractEndDate().getTime())
            {
                return -1;
            }
            return 0;
        }
    };
    public static Comparator<Contract> contractNumberComp = (c1,c2) -> c1.getContractNumber() - c2.getContractNumber();

}

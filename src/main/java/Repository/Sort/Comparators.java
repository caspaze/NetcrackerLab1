package Repository.Sort;

import Contracts.Contract;

import java.util.Comparator;

public class Comparators {
    public static Comparator<Contract> contractId = (c1, c2) -> c1.getContractId() - c2.getContractId();
    public static Comparator<Contract> contractStartDate = new Comparator<Contract>() {
        @Override
        public int compare(Contract o1, Contract o2) {
            if(o1.getContractStartDate().getTime() > o2.getContractStartDate().getTime()){

                return 1;
            }
            if(o1.getContractStartDate().getTime() < o2.getContractStartDate().getTime()){

                return -1;
            }
            return 0;
        }
    };
    public static Comparator<Contract> contractEndDate = new Comparator<Contract>() {
        @Override
        public int compare(Contract o1, Contract o2) {
            if(o1.getContractEndDate().getTime() < o2.getContractEndDate().getTime()){

                return 1;
            }
            if(o1.getContractEndDate().getTime() > o2.getContractEndDate().getTime()){

                return -1;
            }
            return 0;
        }
    };
    public static Comparator<Contract> contractNumber = (c1,c2) -> c1.getContractNumber() - c2.getContractNumber();

}

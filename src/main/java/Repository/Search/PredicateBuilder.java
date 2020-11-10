package Repository.Search;

import Contracts.Contract;
import Users.User;

import java.util.Date;
import java.util.function.Predicate;

public class PredicateBuilder {
    public static Predicate<Contract> searchOnId(int key){
        Predicate<Contract> sameId = (c1) -> c1.getContractId() == key ;
        return sameId;
    }
    public static Predicate<Contract> searchOnStartDate(Date date){
        Predicate<Contract> sameStartDate = (c1) -> c1.getContractStartDate().equals(date);
        return sameStartDate;
    }
    public static Predicate<Contract> searchOnEndDate(Date date){
        Predicate<Contract> sameEndDate = (c1) -> c1.getContractEndDate().equals(date);
        return sameEndDate;
    }
    public static Predicate<Contract> searchOnNumber(int key){
        Predicate<Contract> sameNumber = (c1) -> c1.getContractNumber() == key;
        return sameNumber;
    }
    public static Predicate<Contract> searchOnUser(User user){
        Predicate<Contract> sameUser = (c1) -> c1.getContractOwner().equals(user);
        return sameUser;
    }
}

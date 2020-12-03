package Repository.Validate.ValidateMobileConnectionContract;

import Contracts.MobileConnectionContract;
import Repository.Validate.Message;
import Repository.Validate.Status;

public class MinutesQuantityValidator implements MobileConnectionValidator {
    @Override
    public Message validate(MobileConnectionContract contract) {
        if(contract.getMinutesQuantity() < 0){
            return new Message(Status.ERROR,"Minutes quantity can`t be negative");
        }
        if(contract.getMinutesQuantity() > 30000){
            return new Message(Status.WARNING,"Minutes quantity value is too big");
        }
        return new Message(Status.OK,"Permissible value of minutes quantity");
    }
}

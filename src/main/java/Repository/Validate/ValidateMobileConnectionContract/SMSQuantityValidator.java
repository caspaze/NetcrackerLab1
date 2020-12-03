package Repository.Validate.ValidateMobileConnectionContract;

import Contracts.MobileConnectionContract;
import Repository.Validate.Message;
import Repository.Validate.Status;

public class SMSQuantityValidator implements MobileConnectionValidator{
    @Override
    public Message validate(MobileConnectionContract contract) {
        if(contract.getSMSQuantity() < 0){
            return new Message(Status.ERROR,"SMS quantity can`t be negative");
        }
        if(contract.getSMSQuantity() > 30000){
            return new Message(Status.WARNING,"SMS quantity value is too big");
        }
        return new Message(Status.OK,"Permissible value of SMS quantity");
    }
}

package Repository.Validate.ValidateMobileConnectionContract;

import Contracts.MobileConnectionContract;
import Repository.Validate.Message;
import Repository.Validate.Status;

public class GbInternetValidator implements MobileConnectionValidator{
    @Override
    public Message validate(MobileConnectionContract contract) {
        if(contract.getGbInternetQuantity() < 0){
            return new Message(Status.ERROR,"Internet quantity can`t be negative");
        }
        if(contract.getGbInternetQuantity() > 30000){
            return new Message(Status.WARNING,"Internet quantity value is too big");
        }
        return new Message(Status.OK,"Permissible value of internet quantity");
    }
}

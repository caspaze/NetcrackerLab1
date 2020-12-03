package Repository.Validate.ValidateInternetContract;

import Contracts.InternetContract;
import Repository.Validate.Message;
import Repository.Validate.Status;

public class ConnectionSpeedValidator implements InternetContractValidator{

    @Override
    public Message validate(InternetContract contract) {
        if(contract.getConnectionSpeed() < 0){
            return new Message(Status.ERROR,"Connection speed can`t be negative");
        }
        if(contract.getConnectionSpeed() > Integer.MAX_VALUE/2){
            return new Message(Status.WARNING,"Connection speed is too big");
        }
        return new Message(Status.OK,"Permissible value of connection speed");
    }
}

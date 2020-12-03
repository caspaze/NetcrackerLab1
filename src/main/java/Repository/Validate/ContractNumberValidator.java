package Repository.Validate;

import Contracts.Contract;
import Repository.Validate.Message;
import Repository.Validate.Status;
import Repository.Validate.Validator;

public class ContractNumberValidator implements Validator {
    @Override
    public Message validate(Contract contract) {
        if(contract.getContractNumber()<0){
            return new Message(Status.ERROR,"Contracts number can`t be negative");
        }
        if(contract.getContractNumber() == Integer.MAX_VALUE){
            return new Message(Status.WARNING,"Contracts number is too big");
        }
        return new Message(Status.OK,"Contracts number is available");
    }
}

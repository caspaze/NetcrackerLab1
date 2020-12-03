package Repository.Validate.UserValidators;

import Contracts.Contract;
import Repository.Validate.Message;
import Repository.Validate.Status;
import Repository.Validate.Validator;

public class UserAgeValidator implements Validator {
    @Override
    public Message validate(Contract contract) {
        if(contract.getContractOwner().getAge() <0){
            return new Message(Status.ERROR,"Age can`t be less 0");
        }
        if(contract.getContractOwner().getAge() > 0 && contract.getContractOwner().getAge() < 18){
            return new Message(Status.WARNING,"User is too young");
        }
        return new Message(Status.OK,"Age is available");
    }
}

package Repository.Validate.UserValidators;

import Contracts.Contract;
import Repository.Validate.Message;
import Repository.Validate.Status;
import Repository.Validate.Validator;

public class FioValidator implements Validator {

    @Override
    public Message validate(Contract contract) {
        int n=0;
        for(char i:contract.getContractOwner().getFio().toCharArray()){
            if(i==' '){
                n++;
            }
        }
        if(n<0){
            return new Message(Status.ERROR,"Fio don`t content surname");
        }
        if(contract.getContractOwner().getFio().length()>100){
            return new Message(Status.WARNING,"Fio is too big");
        }
        return new Message(Status.OK,"Fio is available");
    }
}

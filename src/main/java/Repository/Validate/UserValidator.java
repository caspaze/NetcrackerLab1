package Repository.Validate;

import Contracts.Contract;
import Repository.Validate.UserValidators.BirthDateValidator;
import Repository.Validate.UserValidators.FioValidator;
import Repository.Validate.UserValidators.UserAgeValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserValidator implements Validator {
    @Override
    public Message validate(Contract contract) {
        List<Integer> validStatus= new ArrayList<>();
        List<Validator> validators = new ArrayList<>();
        String errorComments = "";
        String warningComments = "";
        String OkComments = "";
        validators.add(new FioValidator());
        validators.add(new BirthDateValidator());
        validators.add(new UserAgeValidator());
        for(Validator v:validators){
            Message message = v.validate(contract);
            switch (message.getStatus()){
                case ERROR:{
                    validStatus.add(1);
                    errorComments = errorComments.concat(message.getComment() + ", ");
                }
                case WARNING:{
                    validStatus.add(2);
                    warningComments = warningComments.concat(message.getComment() + ", ");
                }
                case OK:{
                    validStatus.add(3);
                    OkComments = OkComments.concat(message.getComment() + ", ");
                }
            }
        }
        switch (Collections.min(validStatus)){
            case 1:{
                return new Message(Status.ERROR,errorComments);
            }
            case 2:{
                return new Message(Status.WARNING,warningComments);
            }
            case 3:{
                return new Message(Status.OK,OkComments);
            }
            default:{
                return new Message(Status.ERROR,"Incorrect data");
            }
        }

    }
}

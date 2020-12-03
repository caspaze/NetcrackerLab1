package Repository.Validate.UserValidators;

import Contracts.Contract;
import Repository.Validate.Message;
import Repository.Validate.Status;
import Repository.Validate.Validator;

import java.time.LocalDate;

public class BirthDateValidator implements Validator {
    @Override
    public Message validate(Contract contract) {
        if(contract.getContractOwner().getBirthDate().isAfter(LocalDate.now())){
            return new Message(Status.ERROR,"Birth date is in future");
        }
        if(contract.getContractOwner().getBirthDate().isBefore(LocalDate.of(1900,1,1))){
            return new Message(Status.WARNING,"Birth date is too far");
        }
        return new Message(Status.OK,"Birth date is available");

    }
}

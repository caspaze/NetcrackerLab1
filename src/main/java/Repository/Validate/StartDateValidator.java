package Repository.Validate;

import Contracts.Contract;
import Repository.Validate.Message;
import Repository.Validate.Status;
import Repository.Validate.Validator;

import java.time.LocalDate;

public class StartDateValidator implements Validator {
    @Override
    public Message validate(Contract contract) {
        if(contract.getContractStartDate().isBefore(LocalDate.of(1999,12,31))){
            return new Message(Status.ERROR,"At this date company didn`t exist");
        }
        if(contract.getContractStartDate().isAfter(LocalDate.now())){
            return new Message(Status.WARNING,"The date is in the future");
        }
        return new Message(Status.OK,"The start date is available");
    }
}

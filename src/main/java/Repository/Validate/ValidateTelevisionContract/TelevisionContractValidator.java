package Repository.Validate.ValidateTelevisionContract;

import Contracts.DigitalTelevisionContract;
import Repository.Validate.Message;

public interface TelevisionContractValidator {
    public Message validate(DigitalTelevisionContract contract);
}

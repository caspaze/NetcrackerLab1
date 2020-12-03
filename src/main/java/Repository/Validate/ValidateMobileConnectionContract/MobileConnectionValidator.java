package Repository.Validate.ValidateMobileConnectionContract;

import Contracts.MobileConnectionContract;
import Repository.Validate.Message;

public interface MobileConnectionValidator {
    public Message validate(MobileConnectionContract contract);
}

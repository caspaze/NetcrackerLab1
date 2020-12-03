package Repository.Validate.ValidateInternetContract;

import Contracts.InternetContract;
import Repository.Validate.Message;

public interface InternetContractValidator {
    public Message validate(InternetContract contract);
}

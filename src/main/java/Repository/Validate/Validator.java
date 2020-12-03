package Repository.Validate;

import Contracts.Contract;

public interface Validator {
    public Message validate(Contract contract);
}

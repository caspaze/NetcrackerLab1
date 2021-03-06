import Contracts.*;
import Repository.ContractRepository;
import Users.User;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        ContractRepository repository = new ContractRepository();
        String file = "src/main/resources/data.csv";
        repository.downloadContract(file);
        repository.show();
    }
}


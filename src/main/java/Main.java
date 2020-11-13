import Contracts.Contract;
import Contracts.DigitalTelevisionContract;
import Contracts.InternetContract;
import Contracts.MobileConnectionContract;
import Repository.ContractRepository;
import Repository.Download.ContractDownloader;
import Users.User;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        ContractRepository repository = new ContractRepository();
        String fileName = "src/main/resources/data.csv";
        ContractDownloader downloader = new ContractDownloader();
        downloader.downloadContract(repository,fileName);
        Contract[] arr = repository.getRepository();
        for(int i =0;i< repository.getContractsQuantity();i++){
            System.out.println(arr[i].getContractOwner().getFio());
        }
    }
}

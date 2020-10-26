import Contracts.DigitalTelevisionContract;
import Contracts.InternetContract;
import Contracts.MobileConnectionContract;
import Repository.ContractRepository;

public class Main {
    public static void main(String[] args) {
        InternetContract internetContract1 = new InternetContract();
        MobileConnectionContract mobileConnectionContract1 = new MobileConnectionContract();
        DigitalTelevisionContract digitalTelevisionContract1 = new DigitalTelevisionContract();
        InternetContract internetContract2 = new InternetContract();
        internetContract1.setContractId(1);
        mobileConnectionContract1.setContractId(2);
        digitalTelevisionContract1.setContractId(3);
        internetContract2.setContractId(4);
        ContractRepository repository = new ContractRepository();
        repository.addContract(internetContract1);
        repository.addContract(mobileConnectionContract1);
        repository.addContract(digitalTelevisionContract1);
        repository.addContract(internetContract2);
        repository.showContracts();
        repository.deleteContract(3);
        repository.showContracts();

    }
}

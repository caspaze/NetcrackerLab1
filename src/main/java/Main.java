import Contracts.DigitalTelevisionContract;
import Contracts.InternetContract;
import Contracts.MobileConnectionContract;
import Repository.ContractRepository;
import Repository.Comparators;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        InternetContract contract1 = new InternetContract();
        DigitalTelevisionContract contract2  = new DigitalTelevisionContract();
        MobileConnectionContract contract3 = new MobileConnectionContract();
        InternetContract contract4 = new InternetContract();

        contract1.setContractId(1);
        contract2.setContractId(2);
        contract3.setContractId(3);
        contract4.setContractId(4);
        contract1.setContractStartDate(new Date(2020,11,7));
        contract2.setContractStartDate(new Date(2020,11,11));
        contract3.setContractStartDate(new Date(2020,11,1));
        contract4.setContractStartDate(new Date(2020,11,14));
        contract1.setContractNumber(11);
        contract2.setContractNumber(12);
        contract3.setContractNumber(13);
        contract4.setContractNumber(14);


        ContractRepository repository = new ContractRepository();
        repository.addContract(contract1);
        repository.addContract(contract2);
        repository.addContract(contract3);
        repository.addContract(contract4);

        repository.bubbleSort(Comparators.contractStartDate);
        //ContractRepository repository1 = repository.search(PredicateBuilder.searchOnId(1));
        repository.showContracts();
        repository.mergeSort(Comparators.contractStartDate);
        repository.showContracts();
    }
}

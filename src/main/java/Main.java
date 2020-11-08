import Contracts.DigitalTelevisionContract;
import Contracts.InternetContract;
import Contracts.MobileConnectionContract;
import Repository.ContractRepository;
import Repository.Search.Searcher;
import Repository.Sort.BubbleSorter;
import Repository.Sort.Comparators;
import Repository.Sort.MergeSorter;

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

        contract1.setContractNumber(4);
        contract1.setContractNumber(3);
        contract1.setContractNumber(2);
        contract1.setContractNumber(1);


        ContractRepository repository = new ContractRepository();
        repository.addContract(contract1);
        repository.addContract(contract2);
        repository.addContract(contract3);
        repository.addContract(contract4);


        BubbleSorter bubbleSorter = new BubbleSorter();
        MergeSorter mergeSorter = new MergeSorter();
        //bubbleSorter.sort(repository, Comparators.contractStartDate);
        mergeSorter.sort(repository,Comparators.contractStartDate);

        repository.showContracts();

        /*Searcher searcher = new Searcher();
        ContractRepository rep1 = Searcher.searchById(repository,3);
        rep1.showContracts();*/

    }
}

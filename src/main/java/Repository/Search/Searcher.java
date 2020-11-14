package Repository.Search;

import Contracts.Contract;
import Repository.ContractRepository;

import java.util.function.Predicate;
/**
 * @author Vadim Novoselov
 */
public class Searcher {
    /**
     * Searching in repository on provided predicate
     * @param repository ContractRepository object, where will be occur the search
     * @param pred predicate, on which will occur comparing
     * @return ContractRepository object with founded objects
     */
    public ContractRepository search(ContractRepository repository,Predicate<Contract> pred){
        Contract[] contracts = repository.getRepository();
        ContractRepository foundObjRepository = new ContractRepository();
        for(int i=0;i< repository.getContractsQuantity();i++){
            if(pred.test(contracts[i])){
                foundObjRepository.addContract(contracts[i]);
            }
        }
        return foundObjRepository;
    }

}

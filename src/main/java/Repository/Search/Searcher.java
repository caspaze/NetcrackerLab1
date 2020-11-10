package Repository.Search;

import Contracts.Contract;
import Repository.ContractRepository;

import java.util.function.Predicate;

public class Searcher {
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

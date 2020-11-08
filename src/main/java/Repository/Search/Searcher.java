package Repository.Search;

import Contracts.Contract;
import Repository.ContractRepository;
import Users.User;

import java.util.Comparator;
import java.util.Date;

public class Searcher {
    public<T> void search(ContractRepository repository, T key, Comparator<T> comp){
        ContractRepository foundObjRepository = new ContractRepository();
        Contract[] contracts = repository.getRepository();
        for(int i =0;i< repository.getContractsQuantity();i++){
            //if(comp.compare(contracts[i].,key)==0)
        }

    }
    public static ContractRepository searchById(ContractRepository repository, int key){
        Contract[] contracts = repository.getRepository();
        ContractRepository foundObjRepository = new ContractRepository();
        for(int i = 0;i< repository.getContractsQuantity();i++){
            if(contracts[i].getContractId()==key){
                foundObjRepository.addContract(contracts[i]);
            }
        }
        return foundObjRepository;
    }
    public static ContractRepository searchByStartDate(ContractRepository repository, Date key){
        Contract[] contracts = repository.getRepository();
        ContractRepository foundObjRepository = new ContractRepository();
        for(int i = 0;i< repository.getContractsQuantity();i++){
            if(contracts[i].getContractStartDate()==key){
                foundObjRepository.addContract(contracts[i]);
            }
        }
        return foundObjRepository;
    }
    public static ContractRepository searchByEndDate(ContractRepository repository, Date key){
        Contract[] contracts = repository.getRepository();
        ContractRepository foundObjRepository = new ContractRepository();
        for(int i = 0;i< repository.getContractsQuantity();i++){
            if(contracts[i].getContractEndDate()==key){
                foundObjRepository.addContract(contracts[i]);
            }
        }
        return foundObjRepository;
    }
    public static ContractRepository searchByContractNumber(ContractRepository repository, int key){
        Contract[] contracts = repository.getRepository();
        ContractRepository foundObjRepository = new ContractRepository();
        for(int i = 0;i< repository.getContractsQuantity();i++){
            if(contracts[i].getContractNumber()==key){
                foundObjRepository.addContract(contracts[i]);
            }
        }
        return foundObjRepository;
    }
    public static ContractRepository searchByContractOwner(ContractRepository repository, User key){
        Contract[] contracts = repository.getRepository();
        ContractRepository foundObjRepository = new ContractRepository();
        for(int i = 0;i< repository.getContractsQuantity();i++){
            if(contracts[i].getContractOwner()==key){
                foundObjRepository.addContract(contracts[i]);
            }
        }
        return foundObjRepository;
    }

}

import Contracts.Contract;
import Contracts.DigitalTelevisionContract;
import Contracts.InternetContract;
import Contracts.MobileConnectionContract;
import Repository.Comparators;
import Repository.ContractRepository;
import Repository.PredicateBuilder;
import Users.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

/**
 * Класс unit тестирования функций bubbleSort, mergeSort, search клсса ContractRepository
 * @author Vadim Novoselov
 */
public class ContractRepositoryTest {
    public ContractRepository testRepository;
    InternetContract contract1;
    DigitalTelevisionContract contract2;
    MobileConnectionContract contract3;
    InternetContract contract4;
    MobileConnectionContract contract5;
    DigitalTelevisionContract contract6;

    /**
     * Функция создания тестовых данных, а также инициализации этих данных и репозитория
     */
    @Before
    public void createData(){
        testRepository = new ContractRepository();

        contract1 = new InternetContract();
        contract2  = new DigitalTelevisionContract();
        contract3 = new MobileConnectionContract();
        contract4 = new InternetContract();
        contract5 = new MobileConnectionContract();
        contract6  = new DigitalTelevisionContract();

        contract1.setContractId(1);
        contract2.setContractId(2);
        contract3.setContractId(3);
        contract4.setContractId(4);
        contract5.setContractId(5);
        contract6.setContractId(6);
        LocalDate contractStartDate1 = LocalDate.of(2020,6,7);
        LocalDate contractStartDate2 = LocalDate.of(2020,5,7);
        LocalDate contractStartDate3 = LocalDate.of(2020,4,7);
        LocalDate contractStartDate4 = LocalDate.of(2020,3,7);
        LocalDate contractStartDate5 = LocalDate.of(2020,2,7);
        LocalDate contractStartDate6 = LocalDate.of(2020,1,7);
        contract1.setContractStartDate(contractStartDate1);
        contract2.setContractStartDate(contractStartDate2);
        contract3.setContractStartDate(contractStartDate3);
        contract4.setContractStartDate(contractStartDate4);
        contract5.setContractStartDate(contractStartDate5);
        contract6.setContractStartDate(contractStartDate6);
        LocalDate contractEndDate1 = LocalDate.of(2025,6,7);
        LocalDate contractEndDate2 = LocalDate.of(2025,5,7);
        LocalDate contractEndDate3 = LocalDate.of(2025,4,7);
        LocalDate contractEndDate4 = LocalDate.of(2025,3,7);
        LocalDate contractEndDate5 = LocalDate.of(2025,2,7);
        LocalDate contractEndDate6 = LocalDate.of(2025,1,7);
        contract1.setContractEndDate(contractEndDate1);
        contract2.setContractEndDate(contractEndDate2);
        contract3.setContractEndDate(contractEndDate3);
        contract4.setContractEndDate(contractEndDate4);
        contract5.setContractEndDate(contractEndDate5);
        contract6.setContractEndDate(contractEndDate6);
        contract1.setContractNumber(110);
        contract2.setContractNumber(109);
        contract3.setContractNumber(108);
        contract4.setContractNumber(107);
        contract5.setContractNumber(106);
        contract6.setContractNumber(105);

        testRepository.addContract(contract1);
        testRepository.addContract(contract2);
        testRepository.addContract(contract3);
        testRepository.addContract(contract4);
        testRepository.addContract(contract5);
        testRepository.addContract(contract6);

    }

    /**
     * Тестирование функции bubbleSort. Проводится сортировка по id. Далее сравниваются отсортированные объекты с ожидаемым результатом.
     */
    @Test
    public void testBubbleSort(){
        testRepository.bubbleSort(Comparators.contractId);
        Contract[] expected = {contract1,contract2,contract3,contract4,contract5,contract6};
        boolean equal = true;
        for(int i =0;i<testRepository.getContractsQuantity();i++){
            if(testRepository.getContractOnId(i).equals(expected[i])!= true){
                equal = false;
            }
        }
        Assert.assertTrue(equal);
    }

    /**
     * Тестирование функции mergeSort. Проводится сортировка по дате начала контракта. Далее сравниваются отсортированные объекты с ожидаемым результатом.
     */
    @Test
    public void testMergeSort(){
        testRepository.mergeSort(Comparators.contractEndDate);
        Contract[] expected = {contract6,contract5,contract4,contract3,contract2,contract1};
        boolean equal = true;
        for(int i =0;i<testRepository.getContractsQuantity();i++){
            if(testRepository.getContractOnId(i).equals(expected[i])!= true){
                equal = false;
            }
        }
        Assert.assertTrue(equal);
    }

    /**
     * Тестирование функции testSearch. Проводится поиск по id==3. Далее сравнивается полученный результат с ожидаемым.
     */
    @Test
    public void testSearch(){
        ContractRepository expected = testRepository.search(PredicateBuilder.searchOnId(3));
        boolean passed = false;
        if(expected.getContractOnId(3).equals(contract3)){
            passed = true;
        }
        Assert.assertTrue(passed);
    }
    @Test(expected = FileNotFoundException.class)
    public void testContractDownloaderFNFException() throws IOException {
        testRepository.downloadContract(" ");
    }
    @Test
    public void testContractDownloader(){
        InternetContract contract = new InternetContract();
        User user = new User();
        user.setFio("Ivanov Ivan Ivanovich");
        contract.setContractOwner(user);
        testRepository.addContract(contract);
       Assert.assertTrue(9==testRepository.getContractsQuantity());

    }


}

package Repository;

import Contracts.Contract;

/**
 * @author Vadim Novoselov
 */
public class ContractRepository {
    /**
     * Массив типа Contract, хрянящий в себе контракты
     *
     */
    private Contract[] repository;
    /**
     * Поле, хранящее количество добавленных в репозиторий контрактов
     */
    private int contractsQuantity;
    /**
     * Переменная, определяющая на сколько увеличится репозиторий, когда он заполнится
     */
    private int delta=20;

    /**
     * Конструктор класса - Создает объект типа ContractRepository и инициализирует поле Contract[] repository
     */
    public ContractRepository()
    {
        repository = new Contract[delta];
    }

    /**
     * Функция добавления нового контракта в репозиторий
     * @param contract Контракт, который будет добавлен в репозиторий. Класс контракта должен являться наследником абстрактного класса Contract
     */
    public void addContract(Contract contract)
    {
        if (contractsQuantity >= repository.length) {
            repository = resizeRepository();
        }
        repository[contractsQuantity]=contract;
        contractsQuantity++;
    }

    /**
     * Функция, изменяющая размер текущего репозитория. Вызывается, когда при добавлении очередного контракта репозиторий уже заполнен. Увеличивает размер репозитория на delta
     * @return Возвращает репозиторий с увеличенным размером.
     */
    private Contract[] resizeRepository()
    {
        Contract[] newRepository = new Contract[contractsQuantity+delta];
        for(int i=0;i<repository.length;i++)
        {
            newRepository[i]=repository[i];
        }
        return newRepository;
    }

    /**
     * Функция удаления контракта из репозитория
     * @param contractId Значение id контракта, который необходимо удалить
     * @return Возвращает true, если контракт был успешно удален, false - если контракта с переданным значением id в репозитории не существует.
     */
    public boolean deleteContract(int contractId)
    {
        int i=0;
        for(i=0;i<contractsQuantity;i++)
        {
            if(repository[i].getContractId()==contractId)
            {
                break;
            }
        }
        if(i==contractsQuantity)
            return false;
        for(int j=i;j< repository.length-1;j++)
        {
            repository[j]=repository[j+1];

        }
        contractsQuantity--;
        return true;
    }

    /**
     * Функция получения контракта из репозитория
     * @param id Id контракта, который необходимо получить
     * @return Возвращает контракт, если контракт с переданным значением id был найден, null - если такого контракта в репозитории не существует.
     */
    public Contract getContractOnId(int id)
    {
        Contract contract;
        for(int i =0;i<contractsQuantity;i++)
        {
            if(repository[i].getContractId()==id)
            {
                return repository[i];
            }
        }
        return null;
    }

}

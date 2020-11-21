package Contracts;

import Users.User;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
/**
 * @author Vadim Novoselov
 */
public abstract class Contract {
    /**
     * Property - Id of the contract
     */
    private int contractId;
    /**
     * Property - start date of the contract
     */
    private LocalDate contractStartDate;
    /**
     * Property - end date of the contract
     */
    private LocalDate contractEndDate;
    /**
     * Property - number of the contract
     */
    private int contractNumber;
    /**
     * Property - owner of the contract
     */
    private User contractOwner;

    @Override
    public String toString() {
        return "Contract{" +
                "contractId=" + contractId +
                ", contractStartDate=" + contractStartDate +
                ", contractEndDate=" + contractEndDate +
                ", contractNumber=" + contractNumber +
                ", contractOwner=" + contractOwner +
                '}';
    }

    /**
     * @return current value of the contractId
     */
    public int getContractId() {
        return contractId;
    }

    /**
     * Changes the contractId value to the passed value
     * @param contractId - new value of the contractId
     */
    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return contractId == contract.contractId &&
                contractNumber == contract.contractNumber &&
                contractStartDate.equals(contract.contractStartDate) &&
                contractEndDate.equals(contract.contractEndDate) &&
                contractOwner.equals(contract.contractOwner);
    }


    /**
     * @return current value of the contractStartDate
     */
    public LocalDate getContractStartDate() {
        return contractStartDate;
    }
    /**
     * Changes the contractStartDate value to the passed value
     * @param contractStartDate - new value of the contractStartDate
     */
    public void setContractStartDate(LocalDate contractStartDate) {
        this.contractStartDate = contractStartDate;
    }
    /**
     * @return current value of the contractEndDate
     */
    public LocalDate getContractEndDate() {
        return contractEndDate;
    }
    /**
     * Changes the contractEndDate value to the passed value
     * @param contractEndDate - new value of the contractEndDate
     */
    public void setContractEndDate(LocalDate contractEndDate) {
        this.contractEndDate = contractEndDate;
    }
    /**
     * @return current value of the contractNumber
     */
    public int getContractNumber() {
        return contractNumber;
    }
    /**
     * Changes the contractNumber value to the passed value
     * @param contractNumber - new value of the contractNumber
     */
    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }
    /**
     * @return current value of the contractId
     */
    public User getContractOwner() {
        return contractOwner;
    }
    /**
     * Changes the contractOwner value to the passed value
     * @param contractOwner - new value of the contractOwner
     */
    public void setContractOwner(User contractOwner) {
        this.contractOwner = contractOwner;
    }

}

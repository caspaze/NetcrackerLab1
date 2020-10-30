package Contracts;

import Users.User;

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
    private Date contractStartDate;
    /**
     * Property - end date of the contract
     */
    private Date contractEndDate;
    /**
     * Property - number of the contract
     */
    private int contractNumber;
    /**
     * Property - owner of the contract
     */
    private User contractOwner;
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
    /**
     * @return current value of the contractStartDate
     */
    public Date getContractStartDate() {
        return contractStartDate;
    }
    /**
     * Changes the contractStartDate value to the passed value
     * @param contractStartDate - new value of the contractStartDate
     */
    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }
    /**
     * @return current value of the contractEndDate
     */
    public Date getContractEndDate() {
        return contractEndDate;
    }
    /**
     * Changes the contractEndDate value to the passed value
     * @param contractEndDate - new value of the contractEndDate
     */
    public void setContractEndDate(Date contractEndDate) {
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

package Contracts;

import Users.User;

import java.util.Date;

public abstract class Contract {
    private int contractId;
    private Date contractStartDate;
    private Date contractEndDate;
    private int contractNumber;

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    public User getContractOwner() {
        return contractOwner;
    }

    public void setContractOwner(User contractOwner) {
        this.contractOwner = contractOwner;
    }

    private User contractOwner;


}

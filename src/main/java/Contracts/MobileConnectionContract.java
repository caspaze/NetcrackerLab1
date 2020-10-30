package Contracts;

public class MobileConnectionContract extends Contract {
    /**
     * Property - quantity of available minutes in contract
     */
    private int minutesQuantity;
    /**
     * Property - quantity of available SMS in contract
     */
    private int SMSQuantity;
    /**
     * Property - quantity of available Gbs of the internet in contract
     */
    private int gbInternetQuantity;
    /**
     * @return current value of the minutesQuantity
     */
    public int getMinutesQuantity() {
        return minutesQuantity;
    }
    /**
     * Сhanges the minutesQuantity value to the passed value
     * @param minutesQuantity - new value of the minutesQuantity
     */
    public void setMinutesQuantity(int minutesQuantity) {
        this.minutesQuantity = minutesQuantity;
    }
    /**
     * @return current value of the SMSQuantity
     */
    public int getSMSQuantity() {
        return SMSQuantity;
    }
    /**
     * Сhanges the SMSQuantity value to the passed value
     * @param SMSQuantity - new value of the SMSQuantity
     */
    public void setSMSQuantity(int SMSQuantity) {
        this.SMSQuantity = SMSQuantity;
    }
    /**
     * @return current value of the gbInternetQuantity
     */
    public int getGbInternetQuantity() {
        return gbInternetQuantity;
    }
    /**
     * Сhanges the gbInternetQuantity value to the passed value
     * @param gbInternetQuantity - new value of the gbInternetQuantity
     */
    public void setGbInternetQuantity(int gbInternetQuantity) {
        this.gbInternetQuantity = gbInternetQuantity;
    }

}

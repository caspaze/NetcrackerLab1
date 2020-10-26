package Contracts;

public class MobileConnectionContract extends Contract {
    private int minutesQuantity;
    private int SMSQuantity;

    public int getMinutesQuantity() {
        return minutesQuantity;
    }

    public void setMinutesQuantity(int minutesQuantity) {
        this.minutesQuantity = minutesQuantity;
    }

    public int getSMSQuantity() {
        return SMSQuantity;
    }

    public void setSMSQuantity(int SMSQuantity) {
        this.SMSQuantity = SMSQuantity;
    }

    public int getGbInternetQuantity() {
        return GbInternetQuantity;
    }

    public void setGbInternetQuantity(int gbInternetQuantity) {
        GbInternetQuantity = gbInternetQuantity;
    }

    private int GbInternetQuantity;
}

package Contracts;

public class DigitalTelevisionContract extends Contract{
    /**
     * Property - package of channels
     */
    private ChannelPackages channelsPackage;
    /**
     * @return current value of the channelsPackage
     */
    public ChannelPackages getChannelsPackage() {
        return channelsPackage;
    }
    /**
     * Changes the channelsPackage value to the passed value
     * @param channelsPackage - new value of the channelsPackage
     */
    public void setChannelsPackage(ChannelPackages channelsPackage) {
        this.channelsPackage = channelsPackage;
    }
}

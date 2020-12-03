package Repository.Validate.ValidateTelevisionContract;

import Contracts.ChannelPackages;
import Contracts.DigitalTelevisionContract;
import Repository.Validate.Message;
import Repository.Validate.Status;

public class ChannelPackagesValidator implements TelevisionContractValidator {
    @Override
    public Message validate(DigitalTelevisionContract contract) {
        if(contract.getChannelsPackage()!= ChannelPackages.MinimumChannels &&
                contract.getChannelsPackage()!= ChannelPackages.AverageChannels &&
                contract.getChannelsPackage()!= ChannelPackages.MaximumChannels ){
            return new Message(Status.ERROR,"Such channel package don`t exists");
        }
        return new Message(Status.OK,"Permissible value of channel package");
    }
}

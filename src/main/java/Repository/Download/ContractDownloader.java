package Repository.Download;

import Contracts.ChannelPackages;
import Contracts.DigitalTelevisionContract;
import Contracts.InternetContract;
import Contracts.MobileConnectionContract;
import Repository.ContractRepository;
import Users.User;
import au.com.bytecode.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

public class ContractDownloader {
    private CSVReader reader;
    public void downloadContract(ContractRepository repository, String file) throws IOException, ParseException {
        reader = new CSVReader(new FileReader(file), ',' , '"' , 0);
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            if (nextLine != null) {
                LocalDate startDate = LocalDate.parse(nextLine[0]);
                LocalDate endDate = LocalDate.parse(nextLine[1]);
                String name = nextLine[2];
                String gender = nextLine[3];
                LocalDate birthDate = LocalDate.parse(nextLine[4]);
                int passportSeries = Integer.parseInt(nextLine[5]);
                int passportNumber = Integer.parseInt(nextLine[6]);
                String contractType = nextLine[7];
                User user = new User();
                user.setFio(name);
                user.setBirthDate(birthDate);
                user.setGender(gender);
                user.setPassportSeries(passportSeries);
                user.setPassportNumber(passportNumber);

                switch(contractType){
                    case "DigitalTelevisionContract":{
                        DigitalTelevisionContract contract = new DigitalTelevisionContract();
                        contract.setContractStartDate(startDate);
                        contract.setContractEndDate(endDate);
                        contract.setContractOwner(user);

                        switch(nextLine[8]){
                            case "Minimum Channels":{
                                contract.setChannelsPackage(ChannelPackages.MinimumChannels);
                                break;
                            }
                            case "Average Channels":{
                                contract.setChannelsPackage(ChannelPackages.AverageChannels);
                                break;
                            }
                            case "Maximum Channels":{
                                contract.setChannelsPackage(ChannelPackages.MaximumChannels);
                                break;
                            }
                        }

                        repository.addContract(contract);
                        break;
                    }
                    case "InternetContract":{
                        InternetContract contract = new InternetContract();
                        contract.setContractStartDate(startDate);
                        contract.setContractEndDate(endDate);
                        contract.setContractOwner(user);

                        contract.setConnectionSpeed(Double.parseDouble(nextLine[8]));

                        repository.addContract(contract);
                        break;
                    }
                    case "MobileConnectionContract":{
                        MobileConnectionContract contract = new MobileConnectionContract();
                        contract.setContractStartDate(startDate);
                        contract.setContractEndDate(endDate);
                        contract.setContractOwner(user);

                        contract.setMinutesQuantity(Integer.parseInt(nextLine[8]));
                        contract.setSMSQuantity(Integer.parseInt(nextLine[9]));
                        contract.setGbInternetQuantity(Integer.parseInt(nextLine[10]));

                        repository.addContract(contract);
                        break;
                    }
                }
            }
        }
    }
}


package com.blackbird_labs.azuretest.exec;

import com.blackbird_labs.azuretest.model.YellowTrips;
import com.blackbird_labs.azuretest.repository.YellowTripsRepository;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import javax.transaction.Transactional;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AzureUpload {
    private static final String SAMPLE_CSV_FILE_PATH = "C:\\Users\\ahrushko\\Downloads\\yellow_tripdata_2017-02.csv";

    @Autowired
    private YellowTripsRepository yellowTripsRepository;

    @GetMapping("/azure")
    @Transactional
    public void uploadAzure() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            for (CSVRecord csvRecord : csvParser) {
                if (csvRecord.get(0).equals("VendorID")) {
                    System.out.println("First line");
                    continue;
                }

                YellowTrips yellowTrips = new YellowTrips();
                yellowTrips.setVendor_id(csvRecord.get(0));
                yellowTrips.setPickup_datetime(formatter.parse(csvRecord.get(1)));
                yellowTrips.setDropoff_datetime(formatter.parse(csvRecord.get(2)));
                yellowTrips.setPassenger_count(Integer.parseInt(csvRecord.get(3)));
                yellowTrips.setTrip_distance(Double.parseDouble(csvRecord.get(4)));
                yellowTrips.setRate_code(Integer.parseInt(csvRecord.get(5)));
                yellowTrips.setStore_and_fwd_flag(csvRecord.get(6).charAt(0));
                yellowTrips.setPULocationID(Integer.parseInt(csvRecord.get(7)));
                yellowTrips.setDOLocationID(Integer.parseInt(csvRecord.get(8)));
                yellowTrips.setPayment_type(Integer.parseInt(csvRecord.get(9)));
                yellowTrips.setFare_amount(Double.parseDouble(csvRecord.get(10)));
                yellowTrips.setExtra(Double.parseDouble(csvRecord.get(11)));
                yellowTrips.setMta_tax(Double.parseDouble(csvRecord.get(12)));
                yellowTrips.setTip_amount(Double.parseDouble(csvRecord.get(13)));
                yellowTrips.setTolls_amount(Double.parseDouble(csvRecord.get(14)));
                yellowTrips.setImprovement_surcharge(Double.parseDouble(csvRecord.get(15)));
                yellowTrips.setTotal_amount(Double.parseDouble(csvRecord.get(16)));
                System.out.println("Saving record: " + yellowTrips);

                yellowTripsRepository.saveAndFlush(yellowTrips);
                System.out.println("Saved");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

package com.example.vindecoder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class DecoderService {
    public CarFeatures decode(String vin) {
        validate(vin);

        return CarFeatures.builder()
                .vin(vin)
                .region(getRegion(vin))
                .country(getCountry(vin))
                .modelYear(getModelYear(vin))
                .manufacturer(getManufacturer(vin))
                .build();
    }

    private String getModelYear(String vin) {
        return DataService.MODEL_YEARS.get(vin.charAt(9));
    }

    private void validate(String vin) {
        boolean isCorrectFormat = vin.matches(
                "([0-9A-HJ-NPR-Z]{3})([0-9A-HJ-NPR-Z]{6})([0-9A-HJ-NPR-Z]{8})");
        if (!isCorrectFormat) {
            throw new WrongVinFormat();
        }
    }

    private String getManufacturer(String vin) {
        String manufacturer = DataService.MANUFACTURERS.get(vin.substring(0, 3));
        if (manufacturer == null) {
            return DataService.MANUFACTURERS.get(vin.substring(0, 2));
        }
        return manufacturer;
    }

    private String getRegion(String vin) {
        String firstLetter = String.valueOf(vin.charAt(0));
        if (firstLetter.matches("[A-H]")) {
            return "Africa";
        }
        if (firstLetter.matches("[J-R]")) {
            return "Asia";
        }
        if (firstLetter.matches("[S-Z]")) {
            return "Europe";
        }
        if (firstLetter.matches("[8-9]")) {
            return "South America";
        }
        String firstTwoLetters = vin.substring(0, 2);
        if (firstTwoLetters.matches("6|[7A-E]{2}")) {
            return "Oceania";
        }
        return "United States";
    }

    private String getCountry(String vin) {
        String countryCode = vin.substring(0, 2);

        Optional<Map.Entry<String, String>> optionalEntry = DataService.COUNTRIES.entrySet().stream()
                .filter(a -> countryCode.matches(a.getKey())).findAny();

        return optionalEntry.map(Map.Entry::getValue).orElse(null);
    }
}

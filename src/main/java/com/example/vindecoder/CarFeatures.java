package com.example.vindecoder;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
@Getter
public class CarFeatures {
    private String vin;
    private String region;
    private String country;
    private String manufacturer;
    private String modelYear;
}

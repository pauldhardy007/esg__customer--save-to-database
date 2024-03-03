package org.esg.exercise.util;

import org.esg.exercise.dto.CustomerDto;
import org.esg.exercise.entity.CustomerEntity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Long.parseLong;
import static java.util.Objects.requireNonNull;

public class TestHelper {

    public static final String CUSTOMER_REF = "123456";
    public static final String CUSTOMER_NAME = "Fred Blogs";
    public static final String ADDRESS_LINE_ONE = "1 Some Road";
    public static final String ADDRESS_LINE_TWO = "Some Area";
    public static final String TOWN = "Townton";
    public static final String COUNTY = "Warwickshire";
    public static final String COUNTRY = "England";
    public static final String POSTCODE = "WE12 0DF";

    public static CustomerEntity getTestCustomerEntity() {
        return CustomerEntity.builder()
                .customerRef(parseLong(CUSTOMER_REF))
                .customerName(CUSTOMER_NAME)
                .addressLineOne(ADDRESS_LINE_ONE)
                .addressLineTwo(ADDRESS_LINE_TWO)
                .town(TOWN)
                .county(COUNTY)
                .country(COUNTRY)
                .postcode(POSTCODE)
                .build();
    }

    public static String getJsonFromFile(String jsonFilePath) throws FileNotFoundException {
        String filePath = new TestHelper().getResourceFilePath(jsonFilePath);
        Scanner scanner = getScanner(filePath);
        String json = "";
        while (scanner.hasNextLine()) {
            json = json.concat(scanner.nextLine())
                    .replace(" ", "");
        }
        return json;
    }

    private static Scanner getScanner(String filePath) throws FileNotFoundException {
        return new Scanner(new File(filePath));
    }

    public static CustomerDto getTestCustomerDto() {
        return CustomerDto.builder()
                .customerRef(CUSTOMER_REF)
                .customerName(CUSTOMER_NAME)
                .addressLineOne(ADDRESS_LINE_ONE)
                .addressLineTwo(ADDRESS_LINE_TWO)
                .town(TOWN)
                .county(COUNTY)
                .country(COUNTRY)
                .postcode(POSTCODE)
                .build();
    }

    public String getResourceFilePath(final String filePath) {
        return requireNonNull(this.getClass()
                .getResource(filePath))
                .getPath();
    }
}

package ua.lviv.iot.databaseslab4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Drug {
    private Integer id;
    private String name;
    private Date productionDate;
    private Date expirationDate;
    private boolean isAvailable;
    private double priceInDollars;
    private Integer producerId;
    private Integer drugstoreId;

}

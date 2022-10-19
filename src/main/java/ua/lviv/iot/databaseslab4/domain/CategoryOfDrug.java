package ua.lviv.iot.databaseslab4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryOfDrug {

    private Integer id;
    private boolean requiredPrescription;
    private String type;
    private Integer drugId;
}

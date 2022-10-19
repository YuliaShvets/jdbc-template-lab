package ua.lviv.iot.databaseslab4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CompositionOfDrug {
    private Integer id;
    private String activeIngredients;
    private Integer drugId;
}

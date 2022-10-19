package ua.lviv.iot.databaseslab4.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Department {
    private Integer id;
    private int number;
    private Integer drugstoreId;

}

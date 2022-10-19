package ua.lviv.iot.databaseslab4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PrimaryPackage {
    private Integer id;
    private String typePackaging;
    private Integer drugId;
}


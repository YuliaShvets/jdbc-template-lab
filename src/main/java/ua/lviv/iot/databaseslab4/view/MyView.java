package ua.lviv.iot.databaseslab4.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.lviv.iot.databaseslab4.controller.*;

@Component
public class MyView {

    @Autowired
    private CategoryOfDrugController categoryOfDrugController;

    @Autowired
    private CityController cityController;

    @Autowired
    private CompositionOfDrugController compositionOfDrugController;

    @Autowired
    private CountryController countryController;

    @Autowired
    private DepartmentController departmentController;

    @Autowired
    private DrugController drugController;

    @Autowired
    private DrugstoreController drugstoreController;

    @Autowired
    private LocationController locationController;

    @Autowired
    private PrimaryPackageController primaryPackageController;

    @Autowired
    private ProducerController producerController;

    @Autowired
    private UseOfDrugController useOfDrugController;

}

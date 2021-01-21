package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.MedPlanServiceImpl;
import ro.tuc.ds2020.MedicationInterface;
import ro.tuc.ds2020.services.IngrijitorService;
import ro.tuc.ds2020.services.MedPlanService;


@RestController
@CrossOrigin
public class IndexController {

    private final MedPlanService mdplan;
    @Autowired
    public IndexController(MedPlanService personService) {
        this.mdplan = personService;
    }
    @Bean(name = "/service")
    HttpInvokerServiceExporter accountService() {
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setService( new MedPlanServiceImpl(mdplan) );
        exporter.setServiceInterface( MedicationInterface.class );
        return exporter;
    }

    @GetMapping(value = "/")
    public ResponseEntity<String> getStatus() {
        return new ResponseEntity<>("City APP Service is running...", HttpStatus.OK);
    }
}

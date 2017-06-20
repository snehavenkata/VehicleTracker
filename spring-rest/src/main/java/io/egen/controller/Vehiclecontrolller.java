package io.egen.controller;

import io.egen.Service.VehicleService;
import io.egen.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@Component
@RestController
@RequestMapping(value="vehicles")

public class Vehiclecontrolller {
    @Autowired
    private VehicleService Service;

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> findAll() {
        return Service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{vin}",
         produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
   public Vehicle findOne(@PathVariable("vin") String vinId) {

      return Service.findOne(vinId);
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle create(@RequestBody Vehicle[] vehicle) {

    return Service.create(vehicle);
    }



   @RequestMapping(method = RequestMethod.DELETE, value = "{vin}")
    public void delete(@PathVariable("vin") String vehicle) {

    Service.delete(vehicle);
   }
}

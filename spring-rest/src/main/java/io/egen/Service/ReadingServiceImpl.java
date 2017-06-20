package io.egen.Service;


import io.egen.Exception.BadRequestException;
import io.egen.Repository.ReadingRepository;
import io.egen.Repository.VehicleRepository;
import io.egen.entity.Alerts;
import io.egen.entity.Readings;
import io.egen.entity.Tires;
import io.egen.entity.Vehicle;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ReadingServiceImpl implements ReadingService{
    @Autowired
    private ReadingRepository repository ;


    @Override
    @Transactional(readOnly = true)
    public List<Readings> findAll() {

        return repository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Readings findOne(String vin) {

        Readings readings = repository.findOne(vin);
        if (readings == null) {
            try {
                throw new NotFoundException("Vehicle with vin=" +  vin + " not found");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
        return readings;
    }

    @Override
    @Transactional
    public Readings create(Readings readings) {
        String message;
        Alerts obj = new Alerts();
        if(readings != null){
            Tires tiresvalue = readings.getTires();
            if (tiresvalue.getFrontLeft() < 32 || tiresvalue.getFrontLeft() > 36 || tiresvalue.getFrontRight() < 32 || tiresvalue.getFrontRight() > 36
                    || tiresvalue.getRearLeft() < 32 || tiresvalue.getRearLeft() > 36 || tiresvalue.getRearRight() < 32 || tiresvalue.getRearRight() > 36) {

                repository.CreateAlert(readings.getVin(), "Tire Pressure is Low", "Low");
            }

            if (readings.getCheckEngineLightOn() || readings.getEngineCoolantLow()) {

                repository.CreateAlert(readings.getVin(), " attention is needed for ", "Low");

            }

            return  repository.create(tiresvalue, readings);
        } else
            throw new BadRequestException("No data found in " + readings);
    }




    // @Override
    // @Transactional
    // public Vehicle update(String vin, Vehicle vehicle) throws NotFoundException {
    //     Vehicle existing = repository.findOne(vin);
    //    if (existing == null) {
    //      throw new NotFoundException("Vehicle with vin=" + vin + " not found");
    //  }
    // return repository.update(vehicle);
    //}




    @Override
    @Transactional
    public void delete(String vin) {
        Readings existing = repository.findOne(vin);
        if (existing == null) {
            try {
                throw new NotFoundException("Readings with vin=" + vin + " not found");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
        repository.delete(existing);
    }
}



package io.egen.Service;


import io.egen.Exception.BadRequestException;
import io.egen.Repository.VehicleRepository;
import io.egen.entity.Vehicle;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleRepository repository ;


    @Override
    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {

            return repository.findAll();
        }


    @Override
    @Transactional(readOnly = true)
    public Vehicle findOne(String vin) {

        Vehicle vehicle = repository.findOne(vin);
        if (vehicle == null) {
            try {
                throw new NotFoundException ("Vehicle with vin=" +  vin + " not found");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
        return vehicle;
    }

    @Override
    @Transactional
    public Vehicle create(Vehicle[] vehicle) {
        for (int i = 0; i < vehicle.length; i++) {
            Vehicle existing = repository.findByvin(vehicle[i].getVin());
            if (existing != null) {

                repository.create(vehicle[i]);
            }
            repository.update(vehicle[i]);

        }
        return null;
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
        Vehicle existing = repository.findOne(vin);
        if (existing == null) {
            try {
                throw new NotFoundException("Vehicle with vin=" + vin + " not found");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
        repository.delete(existing);
    }
}







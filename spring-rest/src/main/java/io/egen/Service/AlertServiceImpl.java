package io.egen.Service;


import io.egen.Repository.AlertRepository;
import io.egen.Repository.VehicleRepository;
import io.egen.entity.Alerts;
import io.egen.entity.Readings;
import io.egen.entity.Vehicle;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class AlertServiceImpl implements AlertService {


    @Autowired
    private AlertRepository repository;


    @Override
    @Transactional(readOnly = true)
    public List<Alerts> findAll() {

        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Alerts> findByVin(String vin) {

        return repository.findByVin(vin);
    }


}


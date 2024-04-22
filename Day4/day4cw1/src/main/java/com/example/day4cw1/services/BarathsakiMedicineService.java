package com.example.day4cw1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.day4cw1.model.Medicine;
import com.example.day4cw1.repository.MedicineRepo;

@Service
public class BarathsakiMedicineService {
    public MedicineRepo medicineRepo;
    public BarathsakiMedicineService(MedicineRepo medicineRepo)
    {
        this.medicineRepo = medicineRepo;
    }
    public boolean saveMedicine(Medicine medicine)
    {
        try{
            medicineRepo.save(medicine);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<Medicine> getMedicines()
    {
        return medicineRepo.findAll();
    }

    public Medicine MedicineById(int id)
    {
        Optional<Medicine> obj = medicineRepo.findById(id);
        return obj.orElse(new Medicine());
    }

}

package org.azanar.models;

import org.azanar.entities.InsuranceEntity;
import org.azanar.entities.InsurersEntity;
import org.azanar.repositories.InsuranceRepository;
import org.azanar.repositories.InsurersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InsuranceServiceImp implements InsuranceService{
    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private InsuranceMapper insuranceMapper;

    @Override
    public void create(InsuranceDTO insuranceDTO) {
        InsuranceEntity insuranceEntity = new InsuranceEntity();

        insuranceEntity = insuranceMapper.toEntity(insuranceDTO);

        try {
            insuranceRepository.save(insuranceEntity);
        } catch (DataIntegrityViolationException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public List<InsuranceDTO> getAll() {
        List<InsuranceDTO> insurance = new ArrayList<>();

        Iterable<InsuranceEntity> fetchedArticles = insuranceRepository.findAll();
        for (InsuranceEntity articleEntity : fetchedArticles) {
            InsuranceDTO mappedInsurers = insuranceMapper.toDTO(articleEntity);
            insurance.add(mappedInsurers);
        }

        return insurance;
    }

    @Override
    public InsuranceDTO getById(long insuranceId) {
        InsuranceEntity fetchedInsurance = insuranceRepository.findById(insuranceId).orElseThrow();

        return insuranceMapper.toDTO(fetchedInsurance);
    }

    @Override
    public InsuranceDTO getByEmail(String email) {
        InsuranceEntity fetchedInsurance = insuranceRepository.findByEmail(email).orElseThrow();

        return insuranceMapper.toDTO(fetchedInsurance);
    }

    @Override
    public void edit(InsuranceDTO insurance) {
        InsuranceEntity fetchedInsurance = insuranceRepository.findById(insurance.getUserId()).orElseThrow();

        insuranceMapper.updateInsuranceEntity(insurance, fetchedInsurance);
        insuranceRepository.save(fetchedInsurance);
    }

    @Override
    public void remove(long insurerId) {
        InsuranceEntity fetchedInsurance = insuranceRepository.findById(insurerId).orElseThrow();
        insuranceRepository.delete(fetchedInsurance);
    }
}

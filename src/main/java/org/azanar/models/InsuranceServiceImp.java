package org.azanar.models;

import org.azanar.entities.InsuranceEntity;
import org.azanar.repositories.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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
    public List<InsuranceDTO> getByEmail(String email) {
        List<InsuranceDTO> insurance = new ArrayList<>();

        Iterable<InsuranceEntity> fetchedArticles = insuranceRepository.findAll();
        for (InsuranceEntity articleEntity : fetchedArticles) {
            InsuranceDTO mappedInsurers = insuranceMapper.toDTO(articleEntity);
            if (mappedInsurers.getEmail().equals(email)) {
                insurance.add(mappedInsurers);
            }
        }
        return insurance;
    }

    @Override
    public void edit(InsuranceDTO insurance) {
        InsuranceEntity fetchedInsurance = insuranceRepository.findById(insurance.getId()).orElseThrow();

        insuranceMapper.updateInsuranceEntity(insurance, fetchedInsurance);
        insuranceRepository.save(fetchedInsurance);
    }

    @Override
    public void remove(long insurerId) {
        InsuranceEntity fetchedInsurance = insuranceRepository.findById(insurerId).orElseThrow();
        insuranceRepository.delete(fetchedInsurance);
    }
}

package org.azanar.models;

import org.azanar.entities.InsurersEntity;
import org.azanar.repositories.InsurersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InsurersServiceImp implements InsurersService{
    @Autowired
    private InsurersRepository insurersRepository;

    @Autowired
    private InsurersMapper insurersMapper;

    @Override
    public void create(InsurersDTO insurersDTO) {
        InsurersEntity insurersEntity = new InsurersEntity();
        insurersEntity = insurersMapper.toEntity(insurersDTO);
        try {
            insurersRepository.save(insurersEntity);
        } catch (DataIntegrityViolationException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public List<InsurersDTO> getAll() {
        List<InsurersDTO> insurers = new ArrayList<>();

        Iterable<InsurersEntity> fetchedArticles = insurersRepository.findAll();
        for (InsurersEntity articleEntity : fetchedArticles) {
            InsurersDTO mappedInsurers = insurersMapper.toDTO(articleEntity);
            insurers.add(mappedInsurers);
        }

        return insurers;
    }

    @Override
    public InsurersDTO getById(long insurerId) {
        InsurersEntity fetchedInsurer = insurersRepository.findById(insurerId).orElseThrow();

        return insurersMapper.toDTO(fetchedInsurer);
    }

    @Override
    public void edit(InsurersDTO insurer) {
        InsurersEntity fetchedInsurer = insurersRepository.findById(insurer.getUserId()).orElseThrow();

        insurersMapper.updateInsurersEntity(insurer, fetchedInsurer);
        insurersRepository.save(fetchedInsurer);
    }

    @Override
    public void remove(long insurerId) {
        InsurersEntity fetchedInsurer = insurersRepository.findById(insurerId).orElseThrow();
        insurersRepository.delete(fetchedInsurer);
    }
}

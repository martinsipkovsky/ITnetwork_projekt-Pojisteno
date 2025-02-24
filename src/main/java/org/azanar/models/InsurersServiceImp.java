package org.azanar.models;

import org.azanar.entities.InsurersEntity;
import org.azanar.repositories.InsurersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class InsurersServiceImp implements InsurersService{
    @Autowired
    private InsurersRepository insurersRepository;

    @Override
    public void create(InsurersDTO insurersDTO) {
        InsurersEntity insurersEntity = new InsurersEntity();

        insurersEntity.setFirstname(insurersDTO.getFirstname());
        insurersEntity.setLastname(insurersDTO.getLastname());
        insurersEntity.setEmail(insurersDTO.getEmail());
        insurersEntity.setPhoneNumber(insurersDTO.getPhoneNumber());
        insurersEntity.setStreet(insurersDTO.getStreet());
        insurersEntity.setCity(insurersDTO.getCity());
        insurersEntity.setPostalCode(insurersDTO.getPostalCode());

        try {
            insurersRepository.save(insurersEntity);
        } catch (DataIntegrityViolationException e) {
            System.out.println(e.toString());
        }
    }
}

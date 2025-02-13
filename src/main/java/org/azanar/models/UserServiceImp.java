package org.azanar.models;

import org.azanar.entities.UserEntity;
import org.azanar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(UserDTO user) {
        UserEntity userEntity = new UserEntity();

        userEntity.setJmeno(user.getSurename());
        userEntity.setPrijmeni(user.getLastname());
        userEntity.setEmail(user.getEmail());
        userEntity.setTelefon(user.getTelephone());
        userEntity.setHeslo(user.getPassword());

        userRepository.save(userEntity);
    }
}

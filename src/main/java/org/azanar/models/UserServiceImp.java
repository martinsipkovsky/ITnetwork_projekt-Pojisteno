package org.azanar.models;

import org.azanar.entities.UserEntity;
import org.azanar.exceptions.PasswordsDoNotEqualException;
import org.azanar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.azanar.exceptions.DuplicateEmailException;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void create(UserDTO user, boolean isAdmin) throws PasswordsDoNotEqualException, DuplicateEmailException {
        if (!user.getPassword().equals(user.getConfirmPassword()))
            throw new PasswordsDoNotEqualException();
        UserEntity userEntity = new UserEntity();

        userEntity.setJmeno(user.getFirstname());
        userEntity.setPrijmeni(user.getLastname());
        userEntity.setEmail(user.getEmail());
        userEntity.setTelefon(user.getPhoneNumber());
        userEntity.setHeslo(passwordEncoder.encode(user.getPassword()));
        userEntity.setAdmin(isAdmin);

        try {
            userRepository.save(userEntity);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException();
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username, " + username + " not found"));
    }
}

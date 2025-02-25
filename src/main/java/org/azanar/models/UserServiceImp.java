package org.azanar.models;

import org.azanar.entities.InsurersEntity;
import org.azanar.entities.UserEntity;
import org.azanar.exceptions.PasswordsDoNotEqualException;
import org.azanar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.User;
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

    @Autowired
    private UserMapper userMapper;

    @Override
    public void create(UserDTO user, boolean isAdmin) throws PasswordsDoNotEqualException, DuplicateEmailException {
        if (!user.getPassword().equals(user.getConfirmPassword()))
            throw new PasswordsDoNotEqualException();
        UserEntity userEntity = new UserEntity();

        userEntity.setFirstname(user.getFirstname());
        userEntity.setLastname(user.getLastname());
        userEntity.setEmail(user.getEmail());
        userEntity.setPhoneNumber(user.getPhoneNumber());
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        userEntity.setAdmin(isAdmin);

        try {
            userRepository.save(userEntity);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException();
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if (email == null || email.isEmpty()) {
            throw new UsernameNotFoundException("Email je prázdný nebo null");
        }

        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Uživatel nenalezen: " + email));

        System.out.println("Nalezen uživatel: " + user.getEmail() + " | Heslo: " + user.getPassword());

        return user;
    }

    @Override
    public UserDTO getByEmail(String email) {
        UserEntity fetchedUser = userRepository.findByEmail(email).orElseThrow();

        return userMapper.toDTO(fetchedUser);
    }

}

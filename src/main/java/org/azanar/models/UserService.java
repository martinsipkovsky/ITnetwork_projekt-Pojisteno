package org.azanar.models;

import org.azanar.exceptions.DuplicateEmailException;
import org.azanar.exceptions.PasswordsDoNotEqualException;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {
    void create(UserDTO user, boolean isAdmin) throws PasswordsDoNotEqualException, DuplicateEmailException;
    public UserDTO getByEmail(String email);
    List<UserDTO> getAll();
}

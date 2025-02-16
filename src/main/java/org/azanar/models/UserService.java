package org.azanar.models;

import org.azanar.exceptions.DuplicateEmailException;
import org.azanar.exceptions.PasswordsDoNotEqualException;
import org.azanar.models.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    void create(UserDTO user, boolean isAdmin) throws PasswordsDoNotEqualException, DuplicateEmailException;
}

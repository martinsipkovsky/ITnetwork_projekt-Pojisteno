package org.azanar.models;

import org.azanar.exceptions.DuplicateEmailException;
import org.azanar.exceptions.PasswordsDoNotEqualException;
import org.azanar.models.UserDTO;


public interface UserService {
    void create(UserDTO user, boolean isAdmin) throws PasswordsDoNotEqualException, DuplicateEmailException;
}

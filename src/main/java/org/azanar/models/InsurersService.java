package org.azanar.models;

import java.util.List;

public interface InsurersService {
    void create(InsurersDTO insurersDTO);
    List<InsurersDTO> getAll();
    public InsurersDTO getById(long insurerIs);
    public InsurersDTO getByEmail(String email);
    void edit(InsurersDTO insurer);
    void remove(long insurerId);

}

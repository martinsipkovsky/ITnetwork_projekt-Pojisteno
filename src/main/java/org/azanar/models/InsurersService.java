package org.azanar.models;

import java.util.List;

public interface InsurersService {
    void create(InsurersDTO insurersDTO);
    List<InsurersDTO> getAll();
    public InsurersDTO getById(long insurerIs);
    void edit(InsurersDTO insurer);
}

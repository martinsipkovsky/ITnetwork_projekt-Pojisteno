package org.azanar.models;

import java.util.List;

public interface InsuranceService {
    void create(InsuranceDTO insuranceDTO);
    List<InsuranceDTO> getAll();
    public InsuranceDTO getById(long insuranceId);
    public List<InsuranceDTO> getByEmail(String email);
    void edit(InsuranceDTO insurance);
    void remove(long insuranceId);
}

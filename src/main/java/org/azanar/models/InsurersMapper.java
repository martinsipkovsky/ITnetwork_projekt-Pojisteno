package org.azanar.models;

import org.azanar.entities.InsurersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface InsurersMapper {
    InsurersEntity toEntity(InsurersDTO source);
    InsurersDTO toDTO(InsurersEntity source);

    void updateInsurersDTO(InsurersDTO source, @MappingTarget InsurersDTO target);
    void updateInsurersEntity(InsurersDTO source, @MappingTarget InsurersEntity target);
}

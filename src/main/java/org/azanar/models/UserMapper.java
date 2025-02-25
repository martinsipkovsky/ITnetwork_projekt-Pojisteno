package org.azanar.models;

import org.azanar.entities.InsurersEntity;
import org.azanar.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(UserDTO source);
    UserDTO toDTO(UserEntity source);

    void updateInsurersDTO(UserDTO source, @MappingTarget UserDTO target);
    void updateInsurersEntity(UserDTO source, @MappingTarget UserDTO target);
}

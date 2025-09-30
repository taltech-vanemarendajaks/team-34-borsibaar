package com.borsibaar.backend.mapper;

import com.borsibaar.backend.dto.UserDTO;
import com.borsibaar.backend.entity.Role;
import com.borsibaar.backend.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mapping(target = "role", source = "user.role", qualifiedByName = "roleToName")
    @Mapping(target = "token", source = "token")
    UserDTO toDto(User user, String token);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "organizationId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "role", source = "role") // uses map(String)->Role below
    User toEntity(UserDTO dto);

    @Named("roleToName")
    default String roleToName(Role role) { return role == null ? null : role.getName(); }

    default Role map(String roleName) {
        if (roleName == null) return null;
        Role r = new Role();
        r.setName(roleName);
        return r;
    }
}

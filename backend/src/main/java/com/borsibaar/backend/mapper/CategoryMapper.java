package com.borsibaar.backend.mapper;

import com.borsibaar.backend.dto.CategoryRequestDto;
import com.borsibaar.backend.dto.CategoryResponseDto;
import com.borsibaar.backend.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "organizationId", ignore = true)
    Category toEntity(CategoryRequestDto request);

    CategoryResponseDto toResponse(Category category);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "organizationId", ignore = true)
    void updateEntity(@MappingTarget Category category, CategoryRequestDto request);
}

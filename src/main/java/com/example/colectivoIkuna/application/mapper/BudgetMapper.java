package com.example.colectivoIkuna.application.mapper;

import com.example.colectivoIkuna.application.dto.BudgetDTO;
import com.example.colectivoIkuna.domain.model.Budget;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BudgetMapper {

    @Mapping(source = "budgetId", target = "id")
    @Mapping(source = "projectId", target = "project", qualifiedByName = "mapProjectIdToProject")
    Budget toEntity(BudgetDTO dto);

    @Mapping(source = "id", target = "budgetId")
    @Mapping(source = "id", target = "projectId")
    BudgetDTO toDto(Budget entity);

    /* convertir long a objeto para evitar error en tipo de datos

    @Named("mapProjectIdToProject")
    default Project mapProjectIdToProject(Long projectId) {
        if (projectId == null) {
            return null;
        }
        return Project.builder()
                .id(projectId)
                .build();
    }
*/

}

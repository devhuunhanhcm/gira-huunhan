package springbootapplication.girahuunhan.role.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import springbootapplication.girahuunhan.role.Dto.GiraGroupDTO;
import springbootapplication.girahuunhan.role.Dto.GiraGroupWithRolesDTO;
import springbootapplication.girahuunhan.role.model.GiraGroup;

@Mapper
public interface GiraGroupMapper {
	GiraGroupMapper INSTANCE = Mappers.getMapper(GiraGroupMapper.class);
	GiraGroupDTO toDTO(GiraGroup entity);
	GiraGroup toEntity(GiraGroupDTO dto);
	GiraGroupWithRolesDTO toDtoWithRole(GiraGroup modifiedGroup);
}

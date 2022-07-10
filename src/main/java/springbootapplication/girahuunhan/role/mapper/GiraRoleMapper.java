package springbootapplication.girahuunhan.role.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import springbootapplication.girahuunhan.role.Dto.GiraRoleDTO;
import springbootapplication.girahuunhan.role.model.GiraRole;

@Mapper
public interface GiraRoleMapper {
	GiraRoleMapper INSTANCE = Mappers.getMapper(GiraRoleMapper.class);
	GiraRole mapToEntity(GiraRoleDTO dto);
	GiraRoleDTO mapToDTO(GiraRole entity);
}

package springbootapplication.girahuunhan.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import springbootapplication.girahuunhan.user.dto.GiraUserDTO;
import springbootapplication.girahuunhan.user.model.GiraUser;

@Mapper
public interface GiraUserMapper {
	GiraUserMapper INSTANCE = Mappers.getMapper(GiraUserMapper.class);

	GiraUser toModel(GiraUserDTO dto);

	GiraUserDTO toDTO(GiraUser model);
}

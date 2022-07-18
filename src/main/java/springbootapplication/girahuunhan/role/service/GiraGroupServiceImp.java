package springbootapplication.girahuunhan.role.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootapplication.girahuunhan.role.Dto.GiraGroupDTO;
import springbootapplication.girahuunhan.role.Dto.GiraGroupWithRolesDTO;
import springbootapplication.girahuunhan.role.mapper.GiraGroupMapper;
import springbootapplication.girahuunhan.role.model.GiraGroup;
import springbootapplication.girahuunhan.role.model.GiraRole;
import springbootapplication.girahuunhan.role.repository.GiraGroupRepository;
import springbootapplication.girahuunhan.role.repository.GiraRoleRepository;

@Service
public class GiraGroupServiceImp implements GiraGroupService {
	@Autowired
	private GiraGroupRepository repository;
	
	@Autowired
	private GiraRoleRepository roleRepository;
	
	@Override
	public List<GiraGroupDTO> findAllGroup() {
		List<GiraGroupDTO> groups = repository.findAll().stream()
											.map(t -> GiraGroupMapper.INSTANCE.toDTO(t))
											.collect(Collectors.toList());
		return groups;
	}
	@Override
	public GiraGroupDTO createNewGroup(GiraGroupDTO dto) {
		GiraGroup group = GiraGroupMapper.INSTANCE.toEntity(dto);
		GiraGroup newGroup = repository.save(group);
		return GiraGroupMapper.INSTANCE.toDTO(newGroup);
	}
	@Override
	public GiraGroupWithRolesDTO addRole(String groupId, String roleId) {
		GiraGroup group;
		GiraRole role;
		GiraGroupWithRolesDTO dto;
		try {
			group = repository.getById(UUID.fromString(groupId));
			role = roleRepository.getById(UUID.fromString(roleId));
			group.addRole(role);
			GiraGroup  modifiedGroup = repository.save(group);
			
			dto = GiraGroupMapper.INSTANCE.toDtoWithRole(modifiedGroup);
			return dto;
		}
		catch (EntityNotFoundException ex) {
			return null;
		}
	}
	@Override
	public GiraGroupWithRolesDTO removeRole(String groupId, String roleId) {
		GiraRole role;
		GiraGroup group;
		try {
			group = repository.getById(UUID.fromString(groupId));
			role = roleRepository.getById(UUID.fromString(roleId));
			group.removeRole(role);
			GiraGroup modifiedGroup = repository.save(group);
			GiraGroupWithRolesDTO dto = GiraGroupMapper.INSTANCE.toDtoWithRole(modifiedGroup);
			return dto;
		}catch(EntityNotFoundException ex) {
			return null;
		}
	}
	@Override
	public List<GiraGroupWithRolesDTO> findAllGroupWithRole() {
		List<GiraGroup> group = repository.findAll();
		return group.stream().map(t -> GiraGroupMapper.INSTANCE.toDtoWithRole(t))
				.collect(Collectors.toList());
	}
	

}

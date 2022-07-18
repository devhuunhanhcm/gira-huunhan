package springbootapplication.girahuunhan.role.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootapplication.girahuunhan.role.Dto.GiraRoleDTO;
import springbootapplication.girahuunhan.role.mapper.GiraRoleMapper;
import springbootapplication.girahuunhan.role.model.GiraRole;
import springbootapplication.girahuunhan.role.repository.GiraRoleRepository;

@Service
public class GiraRoleServiceImp implements GiraRoleService{
	@Autowired
	private GiraRoleRepository repository;
	
	@Override
	public List<GiraRoleDTO> findAllEntity() {
		List<GiraRole> roles =  repository.findAll();
		
		return roles.stream()
					.map(t -> GiraRoleMapper.INSTANCE.mapToDTO(t))
					.collect(Collectors.toList());
	}

	@Override
	public GiraRole save(GiraRoleDTO dto) {
		GiraRole role = GiraRoleMapper.INSTANCE.mapToEntity(dto);
		return repository.save(role);
	}

}

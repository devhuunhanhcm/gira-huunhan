package springbootapplication.girahuunhan.role.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootapplication.girahuunhan.role.Dto.GiraGroupDTO;
import springbootapplication.girahuunhan.role.mapper.GiraGroupMapper;
import springbootapplication.girahuunhan.role.model.GiraGroup;
import springbootapplication.girahuunhan.role.repository.GiraGroupRepository;

@Service
public class GiraGroupServiceImp implements GiraGroupService {
	@Autowired
	private GiraGroupRepository repository;
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

}

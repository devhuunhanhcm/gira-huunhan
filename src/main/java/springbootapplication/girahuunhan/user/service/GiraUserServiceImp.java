package springbootapplication.girahuunhan.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootapplication.girahuunhan.user.dto.GiraUserDTO;
import springbootapplication.girahuunhan.user.mapper.GiraUserMapper;
import springbootapplication.girahuunhan.user.model.GiraUser;
import springbootapplication.girahuunhan.user.repository.GiraUserRepository;

@Service
public class GiraUserServiceImp implements GiraUserService {
	@Autowired
	private GiraUserRepository repository;
	@Override
	public GiraUserDTO createNewUser(GiraUserDTO dto) {
		GiraUser user = GiraUserMapper.INSTANCE.toModel(dto);
		GiraUser newUser = repository.save(user);
		return GiraUserMapper.INSTANCE.toDTO(newUser);
	}

}

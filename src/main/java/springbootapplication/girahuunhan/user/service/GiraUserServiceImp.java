package springbootapplication.girahuunhan.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import springbootapplication.girahuunhan.user.dto.GiraUserDTO;
import springbootapplication.girahuunhan.user.mapper.GiraUserMapper;
import springbootapplication.girahuunhan.user.model.GiraUser;
import springbootapplication.girahuunhan.user.repository.GiraUserRepository;

@Service
public class GiraUserServiceImp implements GiraUserService {
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private GiraUserRepository repository;
	@Override
	public GiraUserDTO createNewUser(GiraUserDTO dto) {
		GiraUser user = GiraUserMapper.INSTANCE.toModel(dto);
		
		//encode password before save
		user.setPassword(encoder.encode(dto.getPassword()));
		GiraUser newUser = repository.save(user);
		newUser.setPassword("");
		return GiraUserMapper.INSTANCE.toDTO(newUser);
	}

}

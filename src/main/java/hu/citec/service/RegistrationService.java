package hu.citec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.citec.entity.User;
import hu.citec.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repo;
	
	public void registration(User user) {
		repo.registration(user);
	}
	
	public boolean findUser(String username, String password) {
		return repo.findUser(username, password);
	}

}

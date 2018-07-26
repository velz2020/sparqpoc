package org.sparqpoc.appservice;

import org.sparqpoc.model.security.User;
import org.sparqpoc.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {
	
	@Autowired
	UserRepository userRepository;

	public User registerNewUser(User user) {
		return userRepository.save(user);
	}	
	
}

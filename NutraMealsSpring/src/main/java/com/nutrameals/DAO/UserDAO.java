package com.nutrameals.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutrameals.DTO.LoginDTO;
import com.nutrameals.model.User;
import com.nutrameals.repository.UserRepository;

@Service
public class UserDAO {

	@Autowired
	UserRepository userRepository;
	
	public String login(LoginDTO loginDTO) {
		User user = userRepository.findByUserName(loginDTO.getUserName());
		
		if(user == null) {
            throw new RuntimeException("User does not exist.");
        }
        if(!user.getPassword().equals(loginDTO.getPassword())){
            throw new RuntimeException("Password mismatch.");
        }
        return "Login Successful";
	}

	public String signUp(User user) {
		if(user.getUserName() != null) {
			userRepository.save(user);
			return "User inserted successfully";
		}
		return null;
	}
}

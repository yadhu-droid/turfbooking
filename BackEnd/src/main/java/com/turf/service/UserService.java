package com.turf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.mindrot.jbcrypt.BCrypt;

import com.turf.dao.UserDao;
import com.turf.dto.LoginDTO;
import com.turf.dto.UserDTO;
import com.turf.entity.User;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public int addUser(UserDTO userDto) {
				User user = new User();
				user.setUserFirstName(userDto.getFname());
				user.setUserLastName(userDto.getLname());
				user.setUserEmail(userDto.getEmail());
				user.setUserPhone(userDto.getPhone());
				String hashedPassword = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
				user.setUserPassword(hashedPassword);		
				userDao.save(user);
				return 1;
		}

	public User validateUser(LoginDTO loginDto) {
		User user = userDao.findByUserEmail(loginDto.getEmail());
		String dtoPassword = loginDto.getPassword(); 
		String hashedRealPassword = user.getUserPassword();
		boolean passwordSame = BCrypt.checkpw(dtoPassword, hashedRealPassword);
		
        if (user != null && passwordSame) {
            return user;
        } else {
            return null;
        }
	}
}

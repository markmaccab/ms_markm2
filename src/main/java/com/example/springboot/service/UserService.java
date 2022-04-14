package com.example.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.entity.Userpre;
import com.example.springboot.model.User;
import com.example.springboot.repository.UserPreRepository;


@Service
public class UserService {

	static List<User> users;

		static	{
			
			users = new ArrayList<User>();
			users.add(new User(1, "kara","kara@supergirl.com"));
			users.add(new User(2, "Alex","Alex@supergirl.com"));
			users.add(new User(3, "nia","nia@supergirl.com"));
			users.add(new User(4, "John","John@supergirl.com"));
			users.add(new User(5, "Mark","Mark@supergirl.com"));
		}

//MySQL DB		
		
		@Autowired
		private UserPreRepository repositoryPre;
    public List<Userpre> fetchUserList() 
    {    		    	
        return (List<Userpre>)
            repositoryPre.findAll();
    }

	public Userpre getUserpreById(Integer id) {
		Optional<Userpre> userpre = repositoryPre.findById(id);
		if(userpre.isPresent()) {
			return userpre.get();
		}
		return null;
	}

	public Integer saveUser(Userpre userpre) {
		Userpre savedUser = repositoryPre.save(userpre);
		return savedUser.getStuNo();
	}

//static table 	
    
		public List<User> getAllUsers() {
			return users;
		}

		public User getUserById(int id) {
			User user=null;
			for (User u : users)
				if (u.getId()==id)  {
					user=u;
					break;
				}
			
		return user;	
			
		}

		
}

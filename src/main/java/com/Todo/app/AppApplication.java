package com.Todo.app;

import com.Todo.app.model.Role;
import com.Todo.app.model.RoleName;
import com.Todo.app.model.User;
import com.Todo.app.repository.RoleRepository;
import com.Todo.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		if (roleRepository.findAll().isEmpty()) {
			roleRepository.saveAndFlush(new Role(RoleName.ROLE_USER));
			roleRepository.saveAndFlush(new Role(RoleName.ROLE_ADMIN));
			roleRepository.saveAndFlush(new Role(RoleName.ROLE_MODERATOR));
		}

		if (userRepository.findAll().isEmpty()) {
			User user1 = new User();
			user1.setUsername("kemal12");
			user1.setEmail("test@user.com");
			user1.setPassword(new BCryptPasswordEncoder().encode("testuser"));
			userRepository.saveAndFlush(user1);

			User user2 = new User();
			user2.setUsername("cemal");
			user2.setEmail("test@asd.com");
			user2.setPassword(new BCryptPasswordEncoder().encode("testuser"));
			userRepository.saveAndFlush(user2);
		}
//
//		if (toDoService.findAll().isEmpty()) {
//			ToDo toDo=new ToDo();
//			toDo.setTitle("First Task 'Do It'");
//			toDo.setCompleted(false);
//			toDoService.saveOrUpdate(toDo);
//			System.out.println("ADDED");
//		}
	}
}

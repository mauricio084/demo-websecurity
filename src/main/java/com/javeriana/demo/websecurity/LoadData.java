package com.javeriana.demo.websecurity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.javeriana.demo.websecurity.entities.Role;
import com.javeriana.demo.websecurity.entities.Usuario;
import com.javeriana.demo.websecurity.repositories.RoleRepository;
import com.javeriana.demo.websecurity.repositories.UsuarioRepository;

@Configuration
class LoadDataBase {

	@Bean
	CommandLineRunner initDatabase(UsuarioRepository userRepository, RoleRepository roleRepository,
	    BCryptPasswordEncoder bCryptPasswordEncoder) {
		return args -> {
			
			Role adminRole = new Role();
			adminRole.setName("Admin");
			roleRepository.save(adminRole);
			
			Role viewerRole = new Role();
			viewerRole.setName("Viewer");
			roleRepository.save(viewerRole);
			
			Role customerRole = new Role();
			customerRole.setName("customer");
			roleRepository.save(customerRole);

			Usuario admin = new Usuario();
			admin.setUsername("admin");
			admin.setPassword(bCryptPasswordEncoder.encode("12345"));
			admin.setRole(adminRole);
			userRepository.save(admin);
			
			Usuario visitor = new Usuario();
			visitor.setUsername("visitor");
			visitor.setPassword(bCryptPasswordEncoder.encode("12345"));
			visitor.setRole(viewerRole);
			userRepository.save(visitor);
			
			Usuario customer = new Usuario();
			customer.setUsername("customer");
			customer.setPassword(bCryptPasswordEncoder.encode("12345"));
			customer.setRole(customerRole);
			userRepository.save(customer);
		};
	}
}

package com.example.demo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.dto.AuthorDto;
import com.example.demo.repositories.PostRepository;
import com.example.demo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {

			SimpleDateFormat sdft = new SimpleDateFormat("dd/MM/yyyy");
			sdft.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		
		
		 
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		User matheus = new User(null, "Matheus","matheusgoldship@gmail.com" );
		
		
		Post post1 = new Post(null, sdft.parse("21/03/2018"), "Partiu viajem", "vou para SP", new AuthorDto (maria));
		Post post2 = new Post(null, sdft.parse("23/03/2018"), "Bom dia","Acordei feliz hoje",  new AuthorDto(maria));
		Post post3 = new Post(null, sdft.parse("13/10/2023"), "Cheguei na area", "O pai viana ta na area e ataca novamente!", new AuthorDto());
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob, matheus));
		 
		postRepository.saveAll(Arrays.asList(post1, post2, post3));
	}

		 
	
	
}

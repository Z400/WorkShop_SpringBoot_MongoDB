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
import com.example.demo.dto.CommentsDto;
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
		
	
		
		Post post1 = new Post(null, sdft.parse("21/03/2018"), "Partiu viajem", "vou para SP", new AuthorDto (maria));
		Post post2 = new Post(null, sdft.parse("23/03/2018"), "Bom dia","Acordei feliz hoje",  new AuthorDto(maria));
		Post post3 = new Post(null, sdft.parse("13/10/2023"), "Cheguei na area", "O pai viana ta na area e ataca novamente!", new AuthorDto());
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		 
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		 maria.getPosts().addAll(Arrays.asList(post1, post2));
		 userRepository.save(maria);
		 
		 //Comentarios
		 
		 CommentsDto comments1 = new CommentsDto("Boa viajem mano!", sdft.parse("21/03/2018"), new AuthorDto(alex));
		 CommentsDto comments2 = new CommentsDto("Aproveite!", sdft.parse("22/03/2018"), new AuthorDto(bob));
		 CommentsDto comments3 = new CommentsDto("Tenha um ótimo dia!", sdft.parse("23/03/2018"), new AuthorDto(alex));
		     
		 post1.getComments().addAll(Arrays.asList(comments1, comments2));
		 post2.getComments().addAll(Arrays.asList(comments3));
		 postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

		 
	
	
}

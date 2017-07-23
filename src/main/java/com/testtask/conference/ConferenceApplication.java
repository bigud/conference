package com.testtask.conference;

import com.testtask.conference.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import  com.testtask.conference.dao.ConfRepository;
@SpringBootApplication
public class ConferenceApplication extends SpringBootServletInitializer {
    private static final Logger log = LoggerFactory.getLogger(ConferenceApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ConferenceApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(ConferenceApplication.class, args);
    }

		@Bean
		public CommandLineRunner demo(ConfRepository repository) {
			return (args) -> {
				// save for example 0
				User user = new User();
				user.setLogin("admin");
				user.setName("admin");
				user.setPassword(new BCryptPasswordEncoder().encode("admin"));
				user.setRole("ROLE_ADMIN");
				user.setEmail("admin@admin.ru");
				repository.save(user);
				//1
                User user1 = new User();
                user1.setLogin("presenter1");
                user1.setName("presenter1");
                user1.setPassword(new BCryptPasswordEncoder().encode("presenter1"));
                user.setEmail("admin@admin.ru");
                user1.setRole("ROLE_PRESENTER");
                repository.save(user1);
                //2
                User user2 = new User();
                user2.setLogin("listener1");
                user2.setName("listener1");
                user2.setPassword(new BCryptPasswordEncoder().encode("listener1"));
                user.setEmail("admin@admin.ru");
                user2.setRole("ROLE_LISTENER");
                repository.save(user2);
				// fetch all customers
				log.info("user found with findAll():");
				log.info("-------------------------------");
				for (User curUser : repository.findAll()) {
					log.info(curUser.toString());
				}
				log.info("");

				// fetch an individual customer by ID
				User checkUser = repository.findOne(2);
				log.info("checkUser found with findOne(2):");
				log.info("--------------------------------");
				log.info(checkUser.toString());
				log.info("");
			};
    }
}

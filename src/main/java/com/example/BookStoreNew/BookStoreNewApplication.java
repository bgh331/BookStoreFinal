package com.example.BookStoreNew;

import org.slf4j.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.BookStoreNew.domain.Book;
import com.example.BookStoreNew.domain.BookRepository;
import com.example.BookStoreNew.domain.Category;
import com.example.BookStoreNew.domain.CategoryRepository;
import com.example.BookStoreNew.domain.User;
import com.example.BookStoreNew.domain.UserRepository;


@SpringBootApplication
public class BookStoreNewApplication {
	private static final Logger log = LoggerFactory.getLogger(BookStoreNewApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookStoreNewApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookstoreDemo(BookRepository brepository, CategoryRepository crepository,UserRepository urepository) {
		return (args) -> {

			crepository.save(new Category("Gibli"));
			crepository.save(new Category("Fantasia"));
			crepository.save(new Category("Kauhu"));

			log.info("save a couple of books"); // logger tuottaa lokia ohjelman toiminnasta
			brepository.save(new Book("Maamerentarinat", "Hayao", "978-951-1-34784-2", 2000,
					crepository.findByName("Gibli").get(0)));
			brepository.save(new Book("Liisa Ihmemaassa", "Fantasia", "978-951-1-34784-2", 1980,
					crepository.findByName("Gibli").get(0)));
			brepository
					.save(new Book("It", "Kauhu", "978-951-1-34784-2", 2001, crepository.findByName("Gibli").get(0)));
			brepository.save(new Book("Liikkuva Linna", "Hayao", "978-951-1-34784-2", 2003,
					crepository.findByName("Gibli").get(0)));
			brepository.save(new Book("Laputa Linna Taivaalla", "Hayao", "978-951-1-34784-2", 2006,
					crepository.findByName("Gibli").get(0)));
			// repository.deleteAll(); //Poistaa kaikki kirjat mikäli niin halutaan
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			User user3 = new User("Kiia", "$2a$04$9gKGDOVL/JR7dB3FnoRir..fPCreozI7YmNnR.PwBJIfJcl8NP3.e", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}

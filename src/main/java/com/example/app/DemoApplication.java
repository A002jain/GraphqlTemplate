package com.example.app;

import com.example.app.fetcher.BookFetcher;
import com.example.app.repository.BookRepository;
import com.example.app.repository.BookRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean
//	public BookRepository getBookRepository(){
//		return new BookRepositoryImpl();
//	}
//
//	@Bean
//	public BookFetcher getBookFetcher(){
//		return new BookFetcher();
//	}


}

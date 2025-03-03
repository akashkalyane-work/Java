package com.example.userApi;

import com.example.userApi.entity.User;
import com.example.userApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApiApplication {





	public static void main(String[] args) {

		SpringApplication.run(UserApiApplication.class, args);

	}

}

package com.mongodbapp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserDatabaseApplication implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(UserDatabaseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        repository.save(new User("Mai", "Sharona"));
        repository.save(new User("Nick", "Foles"));
        repository.save(new User("Pac", "Mann"));

        System.out.println("\nList of All Users:");
        System.out.println("------------------\n");
        for (User user : repository.findAll()) {
            System.out.println(user);
        }
        System.out.println();

        System.out.println("Users with First Name of 'Nick':");
        System.out.println("--------------------------------\n");
        System.out.println(repository.findByFirstName("Nick") + "\n");

        System.out.println("Users with Last Name of 'Mann':");
        System.out.println("-------------------------------\n");
        for (User user : repository.findByLastName("Mann")) {
            System.out.println(user);
        }
    }
}
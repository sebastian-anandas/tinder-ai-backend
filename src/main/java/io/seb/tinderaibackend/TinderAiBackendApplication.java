package io.seb.tinderaibackend;

import io.seb.tinderaibackend.profiles.Gender;
import io.seb.tinderaibackend.profiles.Profile;
import io.seb.tinderaibackend.profiles.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TinderAiBackendApplication implements CommandLineRunner {

    @Autowired
    private ProfileRepository profileRepository;

    public static void main(String[] args) {
        SpringApplication.run(TinderAiBackendApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Profile profile = new Profile(
                "1",
                "Sebastian",
                "Anandas",
                27,
                "Indian",
                Gender.MALE,
                "Software Engineer",
                "foo.jpg",
                "INTP"

        );

        profileRepository.save(profile);
        profileRepository.findAll().forEach(System.out::println);

    }
}

package io.seb.tinderaibackend;

import io.seb.tinderaibackend.conversations.ChatMessage;
import io.seb.tinderaibackend.conversations.Conversation;
import io.seb.tinderaibackend.conversations.ConversationRepository;
import io.seb.tinderaibackend.profiles.Gender;
import io.seb.tinderaibackend.profiles.Profile;
import io.seb.tinderaibackend.profiles.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class TinderAiBackendApplication implements CommandLineRunner {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ConversationRepository conversationRepository;

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

        Conversation conversation = new Conversation(
                "1",
                profile.id(),
                List.of(
                        new ChatMessage("Hello", profile.id(), LocalDateTime.now())
                )
        );

        conversationRepository.save(conversation);
        conversationRepository.findAll().forEach(System.out::println);

    }
}

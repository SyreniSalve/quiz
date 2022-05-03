package lt.sdacademy.projektplus.quiz;

import lombok.extern.java.Log;
import lt.sdacademy.projektplus.quiz.entity.PlayerEntity;
import lt.sdacademy.projektplus.quiz.frontend.GameOptions;
import lt.sdacademy.projektplus.quiz.repository.PlayerRepository;
import lt.sdacademy.projektplus.quiz.service.QuizDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Log
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private QuizDataService quizDataService;

    private GameOptions gameOptions;


    @Override
    public void run(String... args) throws Exception {
        log.info("Executing startup actions...");
        playerRepository.save(new PlayerEntity("John"));
        playerRepository.save(new PlayerEntity("Harry"));
        playerRepository.save(new PlayerEntity("George"));

        log.info("List of players from database:");
        List<PlayerEntity> playersFromDb = playerRepository.findAll();
        for (PlayerEntity playerFromDb : playersFromDb) {
            log.info("Player from DB: " + playerFromDb);
        }

        quizDataService.getQuizCategories();
//        quizDataService.getQuizQuestions(gameOptions);
    }
}


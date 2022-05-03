package lt.sdacademy.projektplus.quiz.repository;

import lt.sdacademy.projektplus.quiz.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository  extends JpaRepository<PlayerEntity, Long> {
}

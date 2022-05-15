package com.example.conf_web_service.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.conf_web_service.models.conf.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long>{

    List<Tutorial> findByPublished(boolean published);
    List<Tutorial> findByTitleContaining(String title);

}

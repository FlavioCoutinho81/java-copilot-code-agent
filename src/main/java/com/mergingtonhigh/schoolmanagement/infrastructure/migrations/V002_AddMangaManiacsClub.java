package com.mergingtonhigh.schoolmanagement.infrastructure.migrations;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mergingtonhigh.schoolmanagement.domain.entities.Activity;
import com.mergingtonhigh.schoolmanagement.domain.valueobjects.ActivityType;
import com.mergingtonhigh.schoolmanagement.domain.valueobjects.ScheduleDetails;

import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;

/**
 * Migration to add the Manga Maniacs club to the school's extracurricular activities.
 * This new club focuses on exploring Japanese manga culture and storytelling.
 */
@ChangeUnit(id = "add-manga-maniacs-club", order = "002", author = "copilot")
public class V002_AddMangaManiacsClub {

        private final MongoTemplate mongoTemplate;

        public V002_AddMangaManiacsClub(MongoTemplate mongoTemplate) {
                this.mongoTemplate = mongoTemplate;
        }

        @Execution
        public void execute() {
                // Add Manga Maniacs club with an inspiring and engaging description
                Activity mangaManiacs = new Activity(
                                "Manga Maniacs",
                                "Mergulhe no incrível universo dos mangás japoneses! Descubra mundos épicos, heróis corajosos, vilões fascinantes e histórias que vão desde aventuras sobrenaturais até romances emocionantes. Aqui você vai debater suas séries favoritas, conhecer novos títulos e até criar seus próprios personagens. Venha fazer parte desta jornada otaku!",
                                "Terças-feiras, 19:00 - 20:00",
                                new ScheduleDetails(List.of("Tuesday"), LocalTime.of(19, 0), LocalTime.of(20, 0)),
                                15,
                                ActivityType.ARTS);
                mongoTemplate.save(mangaManiacs);
        }

        @RollbackExecution
        public void rollback() {
                // Remove the Manga Maniacs activity
                mongoTemplate.remove(new Query(Criteria.where("name").is("Manga Maniacs")), Activity.class);
        }
}
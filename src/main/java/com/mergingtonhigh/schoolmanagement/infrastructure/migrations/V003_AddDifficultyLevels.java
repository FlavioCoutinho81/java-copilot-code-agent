package com.mergingtonhigh.schoolmanagement.infrastructure.migrations;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mergingtonhigh.schoolmanagement.domain.entities.Activity;
import com.mergingtonhigh.schoolmanagement.domain.valueobjects.DifficultyLevel;

import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;

/**
 * Migration to add difficulty levels to selected activities.
 * This demonstrates the new difficulty feature with different levels.
 */
@ChangeUnit(id = "add-difficulty-levels", order = "003", author = "Copilot")
public class V003_AddDifficultyLevels {

    private final MongoTemplate mongoTemplate;

    public V003_AddDifficultyLevels(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Execution
    public void migrate() {
        addDifficultyLevelsToActivities();
    }

    private void addDifficultyLevelsToActivities() {
        // Add INICIANTE difficulty to beginner-friendly activities
        updateActivityDifficulty("Clube de Arte", DifficultyLevel.INICIANTE);
        updateActivityDifficulty("Clube de Teatro", DifficultyLevel.INICIANTE);
        updateActivityDifficulty("Fitness Matinal", DifficultyLevel.INICIANTE);

        // Add INTERMEDIARIO difficulty to intermediate activities
        updateActivityDifficulty("Aula de Programação", DifficultyLevel.INTERMEDIARIO);
        updateActivityDifficulty("Clube de Matemática", DifficultyLevel.INTERMEDIARIO);
        updateActivityDifficulty("Time de Futebol", DifficultyLevel.INTERMEDIARIO);
        updateActivityDifficulty("Time de Basquete", DifficultyLevel.INTERMEDIARIO);

        // Add AVANCADO difficulty to advanced activities
        updateActivityDifficulty("Clube de Xadrez", DifficultyLevel.AVANCADO);
        updateActivityDifficulty("Equipe de Debates", DifficultyLevel.AVANCADO);
        updateActivityDifficulty("Oficina de Robótica", DifficultyLevel.AVANCADO);
        updateActivityDifficulty("Olimpíada de Ciências", DifficultyLevel.AVANCADO);

        // Leave some activities without difficulty level (for "Todos" filter testing)
        // These include: Manga Maniacs Club and other activities
    }

    private void updateActivityDifficulty(String activityName, DifficultyLevel difficultyLevel) {
        Query query = new Query(Criteria.where("name").is(activityName));
        Update update = new Update().set("difficultyLevel", difficultyLevel);
        mongoTemplate.updateFirst(query, update, Activity.class);
    }

    @RollbackExecution
    public void rollback() {
        // Remove difficulty level from all activities
        Query query = new Query();
        Update update = new Update().unset("difficultyLevel");
        mongoTemplate.updateMulti(query, update, Activity.class);
    }
}
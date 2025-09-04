package com.mergingtonhigh.schoolmanagement.domain.valueobjects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for DifficultyLevel enum.
 */
class DifficultyLevelTest {

    @Test
    void shouldReturnCorrectLabels() {
        assertEquals("Iniciante", DifficultyLevel.INICIANTE.getLabel());
        assertEquals("Intermediário", DifficultyLevel.INTERMEDIARIO.getLabel());
        assertEquals("Avançado", DifficultyLevel.AVANCADO.getLabel());
    }

    @Test
    void shouldParseLabelsCorrectly() {
        assertEquals(DifficultyLevel.INICIANTE, DifficultyLevel.fromLabel("Iniciante"));
        assertEquals(DifficultyLevel.INTERMEDIARIO, DifficultyLevel.fromLabel("Intermediário"));
        assertEquals(DifficultyLevel.AVANCADO, DifficultyLevel.fromLabel("Avançado"));
    }

    @Test
    void shouldParseLabelsIgnoringCase() {
        assertEquals(DifficultyLevel.INICIANTE, DifficultyLevel.fromLabel("iniciante"));
        assertEquals(DifficultyLevel.INTERMEDIARIO, DifficultyLevel.fromLabel("INTERMEDIÁRIO"));
        assertEquals(DifficultyLevel.AVANCADO, DifficultyLevel.fromLabel("avançado"));
    }

    @Test
    void shouldParseEnglishVariations() {
        assertEquals(DifficultyLevel.INICIANTE, DifficultyLevel.fromLabel("beginner"));
        assertEquals(DifficultyLevel.INTERMEDIARIO, DifficultyLevel.fromLabel("intermediate"));
        assertEquals(DifficultyLevel.AVANCADO, DifficultyLevel.fromLabel("advanced"));
    }

    @Test
    void shouldParseVariationsWithoutAccents() {
        assertEquals(DifficultyLevel.INTERMEDIARIO, DifficultyLevel.fromLabel("intermediario"));
        assertEquals(DifficultyLevel.AVANCADO, DifficultyLevel.fromLabel("avancado"));
    }

    @Test
    void shouldReturnNullForInvalidLabel() {
        assertNull(DifficultyLevel.fromLabel("invalid"));
        assertNull(DifficultyLevel.fromLabel(""));
        assertNull(DifficultyLevel.fromLabel(null));
    }
}
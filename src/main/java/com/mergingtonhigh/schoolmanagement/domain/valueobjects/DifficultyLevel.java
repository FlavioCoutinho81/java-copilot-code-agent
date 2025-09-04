package com.mergingtonhigh.schoolmanagement.domain.valueobjects;

/**
 * Enum representing the difficulty levels for activities.
 * Each level has a label for display purposes.
 */
public enum DifficultyLevel {
    INICIANTE("Iniciante"),
    INTERMEDIARIO("Intermediário"),
    AVANCADO("Avançado");

    private final String label;

    DifficultyLevel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    /**
     * Returns the DifficultyLevel for a given label, ignoring case and accents.
     * Used for parsing user input or external data.
     */
    public static DifficultyLevel fromLabel(String label) {
        if (label == null) {
            return null;
        }
        String normalizedLabel = label.trim().toLowerCase();
        
        for (DifficultyLevel level : values()) {
            if (level.getLabel().toLowerCase().equals(normalizedLabel)) {
                return level;
            }
        }
        
        // Handle common variations
        switch (normalizedLabel) {
            case "beginner":
            case "iniciante":
                return INICIANTE;
            case "intermediate":
            case "intermediario":
            case "intermediário":
                return INTERMEDIARIO;
            case "advanced":
            case "avancado":
            case "avançado":
                return AVANCADO;
            default:
                return null;
        }
    }
}
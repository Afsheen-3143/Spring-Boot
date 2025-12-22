package LearningSystem.LS.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import LearningSystem.LS.exception.InvalidEnumValueException;

public enum CourseNames {

    JAVA_CORE,
    JAVA_OOP,
    JAVA_COLLECTIONS,
    JAVA_SPRING_FRAMEWORK,

    PYTHON_BASICS,
    PYTHON_OOP,
    PYTHON_DATA_ANALYSIS,

    SQL_DATABASES,
    NOSQL_DATABASES,
    DATABASE_DESIGN,

    INTRODUCTION_TO_AI,
    AI_KNOWLEDGE_REPRESENTATION,
    AI_SEARCH_TECHNIQUES,
    INTELLIGENT_AGENT_DESIGN,

    DATA_SCIENCE_FOUNDATIONS,
    STATISTICS_FOR_DATA_SCIENCE,
    DATA_VISUALIZATION,
    MACHINE_LEARNING_FOUNDATIONS;

	// Accept any case from JSON input
    
	 @JsonCreator
	    public static CourseNames fromJson(String value) {
	        try {
	            return CourseNames.valueOf(
	                value.trim().toUpperCase().replace(" ", "_")
	            );
	        } catch (IllegalArgumentException ex) {
	            throw new InvalidEnumValueException("Invalid course: " + value);
	        }
	    }
}


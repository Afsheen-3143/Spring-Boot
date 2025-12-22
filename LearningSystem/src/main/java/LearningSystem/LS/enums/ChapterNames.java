package LearningSystem.LS.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import LearningSystem.LS.exception.InvalidEnumValueException;

public enum ChapterNames {

	  JAVA_INTRO,
	    JAVA_DATATYPES,
	    JAVA_CONTROL_FLOW,

	    OOP_BASICS,
	    INHERITANCE_CONCEPTS,
	    POLYMORPHISM_CONCEPTS,
	    ABSTRACTION_INTERFACES,

	    COLLECTION_FRAMEWORK_INTRO,
	    LIST_IMPLEMENTATIONS,
	    SET_IMPLEMENTATIONS,
	    MAP_IMPLEMENTATIONS,

	    SPRING_CORE_INTRO,
	    SPRING_DEPENDENCY_INJECTION,
	    SPRING_MVC_BASICS,
	    SPRING_DATA_JPA,

	    PYTHON_INTRO,
	    PYTHON_VARIABLES,
	    PYTHON_CONTROL_FLOW,
	    PYTHON_FUNCTIONS,

	    ML_INTRO,
	    SUPERVISED_LEARNING;
    
    @JsonCreator
    public static ChapterNames fromJson(String value) {
        try {
            return ChapterNames.valueOf(
                value.trim().toUpperCase().replace(" ", "_")
            );
        } catch (IllegalArgumentException ex) {
            throw new InvalidEnumValueException("Invalid ChapterNames: " + value);
        }
    }
}
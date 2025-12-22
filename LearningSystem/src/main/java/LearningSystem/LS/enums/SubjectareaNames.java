package LearningSystem.LS.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import LearningSystem.LS.exception.InvalidEnumValueException;

public enum SubjectareaNames {
	 JAVA,
	    PYTHON,
	    DATABASE,
	    ARTIFICIAL_INTELLIGENCE,
	    DATA_SCIENCE;
	    
	    @JsonCreator
	    public static SubjectareaNames fromJson(String value) {
	        try {
	            return SubjectareaNames.valueOf(
	                value.trim().toUpperCase().replace(" ", "_")
	            );
	        } catch (IllegalArgumentException ex) {
	            throw new InvalidEnumValueException("Invalid SubjectArea: " + value);
	        }
	    }

}

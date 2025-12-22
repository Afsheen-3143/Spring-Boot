package LearningSystem.LS.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import LearningSystem.LS.exception.InvalidEnumValueException;

public enum TopicNames {

	HISTORY_OF_JAVA,
    JVM_ARCHITECTURE,
    PRIMITIVE_TYPES,
    TYPE_CASTING,
    LOOPS,
    CONDITIONALS,
    METHOD_DEFINITION,
    METHOD_OVERLOADING,
    CLASSES_AND_OBJECTS,
    CONSTRUCTORS,
    ACCESS_MODIFIERS,
    SINGLE_INHERITANCE,
    MULTILEVEL_INHERITANCE,
    HIERARCHICAL_INHERITANCE,
    METHOD_OVERRIDING,
    ABSTRACT_CLASSES,
    INTERFACES,
    COLLECTIONS_OVERVIEW,
    ITERABLE_INTERFACE,
    COMPARATOR_COMPARABLE,
    HASHSET_USAGE,
    TREESET_USAGE,
    HASHMAP_USAGE,
    SPRING_ARCHITECTURE,
    CONSTRUCTOR_INJECTION,
    SETTER_INJECTION,
    AUTOWIRING,
    CONTROLLERS,
    REQUEST_MAPPING,
    ENTITY_MAPPING,
    JPQL_QUERIES,

    PYTHON_HISTORY,
    PYTHON_FEATURES,
    DATATYPES_IN_PYTHON,
    LOOPS_IN_PYTHON,
    PATTERN_GENERATION,
    LAMBDA_FUNCTIONS,
    ARRAYS_INTRO,
    MATRIX_OPERATIONS,
    DATAFRAME_CREATION,
    MERGING_AND_JOINING,
    SQL_DATATYPES,
    SQL_OPERATORS,
    AI_APPLICATIONS,
    AI_CHALLENGES,
    ML_PIPELINE,
    ML_ALGORITHMS_OVERVIEW,
    CLASSIFICATION_ALGORITHMS,
    MODEL_TUNING,
    METRICS_ACCURACY,
    CONFUSION_MATRIX_ANALYSIS;

    @JsonCreator
    public static TopicNames fromJson(String value) {
        try {
            return TopicNames.valueOf(
                value.trim()
                     .toUpperCase()
                     .replace(" ", "_")
            );
        } catch (IllegalArgumentException ex) {
            throw new InvalidEnumValueException("Invalid TopicNames: " + value);
        }
    }
}

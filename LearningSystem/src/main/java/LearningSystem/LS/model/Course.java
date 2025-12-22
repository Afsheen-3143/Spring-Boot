package LearningSystem.LS.model;

import LearningSystem.LS.enums.CourseNames;
import jakarta.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private CourseNames courseName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "subject_id", nullable = false)
    private SubjectArea subjectArea;
//    A no-arg constructor allows object creation without parameters and is mandatory for framework-based object creation.
    public Course() {
    }

    public Course(CourseNames courseName) {
        this.courseName = courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public CourseNames getCourseName() {
        return courseName;
    }

    public void setCourseName(CourseNames courseName) {
        this.courseName = courseName;
    }

    public SubjectArea getSubjectArea() {
        return subjectArea;
    }

    public void setSubjectArea(SubjectArea subjectArea) {
        this.subjectArea = subjectArea;
    }
}

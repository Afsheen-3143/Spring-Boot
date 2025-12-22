package LearningSystem.LS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import LearningSystem.LS.exception.DuplicateValueException;
import LearningSystem.LS.exception.InvalidEnumValueException;
import LearningSystem.LS.exception.ResourceNotFoundException;
import LearningSystem.LS.model.Course;
import LearningSystem.LS.model.SubjectArea;
import LearningSystem.LS.repository.CourseRepo;
import LearningSystem.LS.repository.SubjectareaRepo;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private SubjectareaRepo subjectRepo;

    // ADD COURSE
    public Course addcourse(int subjectId, Course course) {

        // Validate subject
        SubjectArea subject = subjectRepo.findById(subjectId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "SubjectArea not found with id " + subjectId
                        ));

        course.setSubjectArea(subject);

        try {
            return courseRepo.save(course);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateValueException(
                    "Course with name " + course.getCourseName() + " already exists"
            );
        }
    }

    // UPDATE COURSE
    public Course updatecourse(int courseId, Course course) {

        Course existing = courseRepo.findById(courseId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Course not found with id " + courseId
                        ));

        existing.setCourseName(course.getCourseName());
        return courseRepo.save(existing);
    }

    public List<Course> getAllcourses() {
        return courseRepo.findAll();
    }

    public Course getCoursesById(int courseId) {
        return courseRepo.findById(courseId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Course not found with id " + courseId
                        ));
    }

    public void deletecourse(int courseId) {
        courseRepo.deleteById(courseId);
    }

    public void deleteAllCourses() {
        courseRepo.deleteAll();
    }
}

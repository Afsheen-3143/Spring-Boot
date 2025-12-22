package LearningSystem.LS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import LearningSystem.LS.exception.DuplicateValueException;
import LearningSystem.LS.exception.ResourceNotFoundException;
import LearningSystem.LS.model.Chapter;
import LearningSystem.LS.model.Course;
import LearningSystem.LS.repository.ChapterRepo;
import LearningSystem.LS.repository.CourseRepo;

@Service
public class ChapterService {

    @Autowired
    private ChapterRepo chapterRepo;

    @Autowired
    private CourseRepo courseRepo;

    // ADD CHAPTER
    public Chapter addChapter(int courseId, Chapter chapter) {

        Course course = courseRepo.findById(courseId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Course not found with id " + courseId
                        ));

        chapter.setCourse(course);

        try {
            return chapterRepo.save(chapter);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateValueException(
                    "Chapter with name " + chapter.getChapterName() + " already exists"
            );
        }
    }

    // UPDATE CHAPTER
    public Chapter updateChapter(int chapterId, Chapter chapter) {

        Chapter existing = chapterRepo.findById(chapterId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Chapter not found with id " + chapterId
                        ));

        existing.setChapterName(chapter.getChapterName());
        return chapterRepo.save(existing);
    }

    public List<Chapter> getAllChapters() {
        return chapterRepo.findAll();
    }

    public Chapter getChapterById(int chapterId) {
        return chapterRepo.findById(chapterId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Chapter not found with id " + chapterId
                        ));
    }

    public void deleteChapter(int chapterId) {
        chapterRepo.deleteById(chapterId);
    }

    public void deleteAllChapters() {
        chapterRepo.deleteAll();
    }
}

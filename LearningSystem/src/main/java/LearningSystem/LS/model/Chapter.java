package LearningSystem.LS.model;

import LearningSystem.LS.enums.ChapterNames;
import jakarta.persistence.*;

@Entity
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chapterId;

    @Enumerated(EnumType.STRING)
    @Column(name = "chapter_name", nullable = false)
    private ChapterNames chapterName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public Chapter() {
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public ChapterNames getChapterName() {
        return chapterName;
    }

    public void setChapterName(ChapterNames chapterName) {
        this.chapterName = chapterName;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}

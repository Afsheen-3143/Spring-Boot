package LearningSystem.LS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import LearningSystem.LS.model.Chapter;
import LearningSystem.LS.service.ChapterService;

@RestController
@RequestMapping("/chapter")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    // ADD CHAPTER
    @PostMapping("/add/{courseId}")
    public Chapter addChapter(
            @PathVariable int courseId,
            @RequestBody Chapter chapter) {

        return chapterService.addChapter(courseId, chapter);
    }

    // UPDATE
    @PutMapping("/update/{chapterId}")
    public Chapter updateChapter(
            @PathVariable int chapterId,
            @RequestBody Chapter chapter) {

        return chapterService.updateChapter(chapterId, chapter);
    }

    // GET ALL
    @GetMapping("/getAll")
    public List<Chapter> getAllChapters() {
        return chapterService.getAllChapters();
    }

    // GET BY ID
    @GetMapping("/getbyId/{chapterId}")
    public Chapter getChapterById(@PathVariable int chapterId) {
        return chapterService.getChapterById(chapterId);
    }

    // DELETE BY ID
    @DeleteMapping("/delete/{chapterId}")
    public void deleteChapter(@PathVariable int chapterId) {
        chapterService.deleteChapter(chapterId);
    }

    // DELETE ALL
    @DeleteMapping("/deleteAll")
    public void deleteAllChapters() {
        chapterService.deleteAllChapters();
    }
}

package LearningSystem.LS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import LearningSystem.LS.model.Topic;
import LearningSystem.LS.service.TopicService;

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    // ADD TOPIC
    @PostMapping("/add/{chapterId}")
    public Topic addTopic(
            @PathVariable int chapterId,
            @RequestBody Topic topic) {

        return topicService.addTopic(chapterId, topic);
    }

    // UPDATE TOPIC
    @PutMapping("/update/{topicId}")
    public Topic updateTopic(
            @PathVariable int topicId,
            @RequestBody Topic topic) {

        return topicService.updateTopic(topicId, topic);
    }

    // GET ALL
    @GetMapping("/getAll")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    // GET BY ID
    @GetMapping("/getbyId/{topicId}")
    public Topic getTopicById(@PathVariable int topicId) {
        return topicService.getTopicById(topicId);
    }

    // DELETE BY ID
    @DeleteMapping("/deletebyId/{topicId}")
    public void deleteTopic(@PathVariable int topicId) {
        topicService.deleteTopic(topicId);
    }

    // DELETE ALL
    @DeleteMapping("/deleteAll")
    public void deleteAllTopics() {
        topicService.deleteAllTopics();
    }
}

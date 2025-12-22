package LearningSystem.LS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import LearningSystem.LS.exception.DuplicateValueException;
import LearningSystem.LS.exception.ResourceNotFoundException;
import LearningSystem.LS.model.Chapter;
import LearningSystem.LS.model.Topic;
import LearningSystem.LS.repository.ChapterRepo;
import LearningSystem.LS.repository.TopicRepo;

@Service
public class TopicService {

    @Autowired
    private TopicRepo topicRepo;

    @Autowired
    private ChapterRepo chapterRepo;

    // ADD TOPIC
    public Topic addTopic(int chapterId, Topic topic) {

        Chapter chapter = chapterRepo.findById(chapterId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Chapter not found with id " + chapterId
                        ));

        topic.setChapter(chapter);

        try {
            return topicRepo.save(topic);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateValueException(
                    "Topic with name " + topic.getTopicName() + " already exists in this chapter"
            );
        }
    }

    // UPDATE TOPIC
    public Topic updateTopic(int topicId, Topic topic) {

        Topic existing = topicRepo.findById(topicId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Topic not found with id " + topicId
                        ));

        existing.setTopicName(topic.getTopicName());
        return topicRepo.save(existing);
    }

    // GET ALL
    public List<Topic> getAllTopics() {
        return topicRepo.findAll();
    }

    // GET BY ID
    public Topic getTopicById(int topicId) {
        return topicRepo.findById(topicId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Topic not found with id " + topicId
                        ));
    }

    // DELETE BY ID
    public void deleteTopic(int topicId) {
        topicRepo.deleteById(topicId);
    }

    // DELETE ALL
    public void deleteAllTopics() {
        topicRepo.deleteAll();
    }
}

package LearningSystem.LS.model;

import LearningSystem.LS.enums.TopicNames;
import jakarta.persistence.*;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int topicId;

    @Enumerated(EnumType.STRING)
    @Column(name = "topic_name", nullable = false)
    private TopicNames topicName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "chapter_id", nullable = false)
    private Chapter chapter;

    public Topic() {}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public TopicNames getTopicName() {
		return topicName;
	}

	public void setTopicName(TopicNames topicName) {
		this.topicName = topicName;
	}

	public Chapter getChapter() {
		return chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

    
}

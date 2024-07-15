package org.ashish.model;
import jakarta.persistence.*;
import org.ashish.model.Answers;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String questionText;

    @OneToOne(mappedBy = "question", cascade = CascadeType.ALL)
    private Answers answer;

    public Question() {
    }

    public Question(String questionText) {
        this.questionText = questionText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Answers getAnswer() {
        return answer;
    }

    public void setAnswer(Answers answer) {
        this.answer = answer;
        if (answer != null) {
            answer.setQuestion(this);
        }
    }

    @Override
    public String toString() {
        return "Question [id=" + id + ", questionText=" + questionText + ", answer=" + answer + "]";
    }
}
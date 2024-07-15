package org.ashish.model;


import jakarta.persistence.*;

@Entity
@Table(name = "answers")
public class Answers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String answerText;

    @OneToOne(mappedBy = "answers", cascade = CascadeType.ALL)
    private Question question;

    public Answers() {
    }
    public Answers(String answerText) {
        this.answerText = answerText;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAnswerText() {
        return answerText;
    }
    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Question getQuestion() {
        return this.question;
    }
    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answers [id=" + id + ", answerText=" + answerText + "]";
    }
}

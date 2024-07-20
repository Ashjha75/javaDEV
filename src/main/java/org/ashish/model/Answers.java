package org.ashish.model;

import jakarta.persistence.*;

@Entity
@Table(name = "answers")
public class Answers {

    @Id
//    @Column(name = "answer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String answerText;

    @OneToOne
//    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private Question question;

    // Constructors, getters, and setters
    public Answers() {
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
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
package org.ashish.model;

import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class Question {

    @Id
//    @Column(name = "question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String questionText;

    @OneToOne( cascade = CascadeType.ALL)
//    @JoinColumn(name = "answer_id", referencedColumnName = "id")
    private Answers answer;

    // Constructors, getters, and setters
    public Question() {
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
        answer.setQuestion(this); // Ensure the relationship is bidirectional
    }
}
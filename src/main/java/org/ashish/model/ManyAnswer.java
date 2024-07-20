package org.ashish.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class ManyAnswer {

    @Id
    @Column(name = "answer_id")
    private int id;
    private String answer;

    @ManyToOne(cascade = CascadeType.ALL)
    private ManyQuestion questions;

    public ManyAnswer(){
        System.out.println("ManyAnswer created");
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public ManyQuestion getQuestions() {
        return questions;
    }

    public void setQuestions(ManyQuestion questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "ManyAnswer{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                ", questions=" + questions +
                '}';
    }
}

package org.ashish.model;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.util.List;

@Entity
public class ManyQuestion {

    @Id
    @Column(name = "question_id")
    private int id;

    private String question;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ManyAnswer> answers;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<ManyAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<ManyAnswer> answers) {
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  ManyQuestion() {
     System.out.println("ManyQuestion created");
    }

    @Override
    public String toString() {
        return "ManyQuestion{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answers=" + answers +
                '}';
    }

}

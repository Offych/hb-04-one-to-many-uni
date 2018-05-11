package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review {

    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;
    @Column(name = "comment")
    private String comment;

    //define constructors
    public Review() {
    }

    public Review(String comment) {
        this.comment = comment;
    }

    //define getters/setters
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    //define toString

    @Override
    public String toString() {
        return "Review{" +
                "Id=" + Id +
                ", comment='" + comment + '\'' +
                '}';
    }

    //annotate fields



}

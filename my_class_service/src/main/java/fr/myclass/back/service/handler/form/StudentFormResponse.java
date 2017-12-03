package fr.myclass.back.service.handler.form;

import fr.myclass.back.service.business.Grade;

import java.io.Serializable;

/**
 * Created by alex on 11/11/17.
 */
public class StudentFormResponse implements Serializable{

    public String message;
    public Grade grade;

    public StudentFormResponse(String message, Grade grade) {
        this.message = message;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return grade.name() + " " + message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Grade getTheLevel() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}

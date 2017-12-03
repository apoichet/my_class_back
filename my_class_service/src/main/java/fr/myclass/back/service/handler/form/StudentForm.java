package fr.myclass.back.service.handler.form;

import com.sun.istack.internal.NotNull;
import fr.myclass.back.service.business.Grade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 01/11/17.
 */
public class StudentForm implements Serializable{

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String className;
    @NotNull
    private String birthDate;
    private String remark;
    private String bloodGroup;
    private List<TutorForm> tutorForms;
    private List<StudentFormResponse> responses = new ArrayList<>();

    private StudentForm(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.className = builder.className;
        this.birthDate = builder.birthDate;
        this.remark = builder.remark;
        this.bloodGroup = builder.bloodGroup;
        this.tutorForms = builder.tutorForms;
        this.responses = builder.responses;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getClassName() {
        return className;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getRemark() {
        return remark;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public List<TutorForm> getTutorForms() {
        return tutorForms;
    }

    public void addResponse(Grade grade, String message){
        responses.add(new StudentFormResponse(message, grade));
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private String lastName;
        private String firstName;
        private String className;
        private String birthDate;
        private String remark;
        private String bloodGroup;
        private List<TutorForm> tutorForms;
        private List<StudentFormResponse> responses = new ArrayList<>();

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withClassName(String className) {
            this.className = className;
            return this;
        }

        public Builder withBirthDate(String birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder withRemark(String remark) {
            this.remark = remark;
            return this;
        }

        public Builder withBloodGroup(String bloodGroup) {
            this.bloodGroup = bloodGroup;
            return this;
        }

        public Builder withTutorForms(List<TutorForm> tutorForms) {
            this.tutorForms = tutorForms;
            return this;
        }

        public Builder withResponses(List<StudentFormResponse> responses) {
            this.responses = responses;
            return this;
        }

        public StudentForm build(){
            return new StudentForm(this);
        }
    }

}

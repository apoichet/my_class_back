package fr.myclass.back.core.domain;

import java.time.LocalDate;

import static java.time.LocalDate.now;

/**
 * Created by alex on 06/10/17.
 */
public abstract class Person {

    protected Integer id;
    protected String firstName;
    protected String lastName;
    protected LocalDate birthDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Person(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Person() {
    }

    public Person(PersonBuilder builder) {
        this.id = builder.id;
        this.birthDate = builder.birthDate;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;

    }

    public static abstract class PersonBuilder<D> {
        private Integer id;
        private String firstName;
        private String lastName;
        private LocalDate birthDate;

        public PersonBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public PersonBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder withBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public abstract D build();

    }
}

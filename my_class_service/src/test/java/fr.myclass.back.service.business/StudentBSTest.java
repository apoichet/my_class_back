package fr.myclass.back.service.business;

import fr.myclass.back.core.domain.Student;
import fr.myclass.back.core.domain.Tutor;
import org.assertj.core.api.ThrowableAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.Month;

import static fr.myclass.back.service.business.AbstractBusinessException.ERR_001;
import static fr.myclass.back.service.business.AbstractBusinessException.ERR_002;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created by alex on 05/11/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class StudentBSTest {

    @InjectMocks
    private StudentBS service;

    private Student student;

    @Test
    public void should_invalid_student_with_ERR_001_when_no_tutors(){
        //Given
        student = Student.builder().build();

        //When
        when_create_expect_error(ERR_001);
    }

    @Test
    public void should_invalid_student_with_ERR_002_when_age_is_incorrect(){
        //Given
        student = (Student) Student.builder()
                .withBirthDate(LocalDate.of(LocalDate.now().minusYears(3).getYear()
                        , Month.JANUARY, 1))
                .build();
        with_tutors();

        //When
        when_create_expect_error(ERR_002);
    }

    private void with_tutors(){
        Tutor tutor = new Tutor();
        student.getTutors().add(tutor);
    }

    private void when_create_expect_error(String messagingError) {
        assertThatThrownBy(create(student))
                .isNotInstanceOf(NullPointerException.class)
                .isInstanceOf(StudentBusinessException.class)
                .hasMessageContaining(messagingError);
    }

    private ThrowableAssert.ThrowingCallable create(Student s) {
        return () -> service.create(s);
    }


}
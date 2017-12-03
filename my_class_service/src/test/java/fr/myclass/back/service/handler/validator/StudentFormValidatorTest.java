package fr.myclass.back.service.handler.validator;

import fr.myclass.back.service.handler.form.StudentForm;
import org.assertj.core.api.ThrowableAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static fr.myclass.back.service.handler.validator.AbstractValidationException.ERR_001;
import static fr.myclass.back.service.handler.validator.AbstractValidationException.ERR_002;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(MockitoJUnitRunner.class)
public class StudentFormValidatorTest {


    @InjectMocks
    private StudentFormValidator validator;

    private StudentForm.Builder form;

    @Before
    public void setUp(){
        form = StudentForm.builder();
    }

    @Test
    public void should_expect_error_when_student_first_name_is_not_present() throws Exception{
        //Given
        form.withLastName("POICHET");
        form.withFirstName(EMPTY);

        //When
        when_validate_form_assert_error(ERR_001);
    }

    @Test
    public void should_expect_error_when_student_last_name_is_not_present() throws Exception{
        //Given
        form.withLastName(EMPTY);
        form.withFirstName("Alex");

        //When
        when_validate_form_assert_error(ERR_001);
    }

    @Test
    public void should_expect_error_when_student_birth_date_is_empty() throws Exception{
        //Given
        given_form_with_mandatory_input();
        form.withBirthDate(EMPTY);

        //When
        when_validate_form_assert_error(ERR_002);
    }

    @Test
    public void should_expect_error_when_student_birth_date_is_not_date() throws Exception{
        //Given
        given_form_with_mandatory_input();
        form.withBirthDate("date");

        //When
        when_validate_form_assert_error(ERR_002);
    }

    @Test
    public void should_expect_error_when_student_birth_date_is_null() throws Exception{
        //Given
        given_form_with_mandatory_input();
        form.withBirthDate(null);

        //When
        when_validate_form_assert_error(ERR_002);
    }

    @Test
    public void should_expect_error_when_student_birth_date_format_is_incorrect() throws Exception{
        //Given
        given_form_with_mandatory_input();
        form.withBirthDate("1999/11/11");

        //When
        when_validate_form_assert_error(ERR_002);
    }

    @Test
    public void should_expect_error_when_student_birth_date_is_not_possible() throws Exception{
        //Given
        given_form_with_mandatory_input();
        form.withBirthDate("31/11/2016");

        //When
        when_validate_form_assert_error(ERR_002);
    }



    private void given_form_with_mandatory_input() {
        form.withLastName("POICHET");
        form.withFirstName("alex");
    }

    private void when_validate_form_assert_error(String error) throws Exception {
        assertThatThrownBy(validate())
                .isInstanceOf(StudentFormValidationException.class)
                .hasMessageContaining(error);
    }

    private ThrowableAssert.ThrowingCallable validate() {
        return () -> validator.validate(form.build());
    }


}
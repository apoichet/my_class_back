package fr.myclass.back.service.handler.validator;

public class StudentFormValidationException extends AbstractValidationException {

    public StudentFormValidationException(String message) {
        super(message);
    }

    public StudentFormValidationException(String codeError, String message) {
        super(codeError+message);
    }
}

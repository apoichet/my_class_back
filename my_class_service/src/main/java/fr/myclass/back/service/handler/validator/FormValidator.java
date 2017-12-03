package fr.myclass.back.service.handler.validator;

/**
 * Created by alex on 17/11/17.
 */
public interface FormValidator<F> {

    void validate(F form) throws AbstractValidationException;

}

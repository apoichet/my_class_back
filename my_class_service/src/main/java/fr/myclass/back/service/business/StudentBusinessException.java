package fr.myclass.back.service.business;

/**
 * Created by alex on 11/11/17.
 */
public class StudentBusinessException extends AbstractBusinessException{

    public StudentBusinessException(String from, String message) {
        super(from+message);
    }

    public StudentBusinessException(String from) {
        super(from);
    }
}

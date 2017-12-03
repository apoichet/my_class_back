package fr.myclass.back.service;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractServiceException extends Exception {

    private Logger LOG = Logger.getLogger(this.getClass().getName());


    public AbstractServiceException(String from, String message) {
        super(message);
        StringBuilder sb = new StringBuilder(from);
        LOG.log(Level.SEVERE, sb.append(message).toString());
    }


}

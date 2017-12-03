package fr.myclass.back.core.domain;

/**
 * Created by alex on 06/10/17.
 */
public class Contact {

    private String precision;
    private String phoneNumber;

    public Contact(String precision, String telefoneNumber) {
        this.precision = precision;
        this.phoneNumber = telefoneNumber;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

package fr.myclass.back.service.handler.form;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by alex on 01/11/17.
 */
public class TutorForm implements Serializable{

    public String firstName;
    public String lastName;
    public String remark;
    public List<Map<String, String>> contacts;
    public List<Map<String, String>> adresses;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Map<String, String>> getContacts() {
        return contacts;
    }

    public void setContacts(List<Map<String, String>> contacts) {
        this.contacts = contacts;
    }

    public List<Map<String, String>> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Map<String, String>> adresses) {
        this.adresses = adresses;
    }
}

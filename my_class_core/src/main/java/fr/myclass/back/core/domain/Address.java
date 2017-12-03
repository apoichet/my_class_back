package fr.myclass.back.core.domain;

/**
 * Created by alex on 06/10/17.
 */
public class Address {

    private String zipCode;
    private String country;
    private String address;

    public Address(String zipCode, String country, String address) {
        this.zipCode = zipCode;
        this.country = country;
        this.address = address;
    }

    public Address(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

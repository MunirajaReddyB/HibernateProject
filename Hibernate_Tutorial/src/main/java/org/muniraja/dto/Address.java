package org.muniraja.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//Address is a value type object which provides meaning to UserDetails object
//@Embeddable which tells hibernate not to create separate table for Address and it is a value type object.
@Embeddable
public class Address {

    @Column (name = "STREET_NAME")
    private String street;
    @Column (name = "CITY_NAME")
    private String City;
    @Column (name ="STATE_NAME")
    private String state;
    @Column (name = "PIN_CODE")
    private String pinCode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

}

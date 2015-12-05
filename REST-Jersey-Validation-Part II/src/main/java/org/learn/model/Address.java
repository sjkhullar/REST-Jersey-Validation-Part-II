package org.learn.model;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

public class Address {
    @NotNull(message = "Address:name cannot be empty")
    @Length(min = 2, max = 20)
    private String name;

    @NotNull(message = "Address:street cannot be empty")
    @Length(min = 2, max = 20)
    private String street;

    @NotNull(message = "Address:city cannot be empty")
    @Length(min = 2, max = 20, message = "City length should "
    		+ "be between 2 to 20 characters")
    private String city;

    private String phone;
    private String zip;

    public void setName(String name) {
        this.name = name;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public String getZip() {
        return zip;
    }

    public String toString() {
        return String.format("Name : %s, Street: %s, Phone : %s,"
        		+ " city: %s",name,street,phone,city);
    }
}

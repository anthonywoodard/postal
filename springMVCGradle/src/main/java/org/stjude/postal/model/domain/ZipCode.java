package org.stjude.postal.model.domain;

import org.stjude.postal.utility.StringUtility;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: kev
 * Date: 11/13/12
 * Time: 5:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class ZipCode implements Serializable {
    private int zipCode;
    private String city;
    private State state;

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return StringUtility.toTitleCase(city);
    }

    public void setCity(String city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}

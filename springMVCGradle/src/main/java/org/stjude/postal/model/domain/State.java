package org.stjude.postal.model.domain;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: kev
 * Date: 11/12/12
 * Time: 10:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class State implements Serializable {
    private String abbr;
    private String state;

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

package org.stjude.postal.model.impl;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * User: kev
 * Date: 11/12/12
 * Time: 10:09 AM
 * To change this template use File | Settings | File Templates.
 */

public class DAOImpl {

    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return this.dataSource;
    }

}

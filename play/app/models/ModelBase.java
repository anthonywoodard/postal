package models;

import play.db.DB;
import java.sql.Connection;

/**
 * Created with IntelliJ IDEA.
 * User: kev
 * Date: 10/16/12
 * Time: 5:42 PM
 * To change this template use File | Settings | File Templates.
 */

public class ModelBase {

    Connection connection;

    public ModelBase(){
        this.connection = DB.getConnection();
    }

}

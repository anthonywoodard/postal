package models;

import org.codehaus.jackson.node.ObjectNode;
import play.libs.Json;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: kev
 * Date: 10/16/12
 * Time: 6:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class States extends ModelBase {

    public States () {
        super();
    }

    public ArrayList<ObjectNode> list() {
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<ObjectNode> states = new ArrayList<ObjectNode>();

        try {
            stmt = this.connection.createStatement();
            stmt.setQueryTimeout(5);
            rs = stmt.executeQuery("SELECT * FROM states ORDER BY state");
            while (rs.next()) {
                ObjectNode result = Json.newObject();
                result.put("state", rs.getString("state"));
                result.put("state_abbr", rs.getString("abbr"));
                states.add(result);
            }
        }
        catch (SQLException se) {}
        return states;
    }
}

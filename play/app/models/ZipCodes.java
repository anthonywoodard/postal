package models;

import components.StringHelper;
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
public class ZipCodes extends ModelBase {

    String table = "vw_zipcodes";

    public ZipCodes () {
        super();
    }

    public ArrayList<String> query(int zipcode) {
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<String> data = new ArrayList<String>();

        try {
            stmt = this.connection.createStatement();
            stmt.setQueryTimeout(5);
            rs = stmt.executeQuery("SELECT Zipcode FROM " + this.table + " WHERE Zipcode LIKE '" + zipcode + "%' ORDER BY Zipcode");
            while (rs.next()) {
                data.add(rs.getString("Zipcode"));
            }
        }
        catch (SQLException se) {}
        return data;
    }

    public ObjectNode city(int zipcode) {
        Statement stmt = null;
        ResultSet rs = null;
        ObjectNode data = Json.newObject();

        try {
            stmt = this.connection.createStatement();
            stmt.setQueryTimeout(5);
            rs = stmt.executeQuery("SELECT City, State, Abbr FROM " + this.table + " WHERE Zipcode = " + zipcode);
            while (rs.next()) {
                data.put("city", StringHelper.toTitleCase(rs.getString("City")));
                data.put("state", rs.getString("State"));
                data.put("state_abbr", rs.getString("Abbr"));
            }
        }
        catch (SQLException se) {}
        return data;
    }

    public ObjectNode city(String city) {
        Statement stmt = null;
        ResultSet rs = null;
        ObjectNode data = Json.newObject();

        try {
            stmt = this.connection.createStatement();
            stmt.setQueryTimeout(5);
            rs = stmt.executeQuery("SELECT City, State, Abbr FROM " + this.table + " WHERE City = '" + city + "'");
            while (rs.next()) {
                data.put("city", StringHelper.toTitleCase(rs.getString("City")));
                data.put("state", rs.getString("State"));
                data.put("state_abbr", rs.getString("Abbr"));
            }
        }
        catch (SQLException se) {}
        return data;
    }

    public ArrayList<String> cities(String qry) {
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<String> data = new ArrayList<String>();

        try {
            stmt = this.connection.createStatement();
            stmt.setQueryTimeout(5);
            rs = stmt.executeQuery("SELECT DISTINCT City FROM " + this.table + " WHERE City LIKE '" + qry.toUpperCase() + "%' ORDER BY City");
            while (rs.next()) {
                data.add(StringHelper.toTitleCase(rs.getString("City")));
            }
        }
        catch (SQLException se) {}
        return data;
    }

    public ArrayList<String> state(String qry) {
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<String> data = new ArrayList<String>();

        try {
            stmt = this.connection.createStatement();
            stmt.setQueryTimeout(5);
            long start = System.currentTimeMillis();
            rs = stmt.executeQuery("SELECT DISTINCT City FROM " + this.table + " WHERE abbr = '" + qry.toUpperCase() + "' ORDER BY City");
            System.out.println("After Query: "+(System.currentTimeMillis()-start));
            while (rs.next()) {
                data.add(StringHelper.toTitleCase(rs.getString("City")));
            }
            System.out.println("After Adding to ArrayList: "+(System.currentTimeMillis()-start));
        }
        catch (SQLException se) {}
        return data;
    }

    public ArrayList<String> states(String city) {
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<String> data = new ArrayList<String>();

        try {
            stmt = this.connection.createStatement();
            stmt.setQueryTimeout(5);
            rs = stmt.executeQuery("SELECT DISTINCT State FROM " + this.table + " WHERE City = '" + city.toUpperCase() + "' ORDER BY State");
            while (rs.next()) {
                data.add(rs.getString("State"));
            }
        }
        catch (SQLException se) {}
        return data;
    }
}

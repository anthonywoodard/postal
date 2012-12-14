package controllers;

import models.States;
import models.ZipCodes;
import org.codehaus.jackson.node.ObjectNode;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;

public class Data extends Controller {

    public static Result zip(String code) {
        ZipCodes z = new ZipCodes();
        ObjectNode data = z.city(Integer.parseInt(code));
        return ok(Json.toJson(data));
    }

    public static Result zips(String qry) {
        ZipCodes z = new ZipCodes();
        ArrayList<String> data = z.query(Integer.parseInt(qry));
        return ok(Json.toJson(data));
    }

    public static Result city(String qry) {
        ZipCodes z = new ZipCodes();
        ObjectNode data = z.city(qry);
        return ok(Json.toJson(data));
    }

    public static Result cities(String qry) {
        ZipCodes z = new ZipCodes();
        ArrayList<String> data = z.cities(qry);
        return ok(Json.toJson(data));
    }

    public static Result citystates(String city) {
        ZipCodes z = new ZipCodes();
        ArrayList<String> data = z.states(city);
        return ok(Json.toJson(data));
    }

    public static Result states() {
        States s = new States();
        ArrayList<ObjectNode> data = s.list();
        return ok(Json.toJson(data));
    }

    public static Result state(String qry) {
        ZipCodes z = new ZipCodes();
        ArrayList<String> data = z.state(qry);
        return ok(Json.toJson(data));
    }
}
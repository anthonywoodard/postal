package org.stjude.postal.utility;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: kev
 * Date: 11/13/12
 * Time: 5:12 PM
 * To change this template use File | Settings | File Templates.
 */
public final class StringUtility {

    private StringUtility(){}

    public static String toTitleCase(String input) {
        StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;

        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toUpperCase(c);
                nextTitleCase = false;
            } else {
                c = Character.toLowerCase(c);
            }
            titleCase.append(c);
        }

        return titleCase.toString();
    }

    public static String toJsonP(Object object, String callback) {
        StringBuffer jsonp = new StringBuffer();
        if(callback != null && callback.trim().length() > 0){
            jsonp.append(";");
            jsonp.append(callback);
            jsonp.append("(");
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            jsonp.append(objectMapper.writeValueAsString(object));
        } catch (JsonMappingException e) {
        } catch (JsonGenerationException e) {
        } catch (IOException e) {
        }
        if(callback != null){
            jsonp.append(");");
        }
        return jsonp.toString();
    }
}

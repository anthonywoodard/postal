package components;

/**
 * Created with IntelliJ IDEA.
 * User: kev
 * Date: 10/16/12
 * Time: 8:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringHelper {
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
}

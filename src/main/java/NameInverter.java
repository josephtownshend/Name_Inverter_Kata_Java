
import java.util.ArrayList;
import java.util.List;
import com.google.common.collect.Lists;

public class NameInverter {

    public static String invert(String name) {
        List<String> nameParts = breakIntoPartsIgnoringWhitespace(name);

        if (nameParts.size() < 2)
            return nameParts.get(0);

        return invert(nameParts);
    }

    private static ArrayList<String> breakIntoPartsIgnoringWhitespace(String name) {
        return Lists.newArrayList(name.trim().split(RegExps.anyAmountOfWhiteSpace()));
    }

    private static String invert(List<String> nameParts) {
        String first = nameParts.get(0);
        String last = nameParts.get(1);

        return String.format("%s, %s", last, first);
    }
}

class RegExps {

    public static String anyAmountOfWhiteSpace() {
        return "\\s+";
    }
}
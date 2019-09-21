
import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class NameInverter {

    public static String invert(String name) {
        List<String> nameParts = breakIntoPartsIgnoringWhitespace(name);

        if (nameParts.size() < 2)
            return nameParts.get(0);

        return invert(withoutHonorifics(nameParts));
    }

    private static List<String> withoutHonorifics(List<String> nameParts) {
        if (Honorifics.isHonorificThere(nameParts.get(0)))
            nameParts.remove(0);
        return nameParts;
    }

    private static ArrayList<String> breakIntoPartsIgnoringWhitespace(String name) {
        return Lists.newArrayList(name.trim().split(RegExps.anyAmountOfWhiteSpace()));
    }

    private static String invert(List<String> nameParts) {
        String first = nameParts.get(0);
        String last = nameParts.get(1);
        String postnominals = findAndMergePostnominals(nameParts);

        return String.format("%s, %s %s", last, first, postnominals).trim();
    }

    private static String findAndMergePostnominals(List<String> nameParts) {
        String postnominals = "";
        for (String np : nameParts.subList(2, nameParts.size()))
            postnominals += np + " ";
        return postnominals;
    }
}

class RegExps {

    public static String anyAmountOfWhiteSpace() {
        return "\\s+";
    }
}

class Honorifics {

    public static final ImmutableList<String> KNOWN_HONORIFICS = ImmutableList.of("Mr.", "Mrs.");

    public static boolean isHonorificThere(String s) {
        ImmutableList<String> knownHonorifics = KNOWN_HONORIFICS;
        return knownHonorifics.contains(s);
    }
}
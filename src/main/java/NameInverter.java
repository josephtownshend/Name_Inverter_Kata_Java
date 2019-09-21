
import java.util.List;
import com.google.common.collect.Lists;

public class NameInverter {

    public static String invert(String name) {
        List<String> nameParts = Lists.newArrayList(name.trim().split(" "));

        String first = nameParts.get(0);
        String last = nameParts.get(1);
        return String.format("%s, %s", last, first);
    }
}

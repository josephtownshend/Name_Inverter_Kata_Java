import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class NameInverterTest {

    @Test (expected = NullPointerException.class)
    public void invert_null_shouldThrowNullPointerException() {
        NameInverter.invert(null);
    }

    @Test
    public void invert_emptyString_shouldReturnEmptyString() {
        assertThat(NameInverter.invert(""), is(""));
        assertThat(NameInverter.invert("   "), is(""));

    }
}

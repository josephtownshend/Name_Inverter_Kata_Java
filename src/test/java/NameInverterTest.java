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

    @Test
    public void invert_firstName_shouldReturnFirstName() {
        assertThat(NameInverter.invert("John"), is ("John"));
        assertThat(NameInverter.invert("   John   "), is ("John"));
    }

    @Test
    public void invert_firstLast_shouldReturnLastCommaFirstName() {
        assertThat(NameInverter.invert("John Smith"), is("Smith, John"));
        assertThat(NameInverter.invert("John    Smith"), is("Smith, John"));

    }
}

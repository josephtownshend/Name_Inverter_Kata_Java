import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import javax.naming.Name;

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

    @Test
    public void invert_honorificsFirstLast_shouldReturnLastCommaFirstName() {
        assertThat(NameInverter.invert("Mr. John Smith"), is("Smith, John"));
        assertThat(NameInverter.invert("Mrs. John Smith"), is("Smith, John"));
    }

    @Test
    public void invert_firstLastPostnominals_shouldReturnLastCommaFirstPostnominals() {
        assertThat(NameInverter.invert("John Smith Sr."), is ("Smith, John Sr."));
        assertThat(NameInverter.invert("John Smith Sr. PhD."), is ("Smith, John Sr. PhD."));
    }

    @Test
    public void invert_acceptanceTests() {
        assertThat(NameInverter.invert("Mr.    John    Smith    Sr.   PhD."), is("Smith, John Sr. PhD."));
    }
}

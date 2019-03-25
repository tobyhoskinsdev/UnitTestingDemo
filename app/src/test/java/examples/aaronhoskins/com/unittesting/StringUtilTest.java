package examples.aaronhoskins.com.unittesting;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class StringUtilTest {

    Student mockStudent;

    @Before
    public void setup() {
        mockStudent = mock(Student.class);
        Mockito.when(mockStudent.getStudentName()).thenReturn("Bob");
    }

    @Test
    public void testConcatTwoStrings() {
        final String one = "test";
        final String two = "method";
        final String expectResult = one + " " + two;

        assertEquals(expectResult, StringUtil.concatTwoStrings(one,two));
    }

    @Test
    public void testStringLengthGreaterThanFive_True(){
        assertTrue(StringUtil.stringLengthGreaterThanFive("Hoskins"));
    }

    @Test
    public void testStringLengthGreaterThanFive_False(){
        assertFalse(StringUtil.stringLengthGreaterThanFive("cat"));
    }

    @Test
    public void testReturnString_Null() {
        final String testString = null;
        assertNull(StringUtil.returnString(testString));
    }

    @Test
    public void testReturnString_NotNull() {
        String testString = "I HAVE A VALUE";
        assertNotNull(testString);
    }

    @Test
    public void testProcessStudentName() {
        final String middleText = " has a gpa of ";
        final String mockGpaValue = "3.0";
        final String expectedResult = "Bob" + middleText + mockGpaValue;

        Mockito.when(mockStudent.getStudentGPA()).thenReturn(mockGpaValue);
        assertEquals(expectedResult, StringUtil.processStudentName(mockStudent));
    }

    @Test
    public void testProcessStudentGpa() {
        StringUtil.processGpa(mockStudent);
        Mockito.verify(mockStudent, times(1)).processGpa();
    }


//    @Test
//    public void testStringLengthGreaterThanFive(){
//        assertFalse(StringUtil.stringLengthGreaterThanFive("cat"));
//        assertTrue(StringUtil.stringLengthGreaterThanFive("Hoskins"));
//    }
}

package ca.jrvs.practice.codingChallenge;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class ValidParenthesesTest extends TestCase {

    ValidParentheses validParentheses;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        validParentheses = new ValidParentheses();
    }

    @Test
    public void testIsValid() {

        assertEquals(true, validParentheses.isValid("()"));
        assertEquals(true, validParentheses.isValid("()[]{}"));
        assertEquals(false, validParentheses.isValid("(]"));
        assertEquals(false, validParentheses.isValid("([)]"));
        assertEquals(true, validParentheses.isValid("{[]}"));

    }
}
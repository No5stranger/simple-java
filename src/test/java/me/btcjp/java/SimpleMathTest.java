package me.btcjp.java;

import junit.framework.TestCase;

public class SimpleMathTest extends TestCase {

    public void testReminder()
    {
        int a = 3;
        int b = 2;
        SimpleMath simpleMath = new SimpleMath(a, b);
        assertEquals(1, simpleMath.reminder());
    }
}

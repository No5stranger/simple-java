package me.btcjp.java;

import org.junit.*;

public class SimpleMathTest {

    @Test
    public void testReminder()
    {
        int a = 3;
        int b = 2;
        SimpleMath simpleMath = new SimpleMath(a, b);
        Assert.assertEquals(1, simpleMath.reminder());
    }
}

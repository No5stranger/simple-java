package me.btcjp.java;

public class SimpleMath
{

    private int a;
    private int b;

    public SimpleMath(int a, int b)
    {
        this.a = a;
        this.b = b;
    }

    public int reminder()
    {
        return this.a % this.b;
    }
}

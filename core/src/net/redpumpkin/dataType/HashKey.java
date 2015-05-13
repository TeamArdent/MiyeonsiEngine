package net.redpumpkin.dataType;

public class HashKey
{
    public static final String KEY = "0123456789aAbBcCdDeEfFgGhHiIjJkKmMnNlLoOpPqQrRsStTuUvVwWxXyYzZ";
    public String value;

    public HashKey()
    {
        genNewKey(32);
    }

    public HashKey(int length)
    {
        genNewKey(length);
    }

    public String getKey()
    {
        return this.value;
    }

    public void genNewKey(int length)
    {
        this.value = "";

        for (int i = 0; i < length; i++)
        {
            this.value += KEY.toCharArray()[(int) (Math.random() * KEY.length())];
        }
    }
}
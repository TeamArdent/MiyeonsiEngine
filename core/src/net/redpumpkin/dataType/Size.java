package net.redpumpkin.dataType;

public class Size
{
    public int w, h;

    public Size()
    {
        this.w = 0;
        this.h = 0;
    }

    public Size(int w, int h)
    {
        this.w = w;
        this.h = h;
    }

    public Size(Size s)
    {
        this.w = s.w;
        this.h = s.h;
    }

    public boolean equals(Size s)
    {
        return (this.w == s.w && this.h == s.h);
    }

    public Size getLocation()
    {
        return this;
    }

    public int getW()
    {
        return this.w;
    }

    public int getH()
    {
        return this.h;
    }

    public void move(int w, int h)
    {
        this.w += w;
        this.h += h;
    }

    public void move(Size s)
    {
        this.w += s.w;
        this.h += s.h;
    }

    public void setSize(int w, int h)
    {
        this.w = w;
        this.h = h;
    }

    public void setSize(Size s)
    {
        this.w = s.w;
        this.h = s.h;
    }

    @Override
    public String toString()
    {
        return this.w + " " + this.h;
    }

    public Point toLocation()
    {
        return new Point(this.w, this.h);
    }
}

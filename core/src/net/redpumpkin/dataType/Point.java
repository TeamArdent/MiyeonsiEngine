package net.redpumpkin.dataType;

public class Point
{
    public int x, y;

    public Point()
    {
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Point(Point p)
    {
        this.x = p.x;
        this.y = p.y;
    }

    public boolean equals(Point object)
    {
        return (this.x == object.x && this.y == object.y);
    }

    public Point getLocation()
    {
        return this;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public void move(int x, int y)
    {
        this.x += x;
        this.y += y;
    }

    public void move(Point p)
    {
        this.x += p.x;
        this.y += p.y;
    }

    public void setLocation(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void setLocation(Point p)
    {
        this.x = p.x;
        this.y = p.y;
    }

    @Override
    public String toString()
    {
        return this.x + " " + this.y;
    }

    public Size toSize()
    {
        return new Size(this.x, this.y);
    }
}

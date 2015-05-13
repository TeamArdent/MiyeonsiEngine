package net.redpumpkin.dataType;

public class Rect
{
    public Point location;
    public Size size;

    public Rect()
    {
        this.location = new Point();
        this.size = new Size();
    }

    public Rect(int x, int y, int w, int h)
    {
        this.location = new Point(x, y);
        this.size = new Size(w, h);
    }

    public Rect(Point location, Size size)
    {
        this.location = location;
        this.size = size;
    }

    public boolean intersect(Rect rect)
    {
        return intersect(this, rect);
    }

    public boolean intersect(int x, int y, int w, int h)
    {
        return intersect(this, new Rect(x, y, w, h));
    }

    public static boolean intersect(Rect a, Rect b)
    {
        int aLeft = a.location.x;
        int aRight = a.location.x + a.size.w;
        int aTop = a.location.y;
        int aBottom = a.location.y + a.size.h;

        int bLeft = b.location.x;
        int bRight = b.location.x + b.size.w;
        int bTop = b.location.y;
        int bBottom = b.location.y + b.size.h;

        if(aRight >= bLeft && aLeft <= bRight && aBottom >= bTop && aTop <= bBottom)
            return true;
        return false;
    }

    public Point center()
    {
        return new Point(this.location.x + (this.size.w / 2), this.location.y + (this.size.h / 2));
    }
}

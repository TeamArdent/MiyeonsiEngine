package kr.pe.ardent.miyeonsi_engine.libs;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import net.redpumpkin.dataType.Point;
import net.redpumpkin.dataType.Size;

public abstract class GameObject implements GameObjectInterface
{
    public Point location;
    public Size size;

    public AnimatedTexture texture;

    ////////////////////////////////////////////////////////////////

    public GameObject()
    {
        this.location = new Point();
        this.size = new Size();
    }

    public GameObject(int x, int y, int w, int h)
    {
        this.location = new Point(x, y);
        this.size = new Size(w, h);
    }

    public GameObject(Point point, Size size)
    {
        this.location = point;
        this.size = size;
    }

    ////////////////////////////////////////////////////////////////

    public void render(SpriteBatch batch)
    {
        batch.draw(this.texture.getTexture(), this.location.x, this.location.y);
    }

    ////////////////////////////////////////////////////////////////

    public Texture getTexture()
    {
        return this.texture.getTexture();
    }

    public void setTexture(AnimatedTexture texture)
    {
        this.texture = texture;
    }
}
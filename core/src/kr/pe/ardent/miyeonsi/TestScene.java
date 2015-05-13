package kr.pe.ardent.miyeonsi;

import com.badlogic.gdx.graphics.g2d.Batch;
import kr.pe.ardent.miyeonsi_engine.libs.GameObject;
import kr.pe.ardent.miyeonsi_engine.libs.Scene;
import net.redpumpkin.dataType.HashKey;

public class TestScene extends Scene
{
    @Override
    public void create()
    {
        HashKey id = this.registerObject(new GameObject() {
            @Override
            public void update() {
                this.location.move(1, 1);

                System.out.println(this.location.toString());
            }
        });
    }

    @Override
    public void destroy()
    {

    }

    @Override
    public void render(Batch batch)
    {

    }
}

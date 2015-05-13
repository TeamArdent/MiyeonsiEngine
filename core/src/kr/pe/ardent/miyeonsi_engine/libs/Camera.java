package kr.pe.ardent.miyeonsi_engine.libs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Camera extends OrthographicCamera
{
    public void configureCamera()
    {
        this.setToOrtho(false, Gdx.graphics.getWidth(),  Gdx.graphics.getHeight());
    }
}

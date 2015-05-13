package kr.pe.ardent.miyeonsi_engine.libs;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface SceneInterface
{
    public void onCreate();
    public void onDestroy();

    public void onUpdate(Scene scene);
    public void onRender(SpriteBatch batch);

    public void onSceneMouseDown(int x, int y, int pointer);
    public void onSceneMouseUp(int x, int y, int pointer);
    public void onSceneMouseDrag(int x, int y);
    public void onSceneMouseMove(int x, int y);
}

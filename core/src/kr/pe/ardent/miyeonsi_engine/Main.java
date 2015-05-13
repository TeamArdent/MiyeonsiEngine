package kr.pe.ardent.miyeonsi_engine;

import com.badlogic.gdx.ApplicationAdapter;
import kr.pe.ardent.miyeonsi.TestScene;

public class Main extends ApplicationAdapter
{
    @Override
    public void create()
    {
        SceneController.changeScene(new TestScene());
    }

    @Override
    public void render()
    {
        SceneController.render();
    }

    @Override
    public void dispose()
    {
        SceneController.dispose();
    }

    @Override
    public void resize(int width, int height)
    {
        SceneController.resize(width, height);
    }

    @Override
    public void pause()
    {
        SceneController.pause();
    }

    @Override
    public void resume()
    {
        SceneController.resume();
    }
}
package kr.pe.ardent.miyeonsi_engine;

import kr.pe.ardent.miyeonsi_engine.libs.Scene;

public class SceneController
{
    public static Scene nowScene = null;

    public static void changeScene(Scene newScene)
    {
        if(SceneController.nowScene != null)
        {
            SceneController.nowScene.dispose();
        }
        SceneController.nowScene = newScene;
    }

    public static void render()
    {
        SceneController.nowScene.render();
    }
    public static void dispose()
    {
        SceneController.nowScene.dispose();
    }
    public static void resize(int w, int h)
    {
        SceneController.nowScene.resize(w, h);
    }
    public static void pause()
    {
        SceneController.nowScene.pause();
    }
    public static void resume()
    {
        SceneController.nowScene.resume();
    }
}

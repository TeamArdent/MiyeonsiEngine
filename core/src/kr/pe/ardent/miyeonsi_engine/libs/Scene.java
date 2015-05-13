package kr.pe.ardent.miyeonsi_engine.libs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.HashMap;
import java.util.Map;

public abstract class Scene implements SceneInterface, Runnable, InputProcessor
{
    protected SpriteBatch batch;
    protected BitmapFont font;
    protected ShapeRenderer shape;
    protected Camera camera;

    protected int size;

    protected int fps;
    protected long cnt;
    protected long lastDeltatime = 0L;

    protected boolean isReady = false;

    private HashMap<String, GameObject> regObjects = new HashMap<>();

    ////////////////////////////////////////////////////////////////

    public Scene()
    {
        this.batch = new SpriteBatch();
        this.font = new BitmapFont();
        this.shape = new ShapeRenderer();
        this.camera = new Camera();

        this.fps = 60;

        Gdx.input.setInputProcessor(this);
        this.camera.configureCamera();

        this.shape.setColor(Color.BLACK);
        this.shape.setProjectionMatrix(this.camera.combined);

        this.onCreate();
        this.isReady = true;
    }

    ////////////////////////////////////////////////////////////////

    @Override
    public boolean touchDown(int x, int y, int pointer, int button)
    {
        y = Gdx.graphics.getHeight() - y;

        for(Map.Entry<String, GameObject> entry : this.regObjects.entrySet())
        {
            GameObject object = entry.getValue();
            object.onSceneMouseDown(this, x, y, button);

            if(x > object.location.x && x < object.location.x + object.size.w && y > object.location.y && y < object.location.y + object.size.h)
            {
                object.onMouseDown(this, x, y, button);
            }
        }

        return false;
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button)
    {
        y = Gdx.graphics.getHeight() - y;

        for(Map.Entry<String, GameObject> entry : this.regObjects.entrySet())
        {
            GameObject object = entry.getValue();
            object.onSceneMouseUp(this, x, y, button);

            if(x > object.location.x && x < object.location.x + object.size.w && y > object.location.y && y < object.location.y + object.size.h)
            {
                object.onMouseUp(this, x, y, button);
            }
        }

        return false;
    }

    @Override
    public boolean touchDragged(int x, int y, int pointer)
    {
        y = Gdx.graphics.getHeight() - y;

        for(Map.Entry<String, GameObject> entry : this.regObjects.entrySet())
        {
            GameObject object = entry.getValue();
            object.onSceneMouseDrag(this, x, y);

            if(x > object.location.x && x < object.location.x + object.size.w && y > object.location.y && y < object.location.y + object.size.h)
            {
                object.onMouseDrag(this, x, y);
            }
        }

        return false;
    }

    @Override
    public boolean mouseMoved(int x, int y)
    {
        y = Gdx.graphics.getHeight() - y;

        for(Map.Entry<String, GameObject> entry : this.regObjects.entrySet())
        {
            GameObject object = entry.getValue();
            object.onSceneMouseMove(this, x, y);

            if(x > object.location.x && x < object.location.x + object.size.w && y > object.location.y && y < object.location.y + object.size.h)
            {
                object.onMouseMove(this, x, y);
            }
        }

        return false;
    }

    @Override
    public boolean scrolled(int amount)
    {
        return false;
    }

    public void run()
    {
        this.cnt ++;
        this.update(this.cnt);

        for(Map.Entry<String, GameObject> entry : this.regObjects.entrySet())
        {
            GameObject object = entry.getValue();
            object.onUpdate(this);
        }
    }

    public void render()
    {
        if(!this.isReady) return;

        long deltatime = System.currentTimeMillis();
        if(deltatime - this.lastDeltatime > (long)(1000 / this.fps))
        {
            this.lastDeltatime = deltatime;

            this.run();
        }

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.camera.update();
        this.batch.setProjectionMatrix(camera.combined);

        this.draw(this.batch, this.font, this.shape);
    }

    public void drawObject()
    {
        for(Map.Entry<String, GameObject> entry : this.regObjects.entrySet())
        {
            entry.getValue().render(this.batch);
        }
    }

    protected void update(long cnt)
    {}

    protected void draw(SpriteBatch batch, BitmapFont font, ShapeRenderer shape)
    {}

    public void dispose()
    {
        this.batch.dispose();
        this.font.dispose();

        this.destroy();
    }

    public void destroy()
    {}

    public void resize(int width, int height)
    {
        this.camera.configureCamera();
    }

    public void pause()
    {}

    public void resume()
    {}

    @Override
    public boolean keyDown(int keycode)
    {
        return false;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        return false;
    }

    @Override
    public boolean keyTyped(char keychar)
    {
        return false;
    }



    ////////////////////////////////////////////////////////////////

    protected void registerObject(String id, GameObject object) {
        this.regObjects.put(id, object);
        object.onCreate(this);
    }

    protected GameObject getObject(String id)
    {
        return this.regObjects.get(id);
    }
}
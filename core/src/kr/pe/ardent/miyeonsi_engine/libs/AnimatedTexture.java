package kr.pe.ardent.miyeonsi_engine.libs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimatedTexture
{
    protected Animation[] texture = null;

    protected float time = 0f;
    private int textureIndex = 0;
    private boolean isRunnable = false;

    public AnimatedTexture(Texture textureSet, int textureCols, int textureRows, float textureDelay)
    {
        setTexture(textureSet, textureCols, textureRows, textureDelay);
    }

    public void setTexture(Texture textureSet, int textureCols, int textureRows, float textureDelay)
    {
        this.isRunnable = false;

        TextureRegion[][] frames = TextureRegion.split(textureSet, textureSet.getWidth() / textureCols, textureSet.getHeight() / textureRows);
        this.texture = new Animation[frames.length];

        int idx = 0;
        for(TextureRegion[] frame : frames)
        {
            this.texture[idx] = new Animation(textureDelay, frame);

            idx ++;
        }

        this.isRunnable = true;
    }

    public void update()
    {
        if(!this.isRunnable) return;

        this.time += Gdx.graphics.getDeltaTime();
    }

    public Texture getTexture()
    {
        return this.texture[textureIndex].getKeyFrame(this.time, true).getTexture();
    }

    public Texture getTexture(boolean isLoop)
    {
        return this.texture[textureIndex].getKeyFrame(this.time, isLoop).getTexture();
    }
}

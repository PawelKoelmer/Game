package Screens.BowmanGame.Hero;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class Player extends Actor {

    private boolean flipedLeft = false;
    private boolean flipedRight= true;
    public Rectangle bounds;
    public Animation animWalk;
    public TextureRegion region;
    public float velocityX;
    public float velocityY;
    private static final int W=120;
    private static final int H=120;

    public Player(){

        super();
        region = new TextureRegion();
        bounds = new Rectangle();
        velocityX=0;
        velocityY=0;
    }
    public void setTexture(Texture t){
        setWidth( W );
        setHeight( H );
        region.setRegion(t);

    }
    public Rectangle getBoundingRectangle(){
        bounds.set( getX(), getY(), getWidth(), getHeight());
        return bounds;
    }
    public void act(float dt){
        super.act( dt );
        moveBy( velocityX * dt, velocityY * dt );
    }
    public void draw(Batch batch, float parentAlpha){
        Color c = getColor();batch.setColor(c.r, c.g, c.b, c.a);
        if ( isVisible() ) {
            batch.draw(region , getX(), getY(), getOriginX(),
                    getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        }
    }
    public void flip(Boolean f){
        region.flip(f,false);
    }
    public boolean isFlipedLeft() {
        return flipedLeft;
    }

    public void setFlipedLeft(boolean fliped) {
        this.flipedLeft = fliped;
    }
    public boolean isFlipedRight() {
        return flipedRight;
    }

    public void setFlipedRight(boolean flipedRight) {
        this.flipedRight = flipedRight;
    }


}

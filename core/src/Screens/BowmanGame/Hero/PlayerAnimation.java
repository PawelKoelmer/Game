package Screens.BowmanGame.Hero;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.utils.Array;


public class PlayerAnimation {

    public TextureAtlas.AtlasRegion regions;
    public final Animation animWalk;


    public PlayerAnimation(TextureAtlas atlas){


        TextureAtlas moving = new TextureAtlas(Gdx.files.internal("HeroWalk.atlas"));
        Array<TextureAtlas.AtlasRegion> regions = moving.findRegions("3_WALK");
        TextureAtlas.AtlasRegion region = regions.first();
        for(int i=0;i<5;i++){
            regions.insert(0,region);
        }
        animWalk = new Animation(1.0f/20f,regions, Animation.PlayMode.LOOP_PINGPONG);

    }
}

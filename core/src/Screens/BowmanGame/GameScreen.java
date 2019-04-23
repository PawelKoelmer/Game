package Screens.BowmanGame;

import Screens.AbstractScreen;
import Screens.BowmanGame.Hero.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Bowman;

public class GameScreen extends AbstractScreen {



    private Texture bgTexture;
    private Player player;
    Music forestSound;

    public GameScreen(Bowman game) {
        super(game);
        init();
        game.setStarted(false);
    }
    private void init(){
        bgTexture = new Texture("Forest.png");
        forestSound = Gdx.audio.newMusic(Gdx.files.internal("Jungle.wav"));
//        forestSound.isLooping();
//        forestSound.play();
        initPlayer();
    }
    private void initPlayer(){
        player = new Player();
        player.setTexture(new Texture(Gdx.files.internal("Static.png")));
        player.setPosition(20,0);
        stage.addActor(player);

    }

    @Override
    public void render(float delta){
        super.render(delta);

        player.velocityX=0;
        player.velocityY=0;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            player.velocityX -= 100;
           if(player.isFlipedLeft() == false){
               player.setFlipedLeft(true);
               player.flip(player.isFlipedLeft());
               player.setFlipedRight(false);
           }

        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            player.velocityX += 100;
            if(player.isFlipedRight() == false){
                player.setFlipedRight(true);
                player.flip(player.isFlipedRight());
                player.setFlipedLeft(false);
            }
        }
        float dt = Gdx.graphics.getDeltaTime();


        spriteBatch.begin();
        spriteBatch.draw(bgTexture,0,0,camera.viewportWidth,camera.viewportHeight);
        spriteBatch.end();
        spriteBatch.begin();
        stage.act(dt);
        stage.draw();
        spriteBatch.end();
    }

}

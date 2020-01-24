package com.mygdx.game.Scenes;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Utils.Constants;

import javax.swing.text.View;

public class Hud {
    private Stage stage;
    private Viewport viewport;
    private int worldTimer;
    private float timeCount;
    private int Score;
    Label countDownLabel;
    private Texture myTexture;
    private TextureRegion myTextureRegion;
    private TextureRegionDrawable myTexRegionDrawable;
    private ImageButton button;
    public Hud(SpriteBatch sb, Viewport viewport, Stage stage){
        worldTimer = 300;
        timeCount = 0;
        Score = 0;
        this.stage = stage;
        myTexture = new Texture("playImage.png");
        myTextureRegion = new TextureRegion(myTexture);
        myTexRegionDrawable = new TextureRegionDrawable(myTextureRegion);
        button = new ImageButton(myTexRegionDrawable); //Set the button up
        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                //System.out.println("Strating game");

            }
        });
        this.viewport = viewport;
        //stage = new Stage(viewport, sb);
        stage.addActor(button);
        Table table = new Table();
        table.top();
        table.setFillParent(true);
        //stage.draw();

    }

}

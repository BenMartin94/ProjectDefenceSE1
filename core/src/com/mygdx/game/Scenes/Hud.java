package com.mygdx.game.Scenes;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Utils.Constants;

import javax.swing.text.View;

public class Hud {
    public Stage stage;
    private Viewport viewport;
    private int worldTimer;
    private float timeCount;
    private int Score;
    Label countDownLabel;
    public Hud(SpriteBatch sb){
        worldTimer = 300;
        timeCount = 0;
        Score = 0;
        viewport = new FitViewport(Constants.width, Constants.height, new OrthographicCamera());
        stage = new Stage(viewport, sb);

    }

}

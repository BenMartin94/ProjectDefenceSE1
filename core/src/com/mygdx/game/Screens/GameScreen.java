package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.CenteredFont;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Scenes.Hud;
import com.mygdx.game.Utils.*;

public class GameScreen implements Screen {
    private MyGdxGame game;
    Texture texture;
    private CenteredFont title;
    private Stage stage;
    private OrthographicCamera gameCam;
    private Viewport gamePort;
    private Hud hud;
    private Image backGround;
    public GameScreen(MyGdxGame game){
        this.game = game;
        texture = new Texture("PDBackGround.png");

        title = new CenteredFont();
        gameCam = new OrthographicCamera();
        gamePort = new FitViewport(Constants.width, Constants.height,gameCam);
        stage = new Stage(gamePort, game.batch);

        hud = new Hud(game.batch, gamePort, stage);

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.input.setInputProcessor(stage);
        game.batch.setProjectionMatrix(gameCam.combined);
        stage.getBatch().begin();
        stage.getBatch().draw(texture, 0, 0, Constants.width, Constants.height);
        title.draw(game.batch, "Project Defence!", 0+Constants.width/2-title.getRegion().getRegionWidth()*3/10, 0+Constants.height*9/10);
        title.getData().setScale(3f);
        stage.getBatch().end();
        //game.batch.begin();
        //game.batch.draw(texture, 0-Constants.width/2, 0-Constants.height/2, Constants.width, Constants.height);
        //
        stage.draw();


        //game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

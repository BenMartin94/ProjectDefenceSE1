package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.InputHandlers.WorldGestureListener;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Utils.Constants;
import com.mygdx.game.Utils.GestureData;

import java.util.Observable;
import java.util.Observer;

public class WorldScreen implements Screen,Observer {
    private MyGdxGame game;
    private Stage stage;
    private OrthographicCamera gameCam;
    private Viewport gamePort;
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private WorldGestureListener gestureListener;
    public WorldScreen(MyGdxGame game){
        this.game = game;
        gameCam = new OrthographicCamera();
        gamePort = new FitViewport(Constants.width, Constants.height, gameCam);
        stage = new Stage(gamePort, game.batch);
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("first.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        gameCam.position.set(gamePort.getWorldWidth()/2, gamePort.getWorldHeight()/2, 0);
        gestureListener = new WorldGestureListener();
        gestureListener.addObserver(this);
        Gdx.input.setInputProcessor(new GestureDetector(gestureListener));

    }
    public void handleInput(float dt){/*
        if(Gdx.input.isTouched()){
            float x = -Gdx.input.getDeltaX();
            float y = Gdx.input.getDeltaY();
            gameCam.position.x+=x;
            gameCam.position.y+=y;
        }
        */
    }
    public void update(float dt){
        handleInput(dt);
        gameCam.update();
        renderer.setView(gameCam);

    }

    //observer update
    public void update(Observable observable, Object obj){
        GestureData data;
        if(observable == gestureListener){
            data = gestureListener.getData();
            if(data.gestureType.equals("touchDown")){
                //do touch logic
            }
            else if(data.gestureType.equals("pan")){
                float x = -data.gestureData.get(2);
                float y = data.gestureData.get(3);
                gameCam.position.x+=x;
                gameCam.position.y+=y;
            }
            else if(data.gestureType.equals("zoom")){
                float zoomVal = data.gestureData.get(1)-data.gestureData.get(0);
                gameCam.zoom+=zoomVal/40000;
                if(gameCam.zoom>Constants.zoomMax){
                    gameCam.zoom = Constants.zoomMax;
                }
                else if(gameCam.zoom<Constants.zoomMin){
                    gameCam.zoom = Constants.zoomMin;
                }

            }
            else if(data.gestureType.equals("pinch")){

            }
        }
    }

    @Override
    public void show() {

    }



    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.render();
        game.batch.setProjectionMatrix(gameCam.combined);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

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
    public MyGdxGame getGame() {
        return game;
    }
}

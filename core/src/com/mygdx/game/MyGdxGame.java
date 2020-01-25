package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.game.Screens.*;


public class MyGdxGame extends Game {
	public SpriteBatch batch;
	//Texture img;

	CenteredFont title;
	TextButton play;
	private int width;
	private int height;
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new GameScreen(this));
		//cam = new OrthographicCamera();
		//(cam).setToOrtho(false, 600, 800)
		//title = new CenteredFont();
		//play = new TextButton("Play", new Skin());
		//width = Gdx.graphics.getWidth();
		//height = Gdx.graphics.getHeight();
	}

	@Override
	public void render () {
		super.render();
		/*
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		batch.draw(img, 0, 0, width, height);

		title.drawCentered(batch, "Project Defence!", width/2, height*9/10);
		title.getData().setScale(10f);

		batch.end();
		*/
	}
	
	@Override
	public void dispose () {
		//batch.dispose();
		//img.dispose();
	}
}

package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;


import java.awt.*;
import java.io.IOException;

import static java.awt.image.ImageObserver.WIDTH;

public class Mali50Centa extends ApplicationAdapter {
	SpriteBatch batch;
	Background bg;
	Bird bird;
	Obstacle obstacle;
	boolean gameOver;
	Texture restartTexture;
	Score score;
	Sound sound;


	@Override
	public void create() {
		batch = new SpriteBatch();
		bg = new Background();
		bird = new Bird();
		obstacle = new Obstacle();
		gameOver = false;
		restartTexture = new Texture("RestartBtn.png");
        score = new Score();


	}

	@Override
	public void render() {
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		bg.render(batch);
		obstacle.render(batch);
		if (!gameOver) {
			bird.render(batch);
		} else {
			batch.draw(restartTexture, 200, 200);
		}
		//score.render(batch);
		batch.end();

	}

	public void update() { //логика прогрыша
		bg.update();
		bird.update();
		obstacle.update();
		for (int i = 0; i < Obstacle.obs.length; i++) {
			if (bird.position.x > Obstacle.obs[i].position.x && bird.position.x < Obstacle.obs[i].position.x + 50) {
				if (!Obstacle.obs[i].emptySpace.contains(bird.position)) {
					gameOver = true;


				}
			}




				score.update();
				if (bird.position.y < 0 || bird.position.y > 600) {
					gameOver = true;
				}
				if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && gameOver) {
					recreate();
				}

			}
	}



	@Override
	public void dispose() {
		batch.dispose();

	}
	public  void recreate(){
		bird.recreate();
		obstacle.recreate();
		gameOver = false;

	}


}

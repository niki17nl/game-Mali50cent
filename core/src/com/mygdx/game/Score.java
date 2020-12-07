package com.mygdx.game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Score {
     Texture txScore;
    Vector2 pos;
    int score = 0;




    public Score() {
        txScore = new Texture("pp.png" );
        pos = new Vector2(100, 200);

        }

    public void AddScore(int increment) {
        score += increment;
    }

    public void render(SpriteBatch batch) {
        batch.draw(txScore, 100, 200);
    }

    public void update() {

    }



}
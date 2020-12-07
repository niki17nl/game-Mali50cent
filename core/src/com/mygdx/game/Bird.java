package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bird {
    Texture img;
    Vector2 position; //нахождение птицы
    float vy; // вектор движения 50сента вниз
    float gravity; //ускорение движения 50сента вниз
    public Bird(){
        img = new Texture("yiyi2.png");
        position = new Vector2(100, 250);//ее кординаты в начале
        vy = 0;
        gravity = -0.7f;
    }
    public void render(SpriteBatch batch){
        batch.draw(img, position.x, position.y);

    }
     public void update(){ //обновление кадра 60 раз в секунду
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){ // подбрасываем птицу
            vy=9;


        }
      vy += gravity;
      position.y += vy;
     }
     public  void recreate(){
        position = new Vector2(100, 300);
        vy = 0;
     }
}

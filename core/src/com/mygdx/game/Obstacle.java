package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

//Припятствия
public class Obstacle {
    class Wall{
        Vector2 position;
        float speed; //скорость пары труб
        int offset; // смещение
        Rectangle emptySpace; //пустое расстояние между парой труб


        public  Wall (Vector2 position){
            this.position = position;
            speed = 2;
            offset = new Random().nextInt(230); //рандомное смещение
            emptySpace = new Rectangle(position.x , position.y - offset +  300, 50, berweenDistance);
        }
        public void update(){ //матем класса //обновление позиции
            position.x -= speed;

            if(position.x <-100){ //цикл труб
                position.x = 800;
                offset = new Random().nextInt(230);// обновление смещения
            }
            emptySpace.y = position.y - offset +300;
            emptySpace.x = position.x;
        }
    }


   static Wall[] obs;
    Texture txt;
    int berweenDistance; //расстояние между дистанц
    public Obstacle(){
        txt = new Texture("wall4.png");
        obs = new Wall[4];
        berweenDistance = 250;
        int startPos = 450; //начало припятствий
        for( int i=0; i<obs.length; i++ ){
            obs[i] = new Wall(new Vector2(startPos,0));
            startPos += 220;
        }
    }


    public void render(SpriteBatch batch){ //отрисовка нижних труб
        for (int i =0; i<obs.length; i++){
            batch.draw(txt, obs[i].position.x, obs[i].position.y - obs[i].offset);
            batch.draw(txt, obs[i].position.x, obs[i].position.y + berweenDistance+ txt.getHeight() - obs[i].offset); //нижние трубы



        }
    }


    public  void  update(){
        for (int i =0; i<obs.length; i++){
            obs[i].update();
        }
    }
    public  void recreate(){
        int startPos = 450; //начало припятствий
        for( int i=0; i<obs.length; i++ ){
            obs[i] = new Wall(new Vector2(startPos,0));
            startPos += 220;
        }
    }
}

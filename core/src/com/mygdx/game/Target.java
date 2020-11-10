package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

 public class Target {
     private float x;
     private float y;
     private Texture texture;

     Target() {
         this.texture = new Texture("target.png");
          this.y = 500;
    }

     public void placeTarget(float x, float y) {
         this.x = x;
         this.y = y;
    }

     public void render(SpriteBatch batch) {
         batch.draw(texture, x - 256, y - 256, 256, 256, 512, 512, 0.1f, 0.1f, 0, 0, 0, 512, 512, false, false);
    }


     public void dispose() {
         texture.dispose();
    }

     public float getY() {
         return y;
    }

     public float getX() {
         return x;
    }
}

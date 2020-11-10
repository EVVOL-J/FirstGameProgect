package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

import java.util.ArrayList;
import java.util.List;


public class Tank {
    private Texture texture;
    private Texture weaponTexture;
    private float x;
    private float y;
    private float velocity;
    private float angle;
    private float weaponAngle;
    private Bullet bullet;
    private int scale;
    private int width;
    private int height;

    Tank() {
        this.angle = 0.0f;
        this.velocity = 0.05f;
        this.x = 100.0f;
        this.y = 100.0f;
        this.texture = new Texture("tank.png");
        this.weaponTexture = new Texture("weapon.png");
        this.weaponAngle = 0.0f;
        this.bullet = new Bullet();
        this.scale = 2;
        this.width = 40;
        this.height = 40;

    }

    public Bullet getBullet() {
        return bullet;
    }

    public void update(float dt) {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            y += velocity * MathUtils.sinDeg(angle) * dt;
            x += velocity * MathUtils.cosDeg(angle) * dt;
             checkBox();

        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            y -= velocity * MathUtils.sinDeg(angle) * dt * 0.2f;
            x -= velocity * MathUtils.cosDeg(angle) * dt * 0.2f;
             checkBox();

        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            angle += 0.05f * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            angle -= 0.05f * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            weaponAngle += 0.05f * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            weaponAngle -= 0.05f * dt;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && !bullet.getIsActive()) {
            bullet.shoot(x + scale * 20 * MathUtils.cosDeg(angle + weaponAngle), y + scale * 20 * MathUtils.sinDeg(angle + weaponAngle), angle + weaponAngle);
        }
        if (bullet.getIsActive()) {
            bullet.update(dt);
        }

    }

     private void checkBox() {
         if (x < width / 2) x = width / 2;
         if (y < width / 2) y = width / 2;
         if (x > 1280 - 3 * width / 2) x = 1280 - 3 * width / 2;
         if (y > 720 - 3 * width / 2) y = 720 - 3 * width / 2;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y, 20, 20, width, height, scale, scale, angle, 0, 0, 40, 40, false, false);
        batch.draw(weaponTexture, x, y, 20, 20, width, height, scale, scale, weaponAngle + angle, 0, 0, 40, 40, false, false);
        if (bullet.getIsActive()) {
            bullet.render(batch);
        }


    }

    public void dispose() {
        texture.dispose();
        bullet.dispose();
    }
}

package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class Bullet {
    private float x;
    private float y;
    private float vx;
    private float vy;
    private Texture bull;
    private boolean isActive;
    private float speed;


    Bullet() {
        this.bull = new Texture("projectile.png");
        this.speed = 0.2f;
    }

    public void shoot(float x, float y, float angle) {
        this.x = x;
        this.y = y;
        this.vx = speed * MathUtils.cosDeg(angle);
        this.vy = speed * MathUtils.sinDeg(angle);
        this.isActive = true;

    }

    public boolean getIsActive() {
        return isActive;
    }

    public void update(float dt) {
        x += vx * dt;
        y += vy * dt;
        if (x < 0 || x > 1280 || y < 0 || y > 720) {
            isActive = false;
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(bull, x + 12, y + 12, 8, 8, 16, 16, 2, 2, 0, 0, 0, 16, 16, false, false);
    }


    public void dispose() {
        bull.dispose();
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}

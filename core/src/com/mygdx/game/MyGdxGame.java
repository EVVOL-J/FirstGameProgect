package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private Random random;
    private Tank tank;
    private Target target;


    @Override
    public void create() {
        batch = new SpriteBatch();
        random = new Random();
        tank = new Tank();
         target = new Target();
    }

    @Override
    public void render() {
        float dt = Gdx.graphics.getFramesPerSecond();
        update(dt);
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        tank.render(batch);
         target.render(batch);
        batch.end();
    }

    private void update(float dt) {
        tank.update(dt);
         if (tank.getBullet().getIsActive()) {
             if (Math.abs(target.getX() - tank.getBullet().getX() - 25) < 30 && Math.abs(target.getY() - tank.getBullet().getY() - 25) < 30) {
                tank.getBullet().setActive(false);
                 target.placeTarget(random.nextFloat() * 768 + 256, random.nextFloat() * 208 + 256);
            }
        }

    }


    @Override
    public void dispose() {
        batch.dispose();
        tank.dispose();
         target.dispose();
    }
}

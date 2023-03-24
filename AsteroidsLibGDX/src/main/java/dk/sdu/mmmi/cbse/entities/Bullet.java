package dk.sdu.mmmi.cbse.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;

import java.awt.*;

public class Bullet extends SpaceObject {
    private boolean remove;
    private int timer;
    private float life;

    public Bullet (float x, float y, float radians) {
        this.x = x;
        this.y = y;
        this.radians = radians;

        float speed = 300;
        dx = MathUtils.cos(radians) * speed;
        dy = MathUtils.sin(radians) * speed;

        width = height = 2;
        life = 0;
        timer = 1;
    }

    public boolean getRemove() {
        return remove;
    }

    public void update(float dt) {
        x+= dx * dt;
        y+= dy * dt;

        life += dt;
        if (life>timer) {
            remove = true;
        }

        wrap();


    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public void draw (ShapeRenderer sr) {
        sr.setColor(1,1,1,1);
        sr.begin(ShapeType.Filled);
        sr.circle(x-width/2, y-height/2,width/2);
        sr.end();

    }
}

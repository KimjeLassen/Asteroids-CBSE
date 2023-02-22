package dk.sdu.mmmi.cbse.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import dk.sdu.mmmi.cbse.main.Game;

import java.util.Random;

public class Asteroid extends SpaceObject {

    private int type;
    private float speed;
    public static final int Small = 0;
    public static final int Medium = 1;
    public static final int Large = 2;

    public Asteroid(float x, float y, int type) {
        this.x=x;
        this.y=y;
        this.type=type;
        if (type==Small){
            width = 100;
            height = 100;
            speed = 90;
        }
        else if (type==Medium){
            width = 125;
            height = 125;
            speed = 70;
        }
        else if (type==Large){
            width = 140;
            height = 140;
            speed = 50;
        }

        dx += MathUtils.cos(radians) * speed;
        dy += MathUtils.sin(radians) * speed;


        shapex = new float[4];
        shapey = new float[4];

        radians = 3.1415f / 2;
        Random random = new Random();

        rotationSpeed = random.nextInt(5);

    }

    private void setShape() {
        shapex[0] = x + MathUtils.cos(radians) * 5;
        shapey[0] = y + MathUtils.sin(radians) * 5;

        shapex[1] = x + MathUtils.cos(radians - 4 * 3.1415f / 5) * 8;
        shapey[1] = y + MathUtils.sin(radians - 4 * 3.1145f / 5) * 8;

        shapex[2] = x + MathUtils.cos(radians + 3.1415f) * 5;
        shapey[2] = y + MathUtils.sin(radians + 3.1415f) * 5;

        shapex[3] = x + MathUtils.cos(radians + 4 * 3.1415f / 5) * 8;
        shapey[3] = y + MathUtils.sin(radians + 4 * 3.1415f / 5) * 8;
    }

    public void update(float dt) {

        radians -= rotationSpeed * dt;
        // set position
        x += dx * dt;
        y += dy * dt;
        // set shape
        setShape();

        // screen wrap
        wrap();

    }

    public void draw(ShapeRenderer sr) {

        sr.setColor(1, 1, 1, 1);

        sr.begin(ShapeType.Line);

        for (int i = 0, j = shapex.length - 1;
                i < shapex.length;
                j = i++) {

            sr.line(shapex[i], shapey[i], shapex[j], shapey[j]);

        }

        sr.end();

    }

}

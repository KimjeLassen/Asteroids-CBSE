package dk.sdu.mmmi.cbse.gamestates;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import dk.sdu.mmmi.cbse.entities.Asteroid;
import dk.sdu.mmmi.cbse.entities.Bullet;
import dk.sdu.mmmi.cbse.entities.Player;
import dk.sdu.mmmi.cbse.managers.GameKeys;
import dk.sdu.mmmi.cbse.managers.GameStateManager;

import java.util.ArrayList;
import java.util.Random;

public class PlayState extends GameState {
	
	private ShapeRenderer sr;
	
	private Player player;
	private ArrayList<Bullet> bullets;


	private ArrayList<Asteroid> asteroids;
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		
		sr = new ShapeRenderer();
		bullets= new ArrayList<>();
		asteroids = new ArrayList<>();

		player = new Player(bullets);
		Random r = new Random();
		float number = r.nextInt(400);
		asteroids.add(new Asteroid(number,number,Asteroid.Large));
		asteroids.add(new Asteroid(number, number, Asteroid.Small));
		
	}

	public void update(float dt) {
		
		handleInput();
		
		player.update(dt);
		for (Asteroid asteroid : asteroids) {
			asteroid.update(dt);
		}

		for (int i=0;i<bullets.size();i++) {
			bullets.get(i).update(dt);
			if(bullets.get(i).getRemove()) {
				bullets.remove(i);
				i--;
			}
		}
		checkCollision();
	}
	public void checkCollision() {
		for (int i=0; i< bullets.size();i++) {
			Bullet b = bullets.get(i);
			for (int j=0; j<asteroids.size();j++) {
				Asteroid a = asteroids.get(j);
				if(a.contains(b.getX(), b.getY())) {
					bullets.remove(i);
					i--;
					asteroids.remove(j);
					j--;
				}
			}
		}
	}
	
	public void draw() {
		player.draw(sr);
		for (Asteroid asteroid : asteroids) {
			asteroid.draw(sr);
		}
		for (Bullet bullet : bullets) {
			bullet.draw(sr);
		}
	}
	
	public void handleInput() {
		player.setLeft(GameKeys.isDown(GameKeys.LEFT));
		player.setRight(GameKeys.isDown(GameKeys.RIGHT));
		player.setUp(GameKeys.isDown(GameKeys.UP));
		if (GameKeys.isPressed(GameKeys.SPACE)) {
			player.shoot();
		}
	}
	
	public void dispose() {}
	
}










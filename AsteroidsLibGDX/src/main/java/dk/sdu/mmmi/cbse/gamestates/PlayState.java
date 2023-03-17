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
	private Asteroid asteroid;
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		
		sr = new ShapeRenderer();
		bullets= new ArrayList<Bullet>();

		player = new Player(bullets);
		Random r = new Random();
		float number = r.nextInt(400);
		asteroid = new Asteroid(number,number,Asteroid.Large);
		
	}
	
	public void update(float dt) {
		
		handleInput();
		
		player.update(dt);
		asteroid.update(dt);
		for (int i=0;i<bullets.size();i++) {
			bullets.get(i).update(dt);
			if(bullets.get(i).getRemove()) {
				bullets.remove(i);
				i--;
			}
		}

		
	}
	
	public void draw() {
		player.draw(sr);
		asteroid.draw(sr);
		for (int i=0;i<bullets.size();i++) {
			bullets.get(i).draw(sr);
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










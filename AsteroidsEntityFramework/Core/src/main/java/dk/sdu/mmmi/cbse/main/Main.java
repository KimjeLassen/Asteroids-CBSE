package dk.sdu.mmmi.cbse.main;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		Lwjgl3ApplicationConfiguration cfg =
			new Lwjgl3ApplicationConfiguration();
		cfg.setTitle("Asteroids");
		int width = 500;
		int height = 400;
		cfg.setWindowSizeLimits(width, height, width, height);
		cfg.setWindowedMode(width, height);
		cfg.setResizable(false);

		AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext();
		application.scan("dk.sdu.mmmi.cbse.main");
		application.refresh();

		new Lwjgl3Application((ApplicationListener) application.getBean("game"), cfg);
		
	}
	
}

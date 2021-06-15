package SourceCodeGame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Spawner {
	
	
	
	public  int timer = 0;
	public List<RectObj> rectangles = new ArrayList<RectObj>();
	public List<explosionEffect> particulas = new ArrayList<explosionEffect>();
	
	public void update() {
		
		
		
		for(int i =0; i < rectangles.size(); i++ ) {
			
			RectObj current = rectangles.get(i);
			
			rectangles.get(i).update();
			
			
			if(current.x < Game.WIDTH) {
				
				rectangles.remove(current);
				Game.contador--;
				
			}
			
			

			if(Game.clicked) {
				
				if(Game.mx >= current.x && Game.mx < current.x + current.width ) {
		
					rectangles.remove(current);
					Game.pontuaçao++;
					Game.clicked = false;

					if(Game.my <= current.y && Game.my > current.y + current.height ) {
						rectangles.remove(current);
						Game.pontuaçao++;
						Game.clicked = false;
						
					}

					
					
				}

				
			}
			

			
		}
		
		
		timer++;
		if(timer % 60 == 0) {
			
			rectangles.add(new RectObj(0,new Random().nextInt(480-40), 40, 40));
			
		}


		
		
	}
	public void render(Graphics g) {
		
		for(int i = 0; i <rectangles.size(); i++ ) {
			
			RectObj current = rectangles.get(i);
			Graphics2D g2 = (Graphics2D) g;
			g2.rotate(Math.toRadians(current.rotation),current.x +current.width/2,current.y+current.width/2);
			g2.setColor(current.color);
			g2.fillRect(current.x, current.y, current.width, current.height);
			g2.rotate(Math.toRadians(-current.rotation),current.x+current.width/2,current.y+current.width/2);
			
		}
		

		
	}
	
	

}

package SourceCodeGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class explosionEffect extends Rectangle {
	
	public int rotation = 0; 
	public int speed = 0; 
	
	
	public double xa,ya;
	public double dx,dy;
	
	public Color color = Color.yellow;

	public explosionEffect(int x,int y, int width,int height,Color colo) {
		
		super(x,y,width,height);
		
		this.color =  color;
		
		ya = y;
		xa = x;
		
		dx = new Random().nextGaussian();
		dy = new Random().nextGaussian();
		speed = 8;
		
	}
	
	public void update() {
		
		
		xa+=dx*speed;
		ya+=dy*speed;
		

		
	}
	
	public void render(Graphics g) {
		
		g.setColor(this.color);
g.fillRect((int)xa,(int)ya, width, height);

		

		
	}

}
package SourceCodeGame;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;

public class RectObj extends Rectangle {
	
	public int rotation = 0; 
	public int speed = 0; 
	
	public Color color = Color.gray;

	public RectObj(int x,int y, int width,int height) {
		
		super(x,y,width,height);
		
		speed = new Random(). nextInt(6-4)+12;
		
	}
	
	public void update() {
		
		
		x+=speed;
		speed++;
		rotation++;
		if(rotation >=  360) {
			
			rotation = 0;
			
			
		}
		
	}

}

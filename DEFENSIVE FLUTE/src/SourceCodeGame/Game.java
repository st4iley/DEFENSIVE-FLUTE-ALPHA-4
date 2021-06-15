/* _______________________
 * |                     |
 * |                     |
   | defensive flute code|
 * |                     |
 * |                     |
 * |_____________________|
 * */

package SourceCodeGame;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Game extends Canvas implements Runnable,MouseListener {

	private Image fundo;

	

	
	public Spawner spawner;
	
	public static int mx,my;
	
	
	//variavel quando o mouse for clicado ou soltado 
	public static boolean clicked = false;
	//pontuação
	public static int pontuaçao = 0;
	//vida
	public static int contador = 100;
	//largura da janela
	public int ScreenLargura = 690, ScreenAltura = 490;
	//variavel se o player esta morto ou não
	public boolean gameover = false;
	
	public static String TitleNameGame = "DEFENSE FLUTE - WARNING: do not put in full screen";
	
	//construtor do jogo
	public Game() {
		
		Dimension  dimension = new Dimension(ScreenLargura,ScreenAltura);		
		this.setPreferredSize(dimension);
		this.addMouseListener(this);
		ImageIcon fundoI = new ImageIcon("resources_sprites//back.gif");
		 fundo  = fundoI.getImage();
		 spawner = new Spawner();
				
	}
	
	//onde o computador começa a ler o codigo
	public static void main(String[] args) {
					
		System.out.print("you are play DEFENSIVE FLUTE\n");
		
		Game game = new Game();
		JFrame jf = new JFrame (TitleNameGame);
		jf.add(game);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		jf.pack();
		jf.setVisible(true);
		
		new Thread(game).start(); 
		new Game();
				
	}
	
	
	//ao atualizar frames
	public void update() {
						
		spawner.update();
		contador--;
		if(contador <=0) {
			
			System.out.println("você morreu");
			gameover = true;
			contador = 100;			
		}
		
		if(gameover = false) {
			
		}
		}
	
	//ao renderizar frame
	public void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			
			this.createBufferStrategy(3);
			return;
					
		}
		Graphics g = bs.getDrawGraphics();



		//se o player nao tiver morto
		if(gameover == false) {
			g.drawImage(fundo, 0, 0,null );
			g.setColor(Color.BLUE);
			bs.show();
			
			
			g.setFont(new Font("Arial",Font.BOLD,23));
			
			g.setColor(Color.GREEN);
			g.fillRect(ScreenLargura/4-contador + 200,20, contador*4 , 10);
			g.setColor(Color.WHITE);
			g.drawRect(ScreenLargura/4-100 + 200,20, 400, 10);
			
			spawner.render(g);
			
		
			
			//se o player estiver morto
		}else {
			
			g.setColor(Color.white);
			//g.setFont(new Font("Arial",Font.BOLD,30));
			//g.draw
			
			
		}
		
		bs.show();	

	}
		
	
	@Override
	public void run() {
	while(true) {
		
		update();
		render();
		
		try {
			
			
			
			Thread.sleep(1008/60);
			
		} catch (InterruptedException e ) {
			
			
			e.printStackTrace();
			
		}
		
		
	}
		
	}

	//click do mouse
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		
	}

	//quando o mouse for apertado
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("clicked");
		clicked = true ;
		mx = e.getX();
		my = e.getY();
	}

	
	//quando soltar o botão mouse  
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stubs
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {

	
	public double x,y;
	public int width ;
	public int height;
	
	public double dx , dy;
	public double speed = 1.7;
	
	
	public Ball(int x , int y) {
		this.x = x;
		this.y = y;
		this.width = 4;
		this.height = 4;
		
		int angle = new Random().nextInt(120 - 45) + 46 ;// angulo 
		
		this.dx = Math.cos(Math.toRadians(angle));// numero aleatorios 
		this.dy = Math.sin(Math.toRadians(angle));
	}
	
	public void tick() {
		
		if(x+(dx*speed) + width >= Game.WIDTH) {
			dx*=-1;
		}else if (x+(dx*speed) < 0) {
			dx*=-1;
		}
		
		if(y >= Game.HEIGHT) {
			//ponto do inimigo 
			System.out.println("ponto do inimigo");
			new Game();
			return;
		}else if (y < 0) {
			//ponto do johgador 
			System.out.println("ponto nosso!!");
			new Game();
			return;
		}
		
		
		x+= dx*speed;
		y+= dy*speed;		
		
		Rectangle bounds = new Rectangle((int)(x+(dx*speed)),(int)(y+(dy*speed)),width,height);// rectangle classe jave permite testar colisao
		Rectangle boundsPlayer = new Rectangle(Game.player.x,Game.player.y,Game.player.width,Game.player.height);
		Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x,(int)Game.enemy.y,Game.enemy.width,Game.enemy.height);
		
		// colisao com players
		if (bounds.intersects(boundsPlayer)) {
			int angle = new Random().nextInt(120 - 45) + 46 ;// angulo 
			this.dx = Math.cos(Math.toRadians(angle));// numero aleatorios 
			this.dy = Math.sin(Math.toRadians(angle));
			if(dy > 0)
				dy*=-1;
		}else if (bounds.intersects(boundsEnemy)) {
			int angle = new Random().nextInt(120 - 45) + 46 ;// angulo 
			this.dx = Math.cos(Math.toRadians(angle));// numero aleatorios 
			this.dy = Math.sin(Math.toRadians(angle));
			if(dy < 0)
				dy*=-1;
		}
	
	
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);// cor 
		g.fillRect((int)x, (int)y, width, height);// tamanho personagem
		
	}
	
	
	
	
}

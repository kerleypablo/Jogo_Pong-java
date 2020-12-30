package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy {

	
	public double x,y;
	public int width ;
	public int height;
	
	
	
	public Enemy(int x , int y) {
		this.x = x;
		this.y = y;
		this.width = 40;
		this.height = 5;
	}
	
	public void tick() {
		x+= (Game.ball.x - x - 6)* 0.07;// posição atual + posição da bola - posição x 
		
		
		if (x + width > Game.WIDTH) {// colisao final tela direita
			x = Game.WIDTH - width;
		}
		else if (x < 0) {// colisao lado esquerdo da tela 
			x = 0;
		}
		
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);// cor 
		g.fillRect((int)x, (int)y, width, height);// tamanho personagem
		
	}
	
}

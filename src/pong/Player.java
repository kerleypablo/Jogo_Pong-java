package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Player {

	public boolean right , left;
	public int x, y;
	public int width ;
	public int height;
	
	public Player(int x , int y) {
		this.x = x;
		this.y = y;	
		this.width = 40;
		this.height = 5;
	}
	
	
	public void tick() {// logica do jogo 
		if(right)
		{
			x++;
		}
		else if (left) {
			x--;
		}
		
		if (x + width > Game.WIDTH) {// colisao final tela direita
			x = Game.WIDTH - width;
		}
		else if (x < 0) {// colisao lado esquerdo da tela 
			x = 0;
		}
		
	}
	
	
	
	public void render(Graphics g) { // todo o grafico do player Graphics ja é uma classe jave exixtente 
	g.setColor(Color.BLUE);// cor 
	g.fillRect(x, y, width, height);// tamanho personagem
		
		
	}
	
	
	
	
	
}

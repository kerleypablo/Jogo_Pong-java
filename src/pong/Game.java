package pong;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends  Canvas implements Runnable,KeyListener {//runnable para rodar , keylistener para utilizar teclado

	
	private static final long serialVersionUID = 1L;
	// constantes 
	public static int WIDTH = 160;
	public static int HEIGHT = 120;
	public static int SCALE = 3;
	
	public BufferedImage layer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_BGR);// cria uma layer pra nao renderizar direto na frame
	
	public static Player player;
	public static Enemy enemy;
	public static Ball ball;
	
	
	public Game() {
		this.setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));// construtor com dimençao 
		this.addKeyListener(this);// propria classe adicione o keylistener
		player = new Player(100,HEIGHT-5); 	
		enemy = new Enemy(100,0);
		ball = new Ball(100,HEIGHT/2 - 1);
		
	}
	
	
	public static void main(String[] args) {
		Game game = new Game(); 
		JFrame frame = new JFrame("pong"); // JFrame gera uma janela 
		frame.setResizable(false);// falso nao redimensiona a janela
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// para que o jogo feche quando fechar a janela
		frame.add(game); // adicionar o componente game 
		frame.pack();
		frame.setLocationRelativeTo(null);// janela ficar no centro da tela
		frame.setVisible(true);// aparecer a janela 
		
		new Thread(game).start();
		
	}
	
	
	public void tick() {
		player.tick();
		enemy.tick();
		ball.tick();
		
		
		
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();// faz a rendereizção 
		if (bs == null ) {// inicio buffery nao existe ai ele inicializa
				this.createBufferStrategy(3);
		return;
		}
		Graphics g = layer.getGraphics();
		g.setColor(Color.black);// limpar a rendereização
		g.fillRect(0, 0, WIDTH, HEIGHT);// limpar renderezação
		player.render(g);
		enemy.render(g);
		ball.render(g);
		
		g = bs.getDrawGraphics();// desenhar 
		g.drawImage(layer, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);// renderizar a layer
		
		bs.show();// aparecer o tudo renderizado 
	}
	
	
	public void run() {
		while(true) {
			tick();
			render();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}


	@Override
	public void keyPressed(KeyEvent e) { // quando prescionar
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = true;

		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) { // quando soltar 
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = false;
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = false;

		}
		
	}
		
	


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

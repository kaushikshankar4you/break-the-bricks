import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * Game Class
 *
 * @author kaushik shankar
 */

public class Game extends JPanel {
	
	final static int frameX = 500, frameY = 600;
	Player player;
	Ball ball;
	Brick[] brick;
	Brick reference = new Brick(0,0,frameX, frameY);
	int deadBrick = 0;
	
	
	public Game() {
		player = new Player(frameX/3, frameY-100, frameX, frameY);
		ball = new Ball(frameX/2, (frameY/2)+(frameY/3-10), frameX, frameY);
		brick = new Brick[40];
		reference.state = false;
		generate();
		
		addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
				player.keyReleased(e);
			}
			public void keyPressed(KeyEvent e) {
				player.keyPressed(e);
			}
		});
		setFocusable(true);
	}
	
	public void generate()
	{
		int x = reference.width-10;
		int y = reference.height;
		int row = 1;
		for (int i=0; i<brick.length; i++) {
			if (i>7 && i%8==0)
				row++;
			if (i<8) {
				brick[i] = new Brick(x, y, frameX, frameY);
				x+=brick[i].width;
			}
			else if (i==8) {
				x = reference.width-10;
				y = reference.height*row;
				brick[i] = new Brick(x, y, frameX, frameY);
				x+=brick[i].width;
			}
			else if (i<16) {
				brick[i] = new Brick(x, y, frameX, frameY);
				x+=brick[i].width;
			}
			else if (i==16) {
				x = reference.width-10;
				y = reference.height*row;
				brick[i] = new Brick(x, y, frameX, frameY);
				x+=brick[i].width;
			}
			else if (i<24) {
				brick[i] = new Brick(x, y, frameX, frameY);
				x+=brick[i].width;
			}
			else if (i==24) {
				x = reference.width-10;
				y = reference.height*row;
				brick[i] = new Brick(x, y, frameX, frameY);
				x+=brick[i].width;
			}
			else if (i<32) {
				brick[i] = new Brick(x, y, frameX, frameY);
				x+=brick[i].width;
			}
			else if (i==32) {
				x = reference.width-10;
				y = reference.height*row;
				brick[i] = new Brick(x, y, frameX, frameY);
				x+=brick[i].width;
			}
			else if (i<40) {
				brick[i] = new Brick(x, y, frameX, frameY);
				x+=brick[i].width;
			}
		}
	}
	
	public void collision() {
		for (int i=0; i<brick.length; i++) {
			if (brick[i].state && ball.getBounds().intersects(brick[i].getBounds())) { // if brick is alive and ball intersects, disapears
				brick[i].state = false;
				ball.velY=-ball.velY;
				deadBrick++;
				break;
			}
		}
		if (ball.getBounds().intersects(player.getBounds())) {
			ball.velY=-ball.velY;
		}
	}
	
	public void update() {
		player.update();
		ball.update();
		collision();
		for (int i=0; i<brick.length; i++)
			brick[i].update();
		checkLose(); /////////////////
	}
	
	public void checkLose() {          ////////// CHANGE AFTER
		if (ball.y>=frameY-60) {
			ball.state=false;
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// Sets Background
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0,0,frameX,frameY);
		g2d.setColor(Color.red);
		g2d.fillRect(0,0,frameX/100,frameY);
		g2d.fillRect(frameX-20,0,frameX/100,frameY);
		
		// Coordinates
		g2d.setColor(Color.WHITE);
		g2d.drawString(ball.x + ", " + ball.y, 420, 540);
		
		for (int i=0; i<brick.length; i++) {
			brick[i].draw(g2d);
		}
		player.draw(g2d);
		ball.draw(g2d);
		
		if (deadBrick==40) {
			g2d.drawString("YOU WON!!", frameX/2, frameY/2);
		}
		if (ball.state==false) {
			g2d.drawString("You Lose. Try again!!", frameX/2, frameY/2);
		}
		
	}
	
	public static void main (String args[]) throws InterruptedException {
		JFrame frame = new JFrame("Kaushik's Break the Bricks");
		Game game = new Game();
		frame.add(game);
		frame.setSize(frameX, frameY);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			game.update();
			game.repaint();
			Thread.sleep(15);
		}
	}
}

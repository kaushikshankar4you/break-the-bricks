import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 *
 * Player Class
 *
 * @author kaushik shankar
 */

public class Player {
	
	public Player(int x, int y, int frameX, int frameY) {
		this.x = x;
		this.y = y;
		this.frameX = frameX;
		this.frameY = frameY;
	}
	
	int frameX, frameY;
	int x, y;
	int vel = 5, velX = 0;
	final int width = 70, height = 15;
	
	public void update() {
		move();
	}
	
	public void move() {
		if (x+velX >= frameX-(width+19))
			velX=0;
		else if (x+velX <= 5)
			velX=0;
		x+=velX;
	}
	
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A)
			velX = 0;
		if (e.getKeyCode() == KeyEvent.VK_D)
			velX = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A)
			velX = -vel;
		if (e.getKeyCode() == KeyEvent.VK_D)
			velX = vel;
	}
	
	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.WHITE);
		g2d.fillRect(x,y,width,height);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,width,height);
	}
}

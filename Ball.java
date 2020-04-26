import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * Ball Class
 *
 * @author kaushik shankar
 */

public class Ball {
	
	public Ball(int x, int y, int frameX, int frameY) {
		this.x = x;
		this.y = y;
		this.frameX = frameX;
		this.frameY = frameY;
		state = true;
	}
	
	int x, y;
	int vel = 4;
	int velX = -vel, velY = -vel;
	final int radius = 10;
	int frameX, frameY;
	int lives = 3;
	boolean state;
	
	public void update() {
		if (state) {
			move();
			boundry();
		}
	}
	
	public void move() {
		x+=velX;
		y+=velY;
	}
	
	public void boundry() {
		if (x+velX >= frameX-(radius+15))
			velX=-velX;
		else if (x+velX <= 0)
			velX=-velX;
		if (y+velY > frameY-(radius+40))
			velY=-velY;
		else if (y+velY <= 0)
			velY=-velY;
	}
	
	public void draw(Graphics2D g2d) {
		if (state) {
			g2d.setColor(Color.WHITE);
			g2d.fillOval(x, y, radius, radius);
		}
	}
	
	
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,radius, radius);
	}
}

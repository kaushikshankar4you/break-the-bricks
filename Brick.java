import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * Brick Class
 *
 * @author kaushik shankar
 */


public class Brick {
	
	public Brick(int x, int y, int frameX, int frameY) {
		this.x=x;
		this.y=y;
		this.frameX = frameX;
		this.frameY = frameY;
		colNum = (int)(Math.random()*10);
		state = true;
	}
	
	final int height = 30, width = 50;
	int x, y;
	final int frameX, frameY;
	private int colNum = 0;
	boolean state;
	
	public void update() {
		
	}
	
	public void draw(Graphics2D g2d) {
		if (state) {
			if (colNum==6) colNum = 0;
			if (colNum==0) g2d.setColor(Color.RED);
			else if (colNum==1) g2d.setColor(Color.BLUE);
			else if (colNum==2) g2d.setColor(Color.CYAN);
			else if (colNum==3) g2d.setColor(Color.GRAY);
			else if (colNum==4) g2d.setColor(Color.YELLOW);
			else if (colNum==5) g2d.setColor(Color.MAGENTA);
			else if (colNum==6) g2d.setColor(Color.WHITE);
			else if (colNum==7) g2d.setColor(Color.PINK);
			else if (colNum==8) g2d.setColor(Color.GREEN);
			else if (colNum==9) g2d.setColor(Color.ORANGE);
			
			g2d.fillRect(x,y,width,height);
			g2d.setColor(Color.black);
			g2d.drawRect(x,y,width,height);
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,width,height);
	}
}

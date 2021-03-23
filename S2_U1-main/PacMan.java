import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PacMan extends JPanel
{
     int x, y, score, size; 
     
    public PacMan(int xx, int yy)
    {
        x = xx;
        y = yy; 
        size = 30; //controls the size of pacman
        score = 0;
    }

    public int getX()
    {
      return x;    
    }
    
    public int getY()
    {
      return y;    
    }
    
    public int getPacSize() 
    {
        return size;
    }
    
    public int getScore()
    {
      return score;    
    }
    
    public void addScore(int points)
   {
      score = score + points;   
    } 
    
    public void movePac(int xdir, int ydir)
    {
       x = x + xdir;
       y = y + ydir;
    }
    
    public void setPac(int xx, int yy)
    {
        x = xx;
        y = yy;
    }
    
    public void draw (Graphics g) {
         g.setColor(Color.yellow);
         g.fillOval(x, y, size, size);
    }
}
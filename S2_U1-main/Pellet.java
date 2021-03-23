import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Pellet extends JPanel
{
     int x, y, pacSize, size, powerSize;
     boolean eaten;
     
    public Pellet(int xx, int yy, int ppacSize)
    {
      x = xx;
      y = yy;
      pacSize = ppacSize;
      size = 10;
      powerSize = 15;
      eaten = false;
    }
    
    
    public int getX()
    {
        return x;
    }
    
    public int getPelletSize() 
    {
        return size;
    }
    
    public int getY()
    {
        return y;
    }
    
    public boolean isPelletBeingEaten(int pacX, int pacY)
    {
        if (pacX >= x-pacSize && pacX <= x + size && pacY <= y + size && pacY >= y - pacSize) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isPowerPelletBeingEaten(int pacX, int pacY)
    {
        if (pacX >= x-pacSize && pacX <= x + powerSize && pacY <= y + powerSize && pacY >= y - pacSize) {
            return true;
        } else {
            return false;
        }
    }
    
    public void drawPellet (Graphics g) {
         g.setColor(Color.white);
         g.fillOval(x, y, size, size);
    }
    
    public void drawPowerPellet (Graphics g) {
         g.setColor(Color.white);
         g.fillOval(x, y, powerSize, powerSize);
    }
    
    public boolean isEaten()
    {
        return eaten;
    }
    
    public void beenEaten()
    {
       eaten = true;
    }
}

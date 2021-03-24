/**
 * @author (Sawyer Theis)
 * @version (v1.0)
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Ghost extends JPanel
{
     int x, y, pacSize, size, color, xdir, ydir, randomdirection, count;
     boolean canEat, didEat;
     
    public Ghost(int xx, int yy, int ppacSize, int ccolor)
    {
      x = xx;
      y = yy;
      size = 20;
      pacSize = ppacSize;
      color = ccolor;
      canEat = false;
      didEat = false;
      count = 0;
    }
    
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public boolean getCanEat()
     {
       return canEat;
      }
      
    public void setCanEat(boolean ce)
    {
        canEat = ce;
    }
    
    public boolean getDidEat()
    {
        return didEat;
    }
    
    public void setDidEat(boolean de)
    {
        didEat = de;
    }
    
    public int getGhostSize()
    {
        return size;
    }
    
    public void moveGhost()
    {
       x = x + xdir;
       y = y + ydir;
    }
    
    public void moveGhostSlow()
    {
       count++;
       if (count == 1) {
       x = x + xdir;
       y = y + ydir;
       } else count = 0;
    }
    
    public void setGhost(int xx, int yy) {
        x = xx;
        y = yy;
    }
    
    public void setDirectionX(int xxdir) {
        xdir = xxdir;
    }
    
    public void setDirectionY(int yydir) {
        xdir = yydir;
    }
    
    public void drawGhost (Graphics g) {
         if (color == 1) g.setColor(Color.red);
         if (color == 2) g.setColor(Color.orange);
         if (color == 3) g.setColor(Color.green);
         if (color == 4) g.setColor(Color.pink);
         g.fillRect(x, y, size, size);
    }
    
    public void drawScaredGhost (Graphics g) {
         g.fillRect(x, y, size, size);
    }
    
    public boolean isGhostHitting(int pacX, int pacY)
    {
        if (pacX >= x-pacSize && pacX <= x + size && pacY <= y + size && pacY >= y - pacSize && didEat == false) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isGhostEatable(int pacX, int pacY)
    {
        if (pacX >= x-pacSize && pacX <= x + size && pacY <= y + size && pacY >= y - pacSize && canEat == true && didEat == false) {
            return true;
        } else {
            return false;
        }
    }
    
     public void chasePacPerfect(PacMan pac)
    {
        xdir = 0; 
        ydir = 0; 
                
         if(Math.abs(pac.getX()-x)-Math.abs(pac.getY()-y) > 0)
        {
            if(x < pac.getX())
                 xdir = 1; 
             else xdir = -1;    
        } else
        {
          if(y < pac.getY())
                 ydir = 1;  
             else ydir = -1;  
        }
     }
     
    public void chasePac(PacMan pac)
    {
        xdir = 0; 
        ydir = 0; 
        
        randomdirection = (int)(Math.random()  * 2 + 1);
                
         if(randomdirection == 1)
        {
            if(x < pac.getX())
                 xdir = 1; 
             else xdir = -1;    
        } 
        if (randomdirection == 2)
        {
          if(y < pac.getY())
                 ydir = 1;  
             else ydir = -1;  
        }
     }
     
      public void runFromPac(PacMan pac)
    {
        xdir = 0; 
        ydir = 0; 
        
        randomdirection = (int)(Math.random()  * 2 + 1);
                
         if(randomdirection == 1)
        {
            if(x > pac.getX())
                 xdir = 1; 
             else xdir = -1;    
        }
        if (randomdirection == 2)
        {
          if(y > pac.getY())
                 ydir = 1;  
             else ydir = -1;  
        }
     }
     
    public void changeDirectionRandom()
    {
        xdir = 0; 
        ydir = 0; 
        
        randomdirection = (int)(Math.random()  * 4 + 1);
        
        if(randomdirection == 1)
        {
            xdir = 1;               //Ghost will move right
        }
        
         if(randomdirection == 2)
        {
            xdir = -1;               //Ghost will move left
        }
         
        if(randomdirection == 3)
        {
            ydir = 1;               //Ghost will move down
        }
        
         if(randomdirection == 4)
        {
            ydir = -1;               //Ghost will move up
        }
     }
}
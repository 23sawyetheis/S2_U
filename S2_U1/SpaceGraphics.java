import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SpaceGraphics  extends JPanel
{   
     int aamx,aamy; 
     boolean shottakenn;
     Alien aa1[];
     SpaceShip pplayer;
     Missile missile[], fastMissile[];
     int index, totalShots, totalFastShots;
    
     public SpaceGraphics(SpaceShip player, Missile[] mmissile, Missile[] ffastMissile, boolean shottaken,Alien[] a1) 
    {
      setBackground(Color.red);
      shottakenn = shottaken;
      
      aa1 = a1;
      pplayer = player;
      missile = mmissile;
      fastMissile = ffastMissile;
    }
   
    public void updatePlayerLocation(SpaceShip player)
    {
      pplayer = player;
    }
    
    public void updateMissileLocation(Missile[] mmissile, Missile[] ffastMissile,int ttotalShots,int ttotalFastShots)
    {
        missile = mmissile;
        fastMissile = ffastMissile;
    }
    
    public void updateAlien(Alien[] a1)
    {
         aa1 = a1;
    }
    
    public void updateAlienMissile(int amx, int amy)
    {
        aamx = amx;
        aamy = amy;
    }
    
    public void paint (Graphics g)         
    {
        super.paint(g);                     
        
       g.setColor(Color.black);
       g.fillRect(pplayer.getX(),pplayer.getY(),20,20);       //player
       
       g.setFont(new Font("Arial", Font.BOLD, 20));
       g.drawString("Score:" + pplayer.getScore(), 10,500);
       
       for (index = 0; index < aa1.length; index++) {
           if(aa1[index].getDestroyed() == false)  { 
            g.setColor(Color.blue);
            g.fillRect(aa1[index].getX(),aa1[index].getY(),20,20);
           }
            else
            {
                g.setColor(Color.orange);
                g.fillOval(aa1[index].getX()-10,aa1[index].getY()-10,40,40);
            }
        }
          
       g.setColor(Color.blue);
         
       for (index = 0; index < totalShots taken)
          g.setColor(Color.yellow);
          g.fillRect(missile.getX(),mm1.getY(),10,10);
     }           
}

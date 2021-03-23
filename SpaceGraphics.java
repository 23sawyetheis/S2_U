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
     boolean shotTaken, fastShotTaken, endgame;
    
     public SpaceGraphics(SpaceShip player, Missile[] mmissile, Missile[] ffastMissile, boolean sshotTaken,boolean ffastShotTaken, Alien[] a1) 
    {
      setBackground(Color.black);
      
      aa1 = a1;
      pplayer = player;
      missile = mmissile;
      fastMissile = ffastMissile;
      shotTaken = sshotTaken;
      fastShotTaken = ffastShotTaken;
    }
   
    public void updatePlayerLocation(SpaceShip player, boolean eendgame)
    {
      pplayer = player;
      endgame = eendgame;
    }
    
    public void updateMissileLocation(Missile[] mmissile, Missile[] ffastMissile,int ttotalShots,int ttotalFastShots, boolean sshotTaken, boolean ffastShotTaken)
    {
        missile = mmissile;
        fastMissile = ffastMissile;
        totalShots = ttotalShots;
        totalFastShots = ttotalFastShots;
        shotTaken = sshotTaken;
        fastShotTaken = ffastShotTaken;
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
        
       g.setColor(Color.white);
       g.fillRect(pplayer.getX(),pplayer.getY(),20,20);       //player
       
       g.setFont(new Font("Arial", Font.BOLD, 20));
       g.drawString("Score:" + pplayer.getScore(), 10,500);
       
       for (index = 0; index < aa1.length; index++) {
           if(aa1[index].isDestroyed() == false)  { 
            g.setColor(Color.green);
            g.fillRect(aa1[index].getX(),aa1[index].getY(),20,20);
           }
            else
            {
                g.setColor(Color.orange);
                g.fillOval(aa1[index].getX()-10,aa1[index].getY()-10,40,40);
            }
        }
                   
       if (shotTaken == true) {
           for (index = 0; index < totalShots; index++) {
               g.setColor(Color.yellow);
               g.fillRect(missile[index].getX(),missile[index].getY(),10,10);
            }
       }
       
       if (fastShotTaken == true) {
           for (index = 0; index < totalFastShots; index++) {
               g.setColor(Color.yellow);
               g.fillRect(fastMissile[index].getX(),fastMissile[index].getY(),10,10);
            }
       }
       
       if(endgame == true)
       {
          g.setColor(Color.red);
          g.setFont(new Font("Arial", Font.BOLD, 60));
          g.drawString("Game Over",175,300);
        }
     }           
}

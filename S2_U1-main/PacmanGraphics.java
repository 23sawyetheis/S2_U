/**
 * @author (Sawyer Theis)
 * @version (v1.0)
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PacmanGraphics  extends JPanel
{   
     boolean eendgame;
     Pellet[] ppellet, powerPellet;
     Ghost[] gghost;
     PacMan pplayer;
     int index, eatGhostCounter;
   
    public PacmanGraphics(PacMan player, Ghost[] ghost, boolean endgame, Pellet[] pellet, Pellet[] ppowerPellet)               
    {
      setBackground(Color.black);
      
      pplayer = player;
      gghost = ghost;
      ppellet = pellet;
      eendgame = endgame;
      powerPellet = ppowerPellet;
    }
   
    public void updateObjects(PacMan player, Ghost[] ghost, Pellet[] pellet, Pellet[] ppowerPellet, int eeatGhostCounter)
    {
      pplayer = player;
      gghost = ghost;
      powerPellet = ppowerPellet;
      ppellet = pellet;
      eatGhostCounter = eeatGhostCounter;
    }
    
    public void hitGhost(boolean endgame)
    {
        eendgame = endgame;
    }
    
    public void paint (Graphics g)         
    {
       super.paint(g);                     
       
       pplayer.draw(g);
       
       g.setColor(Color.white);
       
       for (index = 0; index < ppellet.length; index++) {
            if(ppellet[index].isEaten() == false) {
                ppellet[index].drawPellet(g);
            }
       }
       
       for (index = 0; index < powerPellet.length; index++) {
            if(powerPellet[index].isEaten() == false) {
                powerPellet[index].drawPowerPellet(g);
            }
       }
       
       for (index = 0; index < gghost.length; index++) {
           if(gghost[index].getDidEat() == false)
           {
            if(gghost[index].getCanEat() == false)
            {
               gghost[index].drawGhost(g);
            }
            if(gghost[index].getCanEat() == true)
            {
               if( eatGhostCounter > 500 && eatGhostCounter % 50 > 25) // finds the remandier after 500 and see if it is less than 25
                   g.setColor(Color.white);
               else g.setColor(Color.blue);
              
               gghost[index].drawScaredGhost(g);
            }            
           }
       }
       
       g.setColor(Color.white);
       g.setFont(new Font("Arial", Font.BOLD, 20));
       g.drawString("Score: " + pplayer.getScore(), 10,500);
       
       if(eendgame == true)
       {
          g.setColor(Color.red);
          g.setFont(new Font("Arial", Font.BOLD, 60));
          g.drawString("Game Over",200,300);
        }
       
     }           
}

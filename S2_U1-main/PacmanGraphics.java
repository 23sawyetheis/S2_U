import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PacmanGraphics  extends JPanel
{   
     boolean eendgame;
     Pellet[] ppellet;
     Ghost[] gghost;
     PacMan pplayer;
     int index;
   
    public PacmanGraphics(PacMan player, Ghost[] ghost, boolean endgame, Pellet[] pellet)               
    {
      setBackground(Color.black);
      
      pplayer = player;
      gghost = ghost;
      ppellet = pellet;
      eendgame = endgame;
      
    }
   
    public void updatePlayerLocation(PacMan player)
    {
      pplayer = player;
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
       
       for (index = 0; index < gghost.length; index++) {
           gghost[index].drawGhost(g);
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

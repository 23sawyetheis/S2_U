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
       
       g.setColor(Color.yellow); 
       g.fillOval(pplayer.getX(),pplayer.getY(),pplayer.getSize(),pplayer.getSize()); 
       
       g.setColor(Color.white);
       
       for (index = 0; index < ppellet.length; index ++) {
            if(ppellet[index].isEaten() == false) {
                g.fillOval(ppellet[index].getX(),ppellet[index].getY(),ppellet[index].getSize(),ppellet[index].getSize());
            }
       }
       
       g.setColor(Color.green);
       g.fillRect(gghost[0].getX(),gghost[0].getY(),gghost[0].getSize(),gghost[0].getSize());
              
       g.setColor(Color.blue);
       g.fillRect(gghost[1].getX(),gghost[1].getY(),gghost[1].getSize(),gghost[1].getSize());
       
       g.setColor(Color.red);
       g.fillRect(gghost[2].getX(),gghost[2].getY(),gghost[2].getSize(),gghost[2].getSize());
       
       g.setColor(Color.pink);
       g.fillRect(gghost[3].getX(),gghost[3].getY(),gghost[3].getSize(),gghost[3].getSize());

       g.setColor(Color.white);
       g.setFont(new Font("Arial", Font.BOLD, 20));
       g.drawString("Score:" + pplayer.getScore(), 10,500);
       
       if(eendgame == true)
       {
          g.setColor(Color.red);
          g.setFont(new Font("Arial", Font.BOLD, 60));
          g.drawString("Game Over",200,300);
        }
       
     }           
}

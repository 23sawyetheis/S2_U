/**
 * @author (Sawyer Theis)
 * @version (v1.0)
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PacmanGame  implements ActionListener, KeyListener
{
        JFrame f1;
        JPanel main, sub;
        PacmanGraphics g1;
        JButton b1,b2;
        int xdir, ydir, index, i, ghostSteps, eatGhostCounter;
        boolean endgame, startGame, canEatGhosts;
        Pellet[] pellet, powerPellet;
        Ghost[] ghost;
        PacMan player;
        
    public PacmanGame() 
    { 
        player = new PacMan(400,500);

        xdir = 0;
        ydir = 0;
        ghostSteps = 0;
        eatGhostCounter = 0;
        endgame = false;
        startGame = false;
        canEatGhosts = false;
        
        pellet = new Pellet[100];
        powerPellet = new Pellet[3];
        
        for(index = 0; index < 10; index++)
        {
            for (i = 0; i < 10; i++) {  
                pellet[index * 10 + i] = new Pellet(index * 20 + 100, i* 20+100, player.getPacSize());
            }
        }
        
        powerPellet[0] = new Pellet(10, 10, player.getPacSize());
        powerPellet[1] = new Pellet(10, 600, player.getPacSize());
        powerPellet[2] = new Pellet(600, 10, player.getPacSize());
        
        ghost = new Ghost[4];
        ghost[0] = new Ghost(300,500,player.getPacSize(), 1);
        ghost[1] = new Ghost(200,600,player.getPacSize(), 2);
        ghost[2] = new Ghost(500,500,player.getPacSize(), 3);
        ghost[3] = new Ghost(400,300,player.getPacSize(), 4);
        
        f1 = new JFrame("PAC DAT MAN");
          f1.setSize(700,700);
          f1.setResizable(false);
          f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
          
        Container c1 = f1.getContentPane();
          
        g1 = new PacmanGraphics(player, ghost, endgame, pellet, powerPellet);
          g1.addKeyListener(this);
          
        b1 =  new JButton("Start");
           b1.addActionListener(this);
        
         b2 =  new JButton("End");
           b2.addActionListener(this);
         
        sub = new JPanel(); 
          sub.add(b1);
          sub.add(b2);
                     
        main = new JPanel();
          main.setLayout(new BorderLayout());          
          main.setSize(600,600);
          main.add(g1,BorderLayout.CENTER);
          main.add(sub,BorderLayout.SOUTH);
        
        c1.add(main);
        f1.show(); 
        runGame();
    }
    
    public void runGame()
    {
        Thread runner = new Thread();
         
      while(endgame == false)
      {    
          
          
        /** Need this section of code to slow computer down.  and  Line 55*/   
         try 
          { 
            runner.sleep(5); 
           }
          catch(InterruptedException e) {}  
          
       if (startGame == true) {   
       /** Need this section of code to slow computer down. */    
        for(index = 0; index < pellet.length; index++) {
            if(pellet[index].isPelletBeingEaten(player.getX(),player.getY()))
            {
                pellet[index].eatPellet();
                player.addScore(10);
            } 
        }
        
        for(index = 0; index < powerPellet.length; index++)
        {
            if(powerPellet[index].isPowerPelletBeingEaten(player.getX(), player.getY()))
            {
                powerPellet[index].eatPellet();
                eatGhostCounter = 0;
                canEatGhosts = true;
                player.addScore(50);
                  
                for(i = 0; i < ghost.length; i++)
                {
                    ghost[i].setCanEat(true);
                }
            }
        }
        
        if(canEatGhosts == true) 
        {
          eatGhostCounter++;
          
          for(index = 0; index < ghost.length; index++)
            {
              if(ghost[index].isGhostEatable(player.getX(), player.getY()))
              {
                  player.addScore(200);
                  ghost[index].setDidEat(true);
              }
              if(ghostSteps >= 100)
              {
                    ghost[index].runFromPac(player);
              }
              ghost[index].moveGhostSlow();
            }
          if(eatGhostCounter >= 800)
           {
               canEatGhosts = false;
               for(index = 0; index < ghost.length; index++)
               {  
                  ghost[index].setCanEat(false);
               }
           }
        }  else {  
            
            for(index = 0; index < ghost.length; index++) {
                if(ghost[index].isGhostHitting(player.getX(),player.getY()))
                {
                    endgame = true;
                } 
                if(ghostSteps >= 100)
                {
                    //ghost[index].changeDirectionRandom();
                    //ghost[index].chasePacPerfect(player);
                    ghost[index].chasePac(player);
                }
            ghost[index].moveGhost();
            }
        }
        
        if (ghostSteps >= 100) ghostSteps = 0;
        
        ghostSteps++;
        
        if (player.getX() < 0) {  
            xdir = 0; 
            player.setPac(0, player.getY());
        }
           
        if (player.getX() > 665) {  
            xdir = 0; 
            player.setPac(665, player.getY());   
        }
        
        if (player.getY() < 0) {  
            ydir = 0; 
            player.setPac(player.getX(), 0);
        }
           
        if (player.getY() > 595) {  
            ydir = 0; 
            player.setPac(player.getX(), 595);   
        }
        
        
        for (index = 0; index < ghost.length; index++) {
            if (ghost[index].getX() < 0) {  
                ghost[index].setDirectionX(0); 
                ghost[index].setGhost(0, ghost[index].getY());
            }
            
            if (ghost[index].getX() > 665) {  
                ghost[index].setDirectionX(0);
                ghost[index].setGhost(665, ghost[index].getY());   
            }
        
            if (ghost[index].getY() < 0) {  
                ghost[index].setDirectionY(0);
                ghost[index].setGhost(ghost[index].getX(), 0);
            }
           
            if (ghost[index].getY() > 605) {  
                ghost[index].setDirectionY(0);
                ghost[index].setGhost(ghost[index].getX(), 605);   
            }

        }
      
        player.movePac(xdir, ydir);
        g1.updateObjects(player, ghost, pellet, powerPellet, eatGhostCounter);
        g1.hitGhost(endgame);
        g1.repaint();
        }
       } 
     }   
    
    public void actionPerformed (ActionEvent event)
    {
        if (event.getSource() == b1)
        {
           g1.requestFocus();
           startGame = true;
         }
         
        if (event.getSource() == b2)
        {
           endgame = true;
         }
    }
    
    public void keyPressed(KeyEvent evt)
    {
           if(evt.getKeyCode() == 38)
           {
              xdir = 0;
              ydir = -1;
           }
           if(evt.getKeyCode() == 40)
           {
              xdir = 0;
              ydir = 1;
           }
           if(evt.getKeyCode() == 37)
           {
              xdir = -1;
              ydir = 0;
           }
           if(evt.getKeyCode() == 39)
           {
              xdir = 1;
              ydir = 0;
           }
    }
    public void keyReleased(KeyEvent evt)
    {}
    public void keyTyped(KeyEvent evt)
    {}
}
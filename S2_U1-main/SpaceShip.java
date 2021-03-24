/**
 * @author (Sawyer Theis)
 * @version (v1.0)
 */

public class SpaceShip
{
     int x, y, score; 
     
    public SpaceShip(int xx, int yy)
    {
        x = xx;
        y = yy; 
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
    
    public int getScore()
    {
      return score;    
    }
    
    public void addScore(int points)
   {
      score = score + points;   
    } 
    
    public void setShip (int xx, int yy) {
        x = xx;
        y = yy;
    }
    
    public void moveShip(int xdir, int ydir)
    {
       x = x + xdir;
       y = y + ydir;
    }
}
public class PacMan
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
    
    public int getSize() 
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
}
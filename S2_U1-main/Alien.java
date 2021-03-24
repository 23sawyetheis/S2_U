/**
 * @author (Sawyer Theis)
 * @version (v1.0)
 */

public class Alien
{
     int x, y;
     boolean destroyed;
     
    public Alien(int xx, int yy)
    {
      x = xx;
      y = yy;
      destroyed = false;
    }
    
    
    public int getX()
    {
        return x;
    }
    
    
    public int getY()
    {
        return y;
    }
    
    
    public boolean isDestroyed()
    {
        return destroyed;
    }

    
    public void destroyAlien()
    {
       destroyed = true;
    }    
}

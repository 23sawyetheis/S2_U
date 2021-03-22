public class Missile
{
     int x, y;
     
    public Missile(int xx, int yy)
    {
      x = xx;
      y = yy;
    }
    
    
    public int getX()
    {
        return x;
    }
    
    
    public int getY()
    {
        return y;
    }
    
    public void setMissile(int xx, int yy) {
        x = xx;
        y = yy;
    }
    
    public void moveMissile(int xdir, int ydir)
    {
        x = x + xdir;
        y = y + ydir;  
    }      
}
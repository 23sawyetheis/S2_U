public class Ghost
{
     int x, y, pacSize, size;
     
    public Ghost(int xx, int yy, int ppacSize)
    {
      x = xx;
      y = yy;
      size = 20;
      pacSize = ppacSize;
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
    
    public void moveGhost(int xdir, int ydir)
    {
       x = x + xdir;
       y = y + ydir;
    }
    
    public boolean isGhostHitting(int pacX, int pacY)
    {
        if (pacX >= x-pacSize && pacX <= x + size && pacY <= y + size && pacY >= y - pacSize) {
            return true;
        } else {
            return false;
        }
    }
}

public class Pellet
{
     int x, y, pacSize, size;
     boolean eaten;
     
    public Pellet(int xx, int yy, int ppacSize)
    {
      x = xx;
      y = yy;
      pacSize = ppacSize;
      size = 10;
      eaten = false;
    }
    
    
    public int getX()
    {
        return x;
    }
    
    public int getSize() 
    {
        return size;
    }
    
    public int getY()
    {
        return y;
    }
    
    public boolean isPelletBeingEaten(int pacX, int pacY)
    {
        if (pacX >= x-pacSize && pacX <= x + size && pacY <= y + size && pacY >= y - pacSize) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isEaten()
    {
        return eaten;
    }
    
    public void beenEaten()
    {
       eaten = true;
    }
}

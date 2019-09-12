/*
Braden Dressendorfer
Assignment 2
September 11, 2019
*/
public class GasTank
{
    private int maxCap = 0;
    private double level = 0.00;
    
    public GasTank(int cap)
    {
        if (cap > 0)
        {
            maxCap = cap;
        }
    }
    
    public int getCapacity()
    {
        return maxCap;
    }
    
    public double getLevel()
    {
        return Math.round(level*100.00)/100.00;
    }
    
    public void setLevel(double levelIn)
    {
        if(levelIn > maxCap)
        {
            level = maxCap;
        }
        if(levelIn < 0)
        {
            level = 0;
        }
        else
            level = levelIn;
    }
    
    
}
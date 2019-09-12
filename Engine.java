/*
Braden Dressendorfer
Assignment 2
September 11, 2019
*/

public class Engine
{
    private String description = " ";
    private int mpg = 0;
    private int maxSpeed = 0;
    
    public Engine(String desc, int mileage, int speed)
    {
        if (desc.length() == 0)
        {
            description = "Generic Engine";
        }
        else
            description = desc;
        if (mileage < 0)
        {
            mpg = 0;
        }
        else
            mpg = mileage;
        if (speed < 0)
        {
            maxSpeed = 0;
        }
        else
            maxSpeed = speed;
    }
    
    public int getMileage()
    {
        return mpg;
    }
    
    public int getSpeed()
    {
        return maxSpeed;
    }
    
    public String getDescription()
    {
        return description + " (MPG: " + getMileage() + ", Max Speed: " + getSpeed() + ")";
    }
    
    
}
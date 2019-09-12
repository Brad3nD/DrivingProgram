/*
Braden Dressendorfer
Assignment 2
September 11, 2019
*/
public class Auto
{
    private String autodesc = "";
    private int xcoord = 0;
    private int ycoord = 0;
    private GasTank tank;
    private Engine engine;
    
    public Auto(String desc, int maxFuel, Engine eng)
    {
        if (desc.length() == 0)
        {
            autodesc = "Generic Auto";
        }
        else
            autodesc = desc;
        if(eng == null)
        {
            engine = new Engine("",0,0);
        }
        else
            engine = eng;
        
        tank = new GasTank(maxFuel);
    }
    
    public int getX()
    {
        return xcoord;
    }
    
    public int getY()
    {
        return ycoord;
    }
    
    public double getFuelLevel()
    {
        return tank.getLevel();
    }
    
    public int getMPG()
    {
        return engine.getMileage();
    }
    
    public void fillUp()
    {
        tank.setLevel(tank.getCapacity());
    }
    
    public int getMaxSpeed()
    {
        return engine.getSpeed();
    }
    
    public String getDescription()
    {
        return autodesc + "(Engine: " + engine.getDescription() + ", Fuel: " + tank.getLevel() + "/" + tank.getCapacity() + ", Location: (" + getX() + "," + getY() + ")";
    }
    
    public double drive(int distance, double xRatio, double yRatio)
    {
        double milesDriven = 0.00;
        int milesPerGallon = getMPG();
        double fuelLevel = getFuelLevel();
        double possibleDistance = milesPerGallon * fuelLevel;
        double slope = yRatio/xRatio;
        
        if(distance > possibleDistance)
        {
            System.out.println("Ran out of gas after driving " + possibleDistance + " miles");
            milesDriven = possibleDistance;
            tank.setLevel(0);
            
        }
        if(distance <= possibleDistance)
        {
            milesDriven = distance;
            tank.setLevel(fuelLevel - (double)distance / (double)milesPerGallon);
        }
        
        if(xRatio == 0)
        {
            ycoord += milesDriven;
        }
        else if (yRatio == 0)
        {
            xcoord += milesDriven;
            
        }
        else if (xRatio !=0 || yRatio !=0)
        {
            //xRatio positive & yRatio positive
            if(xRatio > 0 && yRatio > 0)
            {
                xcoord = (int)(xcoord + milesDriven * (Math.sqrt(1/(1+slope*slope))));
                ycoord = (int)(ycoord + milesDriven * slope * (Math.sqrt(1/(1+slope*slope))));
            }
            //xRatio negative & yRatio negative
            else if(xRatio < 0 && yRatio < 0)
            {
                xcoord = (int)(xcoord - milesDriven * (Math.sqrt(1/(1+slope*slope))));
                ycoord = (int)(ycoord - milesDriven * slope * (Math.sqrt(1/(1+slope*slope))));
            }
            //xRatio negative & yRatio positive
            else if(xRatio < 0 && yRatio > 0)
            {
                xcoord = (int)(xcoord - milesDriven * (Math.sqrt(1/(1+slope*slope))));
                ycoord = (int)(ycoord - milesDriven * slope * (Math.sqrt(1/(1+slope*slope))));
            }
            //xRatio positive & yRatio negative
            else if(xRatio > 0 && yRatio < 0)
            {
                xcoord = (int)(xcoord + milesDriven * (Math.sqrt(1/(1+slope*slope))));
                ycoord = (int)(ycoord + milesDriven * slope * (Math.sqrt(1/(1+slope*slope))));
            }
            
        }
        
        
        return Math.round(milesDriven*100.00)/100.00;
    }
    /*
    THINGS TO FIX:
        DECIMAL HOLDERS
    */
}
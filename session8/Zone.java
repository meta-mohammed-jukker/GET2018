package session8;

import java.util.*;

public class Zone
{
    int numberOfCages;
    int numberOfCagesPresent;
    List<Cage> cageList;
    String zoneType;
    boolean hasPark;
    boolean hasCanteen;
    
    Zone(int numberOfCages, String zoneType, boolean hasPark, boolean hasCanteen)
    {
        this.numberOfCages = numberOfCages;
        this.numberOfCagesPresent = 0;
        this.cageList = new ArrayList<Cage>(numberOfCages);
        this.zoneType = zoneType;
        this.hasPark = hasPark;
        this.hasCanteen = hasCanteen;
    }
    
    String getZoneType()
    {
        return zoneType;
    }
    
    List<Cage> getCageList()
    {
        return cageList;
    }
    
    boolean isZoneEmpty()
    {
        if(numberOfCagesPresent == 0)
        {
            return true;
        }
        return false;
    }
    
    boolean isZoneFull(Cage cage)
    {
        if(numberOfCages == numberOfCagesPresent && !cage.isAddAnimalPossible())
        {
            return true;
        }
        return false;
    }
    
    Cage cageNotFilled()
    {
        for(Cage notFilledCage: cageList)
        {
            if(notFilledCage.isAddAnimalPossible())
            {
                return notFilledCage;
            }
        }
        return null;
    }
    
    
    Cage getLastCageAdded()
    {
        return cageList.get(cageList.size() - 1);
    }
    
    void addCage(Cage cage)
    {
         
        this.cageList.add(cage);
        numberOfCagesPresent++;
    }
    
    void removeAnimal(Cage cage)
    {
        this.cageList.remove(cage);
        numberOfCagesPresent--;
    }
    
}

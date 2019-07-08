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
    
    /**
     * Initializes Zone
     * @param numberOfCages maximum number of cages that can be added
     * @param zoneType type of zone
     * @param hasPark true if zone has park, else false
     * @param hasCanteen true if zone has canteen, else false
     */
    Zone(int numberOfCages, String zoneType, boolean hasPark, boolean hasCanteen)
    {
        this.numberOfCages = numberOfCages;
        this.numberOfCagesPresent = 0;
        this.cageList = new ArrayList<Cage>(numberOfCages);
        this.zoneType = zoneType;
        this.hasPark = hasPark;
        this.hasCanteen = hasCanteen;
    }
    
    /**
     * Returns zone type
     * @return zone type
     */
    String getZoneType()
    {
        return zoneType;
    }
    
    /**
     * Returns list of cages
     * @return list of cages
     */
    List<Cage> getCageList()
    {
        return cageList;
    }
    
    /**
     * Checks if zone is empty
     * @return true if zone is empty, else false
     */
    boolean isZoneEmpty()
    {
        if(numberOfCagesPresent == 0)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Checks if zone is full
     * @param cage last added cage in zone
     * @return true if zone is full, else false
     */
    boolean isZoneFull(Cage cage)
    {
        if(numberOfCages == numberOfCagesPresent && !cage.isAddAnimalPossible())
        {
            return true;
        }
        return false;
    }
    
    /**
     * Returns list of cages that are not filled to its limit
     * @return list of cages
     */
    List<Cage> cageNotFilled()
    {
        List<Cage> unfilledCageList = new ArrayList<Cage>();
        for(Cage notFilledCage: cageList)
        {
            if(notFilledCage.isAddAnimalPossible())
            {
                unfilledCageList.add(notFilledCage);
            }
        }
        return unfilledCageList;
    }
    
    /**
     * Returns last added cage in the zone
     * @return Cage object
     */
    Cage getLastCageAdded()
    {
        return cageList.get(cageList.size() - 1);
    }
    
    /**
     * Adds cage into zone
     * @param cage Cage object
     */
    void addCage(Cage cage)
    {
         
        this.cageList.add(cage);
        numberOfCagesPresent++;
    }
    
}

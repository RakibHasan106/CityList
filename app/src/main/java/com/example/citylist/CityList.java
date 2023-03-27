package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list of cities
     * @param flag , if flag=0 then sort the cities according to their city name
     *             if flag=1 then sort the cities according to their province name
     */
    public List<City> getCities(int flag) {
        List<City> cityList = cities;
        if(flag==0){
            Collections.sort(cityList);
        }
        else if(flag==1){
            Collections.sort(cityList,City.provincecomparator);
        }
        else{
            throw new IllegalArgumentException();
        }
        return cityList;
    }

    /**
     * a function to delete a city from the citylist, throws exception if it
     * is not in the citylist
     * @param city
     */
    public void delete(City city){
        if(!cities.contains(city)){
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * A function to count the number of cities in the citylist
     * @return the size of cities.
     */
    public int count(){
        return cities.size();
    }
}

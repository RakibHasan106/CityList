package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(0).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(0).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(0).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(0).get(1)));
    }

    @Test
    public void testdelete(){
        CityList cityList=new CityList();
        City city1=new City("Fulbari","Khulna");
        City city2=new City("Mirpur","Dhaka");
        City city3=new City("Sadarghat","Dhaka");

        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city1);
        cityList.delete(city2);

        assertTrue(!cityList.getCities(0).contains(city1));
        assertTrue(!cityList.getCities(0).contains(city2));

    }

    @Test
    public void testdeleteexception(){
        CityList cityList=new CityList();
        City city1=new City("Fulbari","Khulna");
        City city2=new City("Mirpur","Dhaka");
        City city3=new City("Sadarghat","Dhaka");

        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city1);
//        cityList.delete(city2);

        assertThrows(IllegalArgumentException.class,() -> {
            cityList.delete(city1);
        });
    }
    @Test
    public void testCount(){
        CityList cityList=new CityList();
        City city1=new City("Fulbari","Khulna");
        City city2=new City("Mirpur","Dhaka");
        City city3=new City("Sadarghat","Dhaka");

        cityList.add(city1);
        cityList.add(city2);

        assertEquals(2,cityList.count());
    }
    @Test
    public void testSort(){
        CityList cityList=new CityList();
        City city1=new City("Fulbari","Khulna");
        City city2=new City("Mirpur","Dhaka");
        City city3=new City("Sadarghat","Dhaka");

        cityList.add(city1);
        cityList.add(city2);

        assertEquals(cityList.getCities(0).get(0),cityList.getCities(1).get(0));
    }
}

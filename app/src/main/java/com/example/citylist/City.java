package com.example.citylist;

import java.util.Comparator;

public class City implements Comparable<City>{
    private String city;
    private String province;

    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }

    @Override
    public int compareTo(City city) {
        return this.city.compareTo(city.getCityName());
    }

    public static Comparator<City> provincecomparator = new Comparator<City>() {
        @Override
        public int compare(City city1, City city2) {
            return city1.getProvinceName().compareTo(city2.getProvinceName());
        }
    };
}
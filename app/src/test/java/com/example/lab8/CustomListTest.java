package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


//import org.junit.Before;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }


    /**
     * checks if there is a given city inside the list of cities
     * this test will check if to see if an EXISTING city is in the list
     */

    @Test
    public void hasCityTest1(){
        list  = MockCityList();
        City city = new City("Estevan", "SK");
        list.addCity(city);

        Assert.assertEquals(true,list.hasCity(city));

    }

    /**
     * checks if a NON-existing city is in the list
     */
    @Test
    public void hasCityTest2(){
        list = MockCityList();
        City city = new City("Yellowknife", "NT");
        Assert.assertEquals(false,list.hasCity(city));
    }

    /**
     * this test will attempt to delete a non-existing city inside the list
     */

    @Test
    public void deleteTest1() {
        list = MockCityList();
        City city = new City("Yellowknife", "NT");

        Assert.assertThrows(IllegalArgumentException.class, () -> {
            list.deleteCity(city);
        });

    }

    /**
     * this test will delete a city from the list
     */
    @Test
    public void deleteTest2(){
        list = MockCityList();
        City city = new City("Yellowknife", "NT");
        list.addCity(city);
        list.deleteCity(city);
        assertEquals(false,list.hasCity(city));

    }


}

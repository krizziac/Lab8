package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


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

        list.hasCity(city);

        Assert.assertEquals(true,list.hasCity(city));

    }

    /**
     * checks if a NON-existing city is in the list
     */
    @Test
    public void hasCityTest2(){

    }



}

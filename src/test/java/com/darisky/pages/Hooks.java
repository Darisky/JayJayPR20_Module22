package com.darisky.pages;

import com.darisky.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Base {
    @Before
    public void beforeTest(){
        getDriver();
        waiting();
    }

    @After
    public void afterTest(){
        theDriver.quit();
    }
}

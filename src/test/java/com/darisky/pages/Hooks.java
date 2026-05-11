package com.darisky.pages;

import com.darisky.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Base {
    @Before("@web")
    public void beforeTest(){
        getDriver();
        waiting();
    }

    @After("@web")
    public void afterTest(){
        theDriver.quit();
    }
}

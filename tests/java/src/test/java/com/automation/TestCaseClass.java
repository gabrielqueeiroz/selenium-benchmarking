package com.automation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import java.util.Map;


public class TestCaseClass extends IntermediateClass {
    private static final String URL="https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap";
    private Map<String, String> person;
    private Map<String, String> personUpdate;
    private HomePage homePage;
    private FormPage formPage;

    @BeforeEach
    public void setUp(){
        person = new Data().generateFormArray();
        personUpdate = new Data().generateUpdateArray();
        initializePages();
    }

    private void initializePages(){
        driver.get(URL);
        homePage = PageFactory.initElements(driver, HomePage.class);
        formPage = PageFactory.initElements(driver, FormPage.class);
    }

    @Test
    public void registerUser(){
        try {
            homePage.addCustomer();
            formPage.fillForm01(person);
            } catch (Exception e) {e.printStackTrace();}
    }

    @Test
    public void checkUsername(){
        homePage.addCustomer();
        formPage.fillForm02(person);
        homePage.checkCustomer(person.get("name"));
        formPage.checkCustomer(person.get("name"), person.get("last_name"));
    }

    @Test
    public void updateUser(){
        try{
            homePage.addCustomer();
            formPage.fillForm02(person);
            homePage.editCustomer();
            formPage.editCustomer(personUpdate);

        }catch (Exception e) {e.printStackTrace();}
    }

    @Test
    public void deleteUser(){
        try {
            homePage.addCustomer();
            formPage.fillForm02(person);
            homePage.deleteCustomer(person.get("name"));
        } catch (Exception e) {e.printStackTrace();}
    }

}


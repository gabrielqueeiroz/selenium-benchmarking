package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    public HomePage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/select/option[4]")
    @CacheLookup
    WebElement combo_select;
    @FindBy(how=How.XPATH,using="/html/body/div[2]/div[2]/div[1]/div[2]/form/div[1]/div[1]/a")
    @CacheLookup
    WebElement add_customer_button;
    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[1]/div[2]/form/div[2]/table/thead/tr[2]/td[3]/input")
    @CacheLookup
    WebElement search_name;
    @FindBy(how = How.XPATH, using = "//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[1]/div/input")
    @CacheLookup
    WebElement actions_checkbox;
    @FindBy(how = How.XPATH, using = "//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[2]/div[1]/a")
    @CacheLookup
    WebElement delete_button;
    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[3]/div/div/div[2]/p[2]")
    @CacheLookup
    WebElement delete_message;
    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[2]")
    @CacheLookup
    WebElement delete_popup_button;
    @FindBy(how = How.XPATH, using = "/html/body/div[4]/span[3]/p")
    @CacheLookup
    WebElement popup_message;
    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[1]/div[2]/form/div[2]/table/thead/tr[2]/td[2]/div[2]/a")
    @CacheLookup
    WebElement update_button;

    @FindBy(how = How.XPATH, using = "//*[@id=\"gcrud-search-form\"]/div[2]/table/tbody/tr/td[2]/div[1]/div/button")
    @CacheLookup
    WebElement more_button;

    @FindBy(how = How.XPATH, using = "//*[@id=\"gcrud-search-form\"]/div[2]/table/tbody/tr/td[2]/div[1]/div/ul/li[1]/a")
    @CacheLookup
    WebElement select_view;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[1]/div[2]/form/div[2]/table/tbody/tr[2]/td[2]/div[1]/a")
    @CacheLookup
    WebElement edit_button;

    @FindBy(how = How.XPATH, using = "//*[@id=\"gcrud-search-form\"]/div[2]/table/tbody/tr/td[3]")
    @CacheLookup
    WebElement text;

    @FindBy(how = How.XPATH, using = "//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[3]/i")
    @CacheLookup
    WebElement clear;


    public void addCustomer() {
        combo_select.click();
        add_customer_button.click();
    }

    public void deleteCustomer(String name){
        clear.click();
        search_name.sendKeys(name);
        update_button.click();
        actions_checkbox.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[2]/div[1]/a")));
        delete_button.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[1]")));
        assertEquals(delete_message.getText(), "Are you sure that you want to delete this 1 item?");
        delete_popup_button.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/span[3]/p")));
        assertEquals(popup_message.getText(), "Your data has been successfully deleted from the database.");
    }

    public void editCustomer(){
        edit_button.click();
    }

    public void checkCustomer(String name){
        clear.click();
        search_name.sendKeys(name);
        update_button.click();
        actions_checkbox.click();
        assertEquals(text.getText(), name);
        more_button.click();
        select_view.click();
    }
}

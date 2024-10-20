package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import java.util.Map;

public class FormPage {
    WebDriver driver;
    WebDriverWait wait;

    public FormPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"field-customerName\"]")
    @CacheLookup
    WebElement name;
    @FindBy(how = How.XPATH, using = "//*[@id=\"field-contactLastName\"]")
    @CacheLookup
    WebElement last_name;
    @FindBy(how = How.XPATH, using = "//*[@id=\"field-contactFirstName\"]")
    @CacheLookup
    WebElement contact_first_name;
    @FindBy(how = How.XPATH, using = "//*[@id=\"field-phone\"] ")
    @CacheLookup
    WebElement phone;
    @FindBy(how = How.XPATH, using = "//*[@id=\"field-addressLine1\"]")
    @CacheLookup
    WebElement addressLine1;
    @FindBy(how = How.XPATH, using = "//*[@id=\"field-addressLine2\"]")
    @CacheLookup
    WebElement addressLine2;
    @FindBy(how = How.XPATH, using = "//*[@id=\"field-city\"]")
    @CacheLookup
    WebElement city;
    @FindBy(how = How.XPATH, using = "//*[@id=\"field-state\"] ")
    @CacheLookup
    WebElement state;
    @FindBy(how = How.XPATH, using = "//*[@id=\"field-postalCode\"]")
    @CacheLookup
    WebElement postal_code;
    @FindBy(how = How.XPATH, using = "//*[@id=\"field-country\"]")
    @CacheLookup
    WebElement country;
    @FindBy(how = How.XPATH, using = "//*[@id=\"field-salesRepEmployeeNumber\"]")
    @CacheLookup
    WebElement from_employeer;
    @FindBy(how = How.XPATH, using = "//*[@id=\"field-creditLimit\"]")
    @CacheLookup
    WebElement credit_limit;
    @FindBy(how = How.XPATH, using = "//*[@id=\"form-button-save\"]")
    @CacheLookup
    WebElement save_button;
    @FindBy(how = How.XPATH, using = "//*[@id=\"report-success\"]")
    @CacheLookup
    WebElement form_message;
    @FindBy(how = How.XPATH, using = "//*[@id=\"save-and-go-back-button\"]")
    @CacheLookup
    WebElement save_and_back_buttton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"field-customerName\"]")
    @CacheLookup
    WebElement verify_name;
    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div/div/div[2]/form/div[16]/div/button")
    @CacheLookup
    WebElement back_to_list;
    @FindBy(how = How.XPATH, using = "//*[@id=\"field-contactLastName\"]")
    @CacheLookup
    WebElement verify_lastName;

    public void fillForm01(Map<String, String> person) {
        name.sendKeys(person.get("name"));
        last_name.sendKeys(person.get("last_name"));
        contact_first_name.sendKeys(person.get("contact_first_name"));
        phone.sendKeys(person.get("phone"));
        addressLine1.sendKeys(person.get("addressLine1"));
        addressLine2.sendKeys(person.get("addressLine2"));
        city.sendKeys(person.get("city"));
        state.sendKeys(person.get("state"));
        postal_code.sendKeys(person.get("postal_code"));
        country.sendKeys(person.get("country"));
        from_employeer.sendKeys(person.get("from_employeer"));
        credit_limit.sendKeys(person.get("credit_limit"));
        save_button.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"report-success\"]")));
        assertEquals("Your data has been successfully stored into the database. or ", form_message.getText());
    }

    public void fillForm02(Map<String, String> person) {
        name.sendKeys(person.get("name"));
        last_name.sendKeys(person.get("last_name"));
        contact_first_name.sendKeys(person.get("contact_first_name"));
        phone.sendKeys(person.get("phone"));
        addressLine1.sendKeys(person.get("addressLine1"));
        addressLine2.sendKeys(person.get("addressLine2"));
        city.sendKeys(person.get("city"));
        state.sendKeys(person.get("state"));
        postal_code.sendKeys(person.get("postal_code"));
        country.sendKeys(person.get("country"));
        from_employeer.sendKeys(person.get("from_employeer"));
        credit_limit.sendKeys(person.get("credit_limit"));
        save_and_back_buttton.click();
    }

    public void editCustomer(Map<String, String> person){
        name.sendKeys(person.get("name"));
        last_name.sendKeys(person.get("last_name"));
        save_button.click();
        assertEquals("Your data has been successfully updated. Go back to list", form_message.getText());
    }

    public void checkCustomer(String name, String lastName){
        assertEquals(name, verify_name.getText());
        assertEquals(lastName, verify_lastName.getText());
        back_to_list.click();
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ohtu;


import ohtu.*;
import ohtu.authentication.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
/**
 *
 * @author osla
 */
public class Tester2 {
    
    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:8090");
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("asdfasdf");
        element = driver.findElement(By.name("password"));
        element.sendKeys("asdf1234");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("asdf1234");
        element = driver.findElement(By.name("add"));
        element.submit();
        
        System.out.println(driver.getPageSource().contains("Welcome to Ohtu App!"));
    }
}

package org.example.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.example.constants.LcwConstant.PRODUCT_PRICE_IN_PAGE;

public class BasePage {

    WebDriver driver = null;
    WebDriverWait wait = null;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //elementi arama süresi

    }

    public WebElement findElement(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElements(by);
    }

    public float fixPrice(By by) {
        String fixedPrice = findElement(by).getAttribute("innerHTML").replaceAll("[^0-9.,]", "");
        return Float.parseFloat(fixedPrice.replace(',','.'));
    }

    public boolean isElementExist(By by) {
        try{
            driver.findElement(by);
            return true;
        }
        catch(NoSuchElementException ex){
            return false;
        }
    }

    public void sendText (By by, String text) {
        findElement(by).sendKeys(text);
    }

    public String getText (By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return findElement(by).getText();
    }

    public void clickElement (By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }

    public void scrollToDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
    }

}

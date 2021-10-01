package org.example.page;
import static org.example.constants.LcwConstant.*;
import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebElement;

import java.text.NumberFormat;
import java.util.List;
import java.util.Random;

public class main extends BasePage {

    private static Logger logger = (Logger) LogManager.getLogger(main.class);
    private static float priceOnProductPage = 0;

    public main(WebDriver driver) {
        super(driver);
    }

    public main isPageLoaded() {
        findElement(LCW_MAIN_CONTAINER);
        logger.debug("Website loaded.");
        return this;
    }

    public main getRandomSize() {
        Random rand = new Random();
        List<WebElement> Products = findElements(ALL_SIZE);
        WebElement randomElement = Products.get(rand.nextInt(Products.size()/2));
        randomElement.click();
        return this;
    }

    public main getRandomProduct() {
        Random rand = new Random();
        List<WebElement> Products = findElement(ALL_PRODUCT_DIV).findElements(By.className("product-item-wrapper"));
        WebElement randomElement = Products.get(rand.nextInt(Products.size()));
        randomElement.click();
        logger.info("Random product selected.");
        return this;
    }

    public main isPriceMatch() {
        Float productCartPrice =  fixPrice(PRODUCT_PRICE_IN_CART);
        if (priceOnProductPage == productCartPrice) {
            logger.info("prices match");
        } else {
            logger.fatal("prices not match");
        }
        return this;
    }

    public main clearCart () {
        try{
            Thread.sleep(2000);
            clickElement(REMOVE_PRODUCT_MODAL_OPEN);
            Thread.sleep(2000);
            clickElement(REMOVE_PRODUCT_BUTTON);
        }
        catch(InterruptedException ie){
        }

        logger.info("shopping cart removed");
        return this;
    }

    public main isCartEmpty() {
        if(isElementExist(CARD_EMPTY_TITLE)) {
            logger.info("cart is empty");
        }
        else {
            logger.warn("cart is not empty");
        }
        return this;
    }

    public main addProductToCart() {
        priceOnProductPage = fixPrice(PRODUCT_PRICE_IN_PAGE);
        clickElement(ADD_TO_CART);
        logger.info("Product added to cart");
        return this;
    }

    public main checkProductCount() {
        if(Integer.parseInt(findElement(PRODUCT_QUANTITIY).getAttribute("value")) == 2) {
            logger.warn("product quantitiy reached 2");
        }
        return this;
    }

    public main addProductQuantitiy() {
        clickElement(ADD_PRODUCT_QUANTITIY);
        logger.info("one more product added to cart");
        return this;
    }

    public main goToCart() {
        clickElement(GO_CART_PAGE_BUTTON);
        logger.trace("Redirected to cart page");
        return this;
    }

    public main goLoginPage() {
        clickElement(GO_LOGIN_PAGE_BUTTON);
        logger.trace("Redirected to log-in page");
        return this;
    }

    public main enterEmail() {
        sendText(LOGIN_EMAIL_INPUT,"isocantest@test.com");
        return this;
    }

    public main enterPassword() {
        sendText(LOGIN_PASSWORD_INPUT,"testtest123123");
        return this;
    }

    public main submitLogin() {
        clickElement(SUBMIT_LOGIN_BUTTON);
        return this;
    }

    public main scroolDown() {
        try {
            scrollToDown();
            Thread.sleep(3000);
        }
        catch(InterruptedException ie){}
        logger.info("page scrolled down.");
        return this;
    }

    public main searchProduct() {
        try {
            Thread.sleep(1000);
            sendText(SEARCH_PRODUCT_INPUT,"pantolon");
            Thread.sleep(1000);
            clickElement(SEARCH_PRODUCT_BUTTON);
        }
        catch (InterruptedException ie){}

        logger.info("Pantolon searching.");
        return this;
    }

    public main clickMoreProduct() {
        try {
            Thread.sleep(1500);
            clickElement(MORE_PRODUCT_BUTTON);
        }
        catch (InterruptedException ie){}
        return this;
    }

    public main isLoggedIn() {
        if (isElementExist(IS_LOGGED_IN)) {
            logger.info("Logged-in");
        } else {
            logger.fatal("Not Logged-in. Check your email or password");
        }
        return this;
    }


}

package org.example.test;
import org.example.page.main;
import org.example.base.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class mainTest extends BaseTest {

    main main;

    @Before
    public void before() {
        main = new main(getWebDriver());
    }

    @Test
    public void test() {
        main.isPageLoaded().
                goLoginPage().
                enterEmail().
                enterPassword().
                submitLogin().
                isLoggedIn().
                searchProduct().
                scroolDown().
                clickMoreProduct().
                getRandomProduct().
                getRandomSize().
                addProductToCart().
                goToCart().
                isPriceMatch().
                addProductQuantitiy().
                checkProductCount().
                clearCart();
    }

    @After
    public void after() {
        tearDown();
    }

}

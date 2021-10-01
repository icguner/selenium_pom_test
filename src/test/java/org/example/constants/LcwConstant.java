package org.example.constants;

import org.openqa.selenium.By;

public class LcwConstant {
    public static final By LCW_MAIN_CONTAINER= By.id("container");
    public static final By GO_LOGIN_PAGE_BUTTON= By.id("header-user-section");
    public static final By GO_CART_PAGE_BUTTON= By.xpath("/html/body/div[5]/div[2]/div[1]/div[4]/div/div[4]/a/i");
    public static final By LOGIN_EMAIL_INPUT= By.id("LoginEmail");
    public static final By LOGIN_PASSWORD_INPUT= By.id("Password");
    public static final By SUBMIT_LOGIN_BUTTON= By.id("loginLink");
    public static final By IS_LOGGED_IN= By.id("menu-user-sidebar");
    public static final By SEARCH_PRODUCT_INPUT= By.id("search");
    public static final By SEARCH_PRODUCT_BUTTON= By.className("search-button");
    public static final By MORE_PRODUCT_BUTTON= By.className("lazy-load-button");
    public static final By ALL_PRODUCT_DIV= By.cssSelector("#divModels > div:nth-child(10) > div > div.row.c-items");
    public static final By ALL_SIZE= By.cssSelector("a[data-tracking-label=\"BedenSecenekleri\"]");
    public static final By ADD_TO_CART= By.id("pd_add_to_cart");
    public static final By PRODUCT_PRICE_IN_PAGE= By.className("price");
    public static final By PRODUCT_PRICE_IN_CART= By.cssSelector(" div.col-md-4.col-xs-3.text-right.sc-option-detail.pl-0 > span");
    public static final By ADD_PRODUCT_QUANTITIY= By.cssSelector("a.oq-up.plus");
    public static final By CARD_EMPTY_TITLE= By.className("cart-empty-title");
    public static final By PRODUCT_QUANTITIY= By.className("item-quantity-input");
    public static final By REMOVE_PRODUCT_MODAL_OPEN= By.className("cart-square-link");
    public static final By REMOVE_PRODUCT_BUTTON= By.className("inverted-modal-button");
}

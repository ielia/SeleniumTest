package org.seleniumTest.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.seleniumTest.DriverManager;
import org.seleniumTest.utils.MoreExpectedConditions;

import java.time.Duration;
import java.util.List;

public class SearchPage extends BasePage<SearchPage> {
    @FindBy(name = "q")
    private WebElement searchBox;
    @FindBy(name = "btnK")
    private List<WebElement> searchButton;

    public SearchPage(WebDriver driver) {
        super(driver, domain);
    }

    @Step("Search by {0} with '{1}' term")
    public ResultPage searchBy(String search, String term) {
        searchBox.sendKeys(term);
        searchBox.sendKeys(Keys.ESCAPE);

        logger.info("Starting search process by '{}', with '{}' as term", search, term);

        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(2)).until(
                MoreExpectedConditions.anyElementToBeClickable(searchButton));

        switch (search) {
            case "button":
                button.click();
                break;
            case "submit":
                searchBox.submit();
                break;
            case "enter":
                searchBox.sendKeys(Keys.ENTER);
                break;
        }
        return new ResultPage(driver);
    }
}

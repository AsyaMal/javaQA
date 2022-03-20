package by.it_academy.onliner.pageobject;

import by.it_academy.onliner.driver.DriverManager;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BasePage {
    private static final String MAIN_NAVIGATION_LINK_XPATH_PATTERN = "//*[contains(@class, 'main-navigation__text')" +
            " and contains(text(), '%s')]";
    private static final int DRIVER_WAIT_TIME = 45;

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public WebElement findElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }

    public List<WebElement> waitForElementsVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(DriverManager.getDriver(), DRIVER_WAIT_TIME);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public List<String> getTextsFromWebElements(List<WebElement> webElements) {
        return getTextsFromWebElements(webElements, StringUtils.EMPTY);
    }

    public List<String> getTextsFromWebElements(List<WebElement> webElements, String splitByRegex) {
        return webElements
                .stream()
                .map(a -> StringUtils.split(a.getText(), splitByRegex))
                .flatMap(Arrays::stream)
                .filter(StringUtils::isNotEmpty)
                .collect(Collectors.toList());
    }

    public void moveToMainNavigationLink(String categoryLink) {
        Actions action = new Actions(DriverManager.getDriver());
        WebElement category = findElement(By.xpath(String.format(MAIN_NAVIGATION_LINK_XPATH_PATTERN, categoryLink)));
        action.moveToElement(category).perform();
    }

    public List<String> getSubcategories(By by) {
        return getTextsFromWebElements(waitForElementsVisible(by));
    }

}
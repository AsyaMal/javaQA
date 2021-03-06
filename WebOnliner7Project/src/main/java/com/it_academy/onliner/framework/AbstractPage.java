package com.it_academy.onliner.framework;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public abstract class AbstractPage {

    protected static final Logger LOG = LoggerFactory.getLogger(AbstractPage.class);
    private static final int DEFAULT_IMPLICIT_WAIT_TIMEOUT = 10;
    private static final int DRIVER_WAIT_TIME = 60;
    private final WebDriver driver;
    private WebDriverDiscovery webDriverDiscovery;

    public AbstractPage() {
        webDriverDiscovery = new WebDriverDiscovery();
        driver = webDriverDiscovery.getWebDriver();
    }

    public void navigate(String url) {
        driver.get(url);
    }

    public List<WebElement> waitForElementsVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, (long) DRIVER_WAIT_TIME);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public WebElement waitForElementVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, (long) DRIVER_WAIT_TIME);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    public List<String> getTextsFromWebElements(List<WebElement> webElements, String splitByRegex) {
        return webElements.stream().map(a -> StringUtils.split(a.getText(), splitByRegex)).flatMap(Arrays::stream).filter(StringUtils::isNotEmpty).collect(Collectors.toList());
    }

    public List<String> getTextsFromWebElements(List<WebElement> webElements) {
        return getTextsFromWebElements(webElements, StringUtils.EMPTY);
    }

    public boolean isElementDisplayed(By by) {
        return this.isExists(by) && this.getFirstVisibleElement(by) != null;
    }

    private WebElement getFirstVisibleElement(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        for (WebElement webElement : elements) {
            try {
                if (webElement.isDisplayed()) {
                    return webElement;
                }
            } catch (StaleElementReferenceException e) {
                continue;
            }
        }
        return null;
    }

    public boolean isExists(By by) {
        return this.defineStateWithoutTimeouts(() -> {
            return !driver.findElements(by).isEmpty();
        });
    }

    private boolean defineStateWithoutTimeouts(Supplier<Boolean> defineAction) {
        this.removeTimeOuts();
        try {
            return (Boolean) defineAction.get();
        } finally {
            this.setTimeOutsToDefault();
        }
    }

    private void setTimeOutsToDefault() {
        driver.manage().timeouts().implicitlyWait((long) DEFAULT_IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
    }

    private void removeTimeOuts() {
        driver.manage().timeouts().implicitlyWait(3L, TimeUnit.SECONDS);
    }

    public void closeBrowser() {
        try {
            driver.quit();
        } catch (Exception e) {
            LOG.error("CLOSE BROWSER ERROR: {}", e.getMessage(), e);
        }
    }
}
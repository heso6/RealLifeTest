package pages.basePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPageOne extends BasePage {


    List<String> resultsList1 = new ArrayList<String>();

    public SearchResultsPageOne(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@class='gsc-input']")
    private WebElement inputFieldFromPageOne;


    @FindBy(css = ".gs-title")
    private List<WebElement> listOfSearchResultsRowFromPageOne;

    @FindBy(css = ".gsc-cursor-page")
    private List<WebElement> pageNumberList;

    public String shouldGetUrlCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String shouldGetTextFromInputFieldFromPageOne() {
        wait.until(ExpectedConditions.visibilityOf(inputFieldFromPageOne));
        return inputFieldFromPageOne.getAttribute("value");
    }

    public void shouldCheckIsSearchResultListFromPageOneIsEmpty() throws IllegalStateException {
        if (listOfSearchResultsRowFromPageOne.size() == 0) {
            throw new IllegalStateException("Lista jest pusta");
        }
        System.out.println(listOfSearchResultsRowFromPageOne.size());
    }

    public void shouldGoToPageTwo() {
        for (WebElement pages : pageNumberList) {
            if (pages.getText().contains("2")) {
                pages.click();
            }
        }
    }

    public void shouldGetTextListResultsFromPageOne() {
        for (WebElement list1 : listOfSearchResultsRowFromPageOne) {
            resultsList1.add(list1.getText());
        }
        System.out.println(resultsList1);
    }
}



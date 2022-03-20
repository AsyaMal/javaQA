package by.it_academy.onliner.steps;

import by.it_academy.onliner.pageobject.HeaderPage;
import by.it_academy.onliner.pageobject.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class OnlinerHeaderSteps {

    private HomePage onlinerHomePage = new HomePage();
    private HeaderPage headerPage = new HeaderPage();

    @Given("the user opens Onliner website")
    public void userOpensOnlinerWebsite() {
        onlinerHomePage.openOnlinerWebsite();
    }

    @When("the user moves the mouse on the Avtobaraholka")
    public void theUserMovesTheMouseOnTheAvtobaraholka() {
        onlinerHomePage.moveToMainNavigationLink("Автобарахолка");
    }

    @Then("the Avtobaraholka dropdown menu contains brand names")
    public void avtobaraholkaDropdownMenuContainsBrandNames(List<String> carBrands) {
        List<String> carBrandsCategories =
                headerPage.getSubcategories(headerPage.getAvtobaraholkaSubcategories());
        assertThat(carBrandsCategories)
                .as("Avtobaraholka dropdown menu doesn't contain brand names")
                .containsAll(carBrands);
    }

    @Then("the Avtobaraholka dropdown menu contains towns")
    public void avtobaraholkaDropdownMenuContainsTowns(List<String> towns) {
        List<String> carTownsCategories =
                headerPage.getSubcategories(headerPage.getAvtobaraholkaSubcategories());
        assertThat(carTownsCategories)
                .as("Avtobaraholka dropdown menu doesn't contain towns")
                .containsAll(towns);
    }

    @When("the user moves the mouse on the Doma and Kvartiry")
    public void theUserMovesTheMouseOnTheDomaAndKvartiry() {
        onlinerHomePage.moveToMainNavigationLink("Дома и квартиры");
    }

    @Then("the Doma and Kvartiry dropdown menu contains towns and quantity of rooms")
    public void housesAndApartmentsDropdownMenuContainsTownsAndQquantityOfRooms(List<String> towns) {
        List<String> homeTownCategories =
                headerPage.getSubcategories(headerPage.getHousesAndApartmentsSubcategories());
        assertThat(homeTownCategories)
                .as("Doma and Kvartiry dropdown menu doesn't contain towns and quantity of rooms")
                .containsAll(towns);
    }

    @Then("the Doma and Kvartiry dropdown menu contains price rang")
    public void housesAndApartmentsDropdownMenuContainsPriceRang() {
        assertThat(headerPage.getSubcategories(headerPage.getHousesAndApartmentsSubcategories()))
                .as("Doma and Kvartiry dropdown menu doesn't contain price rang")
                .anyMatch(i -> i.contains("$"));
    }
}

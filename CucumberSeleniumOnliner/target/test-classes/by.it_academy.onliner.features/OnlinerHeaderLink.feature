Feature: As an user
  I want to see certain subcategories in dropdown menu of Avtobaraholka and Doma and Kvartiry categories
    @smoke
  Scenario: Certain Onliner Links should contain dropdown menu and subcategories
    Given the user opens Onliner website
    When the user moves the mouse on the Avtobaraholka
    Then the Avtobaraholka dropdown menu contains brand names
      | Audi          |
      | BMW           |
      | Citroen       |
      | Ford          |
      | Mazda         |
      | Mercedes-Benz |
      | Nissan        |
      | Opel          |
      | Peugeot       |
      | Renault       |
      | Toyota        |
      | Volkswagen    |
    And the Avtobaraholka dropdown menu contains towns
       | Минск   |
       | Гомель  |
       | Могилев |
       | Витебск |
       | Гродно  |
       | Брест   |
  @smoke
  Scenario: Certain Onliner Links should contain dropdown menu and subcategories
    Given the user opens Onliner website
    When the user moves the mouse on the Doma and Kvartiry
    Then the Doma and Kvartiry dropdown menu contains towns and quantity of rooms
      | Минск        |
      | Брест        |
      | Витебск      |
      | Гомель       |
      | Гродно       |
      | Могилев      |
      | 1-комнатные  |
      | 2-комнатные  |
      | 3-комнатные  |
      | 4+-комнатные |
    And the Doma and Kvartiry dropdown menu contains price rang
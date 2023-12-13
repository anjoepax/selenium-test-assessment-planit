package org.planittesting.com.tests;

import org.planittesting.com.BaseTest;
import org.planittesting.com.pages.CartPage;
import org.planittesting.com.pages.ContactPage;
import org.planittesting.com.pages.HomePage;
import org.planittesting.com.pages.ShoppingPage;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestAssessment extends BaseTest {

    /***
     * 1. From the home page go to contact page
     * 2. Click submit button
     * 3. Verify error messages
     * 4. Populate mandatory fields
     * 5. Validate errors are gone
     */
    @Test
    public void testCase1() {
        HomePage homePage = new HomePage();

        //Clicking the submit button without filling up the required fields
        String errMsg = homePage.goTo()
                .goToContactPage()
                .clickSubmitButton()
                .getErrorMessage();
        assertThat(errMsg).isEqualTo(
                "We welcome your feedback - but we won't get it unless you complete the form correctly."
        );

        //Fill up mandatory fields after clicking of submit button
        String infoMsg = new ContactPage()
                .enterForeName("AJ Testing")
                .enterEmail("aj@email.com")
                .enterMessage("This is sample message")
                .getInfoMessage();
        assertThat(infoMsg).isEqualTo("We welcome your feedback - tell it how it is.");
    }


    /***
     * 1. From the home page go to contact page
     * 2. Populate mandatory fields
     * 3. Click submit button
     * 4. Validate successful submission message
     */
    @Test
    public void testCase2() {
        //Verify success message
        String successMsg = new ContactPage().goTo()
                .enterForeName("AJBlues")
                .enterSurname("Tester")
                .enterEmail("aj@email.com")
                .enterTelephoneNumber("12345")
                .enterMessage("This is sample message")
                .clickSubmitButton()
                .getSuccessMessage();
        assertThat(successMsg).isEqualTo("Thanks AJBlues, we appreciate your feedback.");
    }


    /***
     * 1. Buy 2 Stuffed Frog, 5 Fluffy Bunny, 3 Valentine Bear
     * 2. Go to the cart page
     * 3. Verify the subtotal for each product is correct
     * 4. Verify the price for each product
     * 5. Verify that total = sum(subtotals)
     */
    @Test
    public void testCase3() {

        //Buy product from the Shopping page
        new ShoppingPage().goTo()
                .buyProduct("Stuffed Frog", 2)
                .buyProduct("Fluffy Bunny", 5)
                .buyProduct("Valentine Bear", 3);

        CartPage cartPage = new CartPage().goTo();

        //Verify the subtotal for each product is correct
        List<String> expectedSubtotalOfEachProduct = new ArrayList<>();
        //Stuffed Frog Subtotal - 10.99 * 2
        expectedSubtotalOfEachProduct.add("$21.98");
        //Fluffy Bunny Subtotal - 9.99 * 5
        expectedSubtotalOfEachProduct.add("$49.95");
        //Valentine Bear Subtotal - 14.99 * 3
        expectedSubtotalOfEachProduct.add("$44.97");
        assertThat(cartPage.getTableValue("SUBTOTAL")).isEqualTo(expectedSubtotalOfEachProduct);

        //Verify the price of each product
        List<String> expectedPrices = List.of("$10.99", "$9.99", "$14.99");
        assertThat(cartPage.getTableValue("PRICES")).isEqualTo(expectedPrices);

        //Verify total
        //21.98 + 49.95 + 44.97
        assertThat(cartPage.getTotalValue()).isEqualTo("116.9");
    }
}

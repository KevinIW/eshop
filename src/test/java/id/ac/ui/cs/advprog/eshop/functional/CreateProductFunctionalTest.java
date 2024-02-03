package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
public class CreateProductFunctionalTest {

    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost:8080}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s/product", testBaseUrl);
    }

    @Test
    void createProduct_andVerifyInList(ChromeDriver driver) throws Exception {
        // Navigate to the create product page
        driver.get(baseUrl + "/create");

        // Fill in the form to create a new product
        WebElement productNameInput = driver.findElement(By.id("nameInput"));
        productNameInput.sendKeys("New Product");

        WebElement productQuantityInput = driver.findElement(By.id("quantityInput"));
        productQuantityInput.sendKeys("50");

        // Submit the form
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        // Verify that the user is redirected to the product list page
        String productListUrl = String.format("%s/list", baseUrl);
        assertEquals(productListUrl, driver.getCurrentUrl());

        // Verify that the new product is in the list
        WebElement newProductRow = driver.findElement(By.xpath("//td[text()='New Product']"));
        assertNotNull(newProductRow);

        // Optional: You can add more assertions based on your application's behavior
    }

}

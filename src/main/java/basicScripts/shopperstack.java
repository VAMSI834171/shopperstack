package basicScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class shopperstack {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15)
        );

        try {
            driver.manage().window().maximize();

            // Open ShopperStack
            driver.get("https://www.shoppersstack.com/");

            // Wait for Create Admin Account and click it
            WebElement adminAccount = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//*[contains(normalize-space(), 'Create Admin Account')]")
                    )
            );

            adminAccount.click();

            // First Name
            WebElement firstName = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.id("First Name")
                    )
            );
            firstName.sendKeys("rohit");

            // Last Name
            driver.findElement(By.id("Last Name"))
                    .sendKeys("shrama");

            // Gender
            driver.findElement(By.id("Male"))
                    .click();

            // Phone
            driver.findElement(By.id("Phone Number"))
                    .sendKeys("9882226664");

            // Email
            driver.findElement(By.id("Email Address"))
                    .sendKeys("rohit4555@gmail.com");

            // Password
            driver.findElement(By.id("Password"))
                    .sendKeys("Rohit@222");

            // Confirm Password
            driver.findElement(By.id("Confirm Password"))
                    .sendKeys("Rohit@222");

            // Country
            Select country = new Select(
                    wait.until(
                            ExpectedConditions.visibilityOfElementLocated(
                                    By.id("Country")
                            )
                    )
            );
            country.selectByVisibleText("India");

            // State
            Select state = new Select(
                    wait.until(
                            ExpectedConditions.visibilityOfElementLocated(
                                    By.id("State")
                            )
                    )
            );
            state.selectByVisibleText("Karnataka");

            // City
            Select city = new Select(
                    wait.until(
                            ExpectedConditions.visibilityOfElementLocated(
                                    By.id("City")
                            )
                    )
            );
            city.selectByVisibleText("Bengaluru");

            // Register
            WebElement register = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(normalize-space(), 'Register')]")
                    )
            );

            register.click();

            // Keep browser open for a few seconds so you can see the result
            Thread.sleep(5000);

        } finally {
            driver.quit();
        }
    }
}
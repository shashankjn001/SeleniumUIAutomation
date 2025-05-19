package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/client");

        driver.findElement(By.id("userEmail")).sendKeys("demoautomation@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Password12345");
        driver.findElement(By.id("login")).click();


        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

        WebElement filteredElement = products.stream().filter(product -> product.findElement(By.cssSelector("b"))
                .getText().equals("IPHONE 13 PRO")).findFirst().orElse(null);


        if (filteredElement != null) {
            System.out.println("True");
            filteredElement.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();
        }

    }
}

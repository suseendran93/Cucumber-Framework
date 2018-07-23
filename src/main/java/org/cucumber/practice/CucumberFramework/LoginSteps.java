package org.cucumber.practice.CucumberFramework;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {

	WebDriver driver;

	@Given("user is on Adactin page")
	public void user_is_on_Adactin_page() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ssndr\\Documents\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.adactin.com/HotelApp/");
		Assert.assertTrue(driver.getCurrentUrl().contains("adactin"));

	}

	@When("^user enters the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_the_and(String username, String password) {
		WebElement user = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
		user.clear();
		user.sendKeys(username);
		pass.clear();
		pass.sendKeys(password);
		Assert.assertEquals(username, user.getAttribute("value"));
		Assert.assertEquals(password, pass.getAttribute("value"));
	}

	@Then("user clicks the login button")
	public void user_clicks_the_login_button() {
		WebElement login = driver.findElement(By.xpath("//input[@type='Submit']"));
		login.click();
		if(driver.getCurrentUrl().equals("http://www.adactin.com/HotelApp/SearchHotel.php")) {
		Assert.assertTrue(driver.getCurrentUrl().contains("Search"));
		}
		else {
			WebElement invalid = driver.findElement(By.xpath("//b[contains(text(),'Invalid')]"));
			invalid.isDisplayed();
		}
		driver.quit();
	}
}

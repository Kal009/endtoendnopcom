package nop.com;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


/**
 * Created by Trupesh on 21/05/2017.
 */
public class EndToEndNopCom {
   // private ChromeDriver driver;
    //private InternetExplorerDriver driver;
    private FirefoxDriver driver;

   public String email ;
    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver","C:\\Cucumbe jars\\WebDrivers\\geckodriver.exe");
        driver = new FirefoxDriver();

        //System.setProperty("webdriver.chrome.driver", "C:\\Cucumbe jars\\chromedriver.exe");

       // System.setProperty("webdriver.ie.driver", "C:\\Cucumbe jars\\MicrosoftWebDriver.exe");
       // driver = new InternetExplorerDriver();
       //driver = new ChromeDriver();
        //driver = new SafariDriver();
        driver.get("http://demo.nopcommerce.com");
        driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(120,TimeUnit.SECONDS);

        //driver.manage().window().maximize();
        Thread.sleep(3000);

       email = getRandomEmail();
        System.out.println(email);

    }



   // @Test
    public void pi () throws InterruptedException {
        driver.findElement(By.linkText("Register")).click();
        //Thread.sleep(2000);
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Kalpesh");
        driver.findElement(By.id("LastName")).sendKeys("ghinaiya");
       // Thread.sleep(1000);
        new Select(driver.findElement(By.name("DateOfBirthDay"))).selectByVisibleText("8");
        new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText("September");
        new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText("1985");
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys("somnath");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("somnath");
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(5000);
        //assertTrue(driver.findElement(By.className("result")).getText().matches("Your registration completed"));
        driver.findElement(By.linkText("Log out")).click();


    }

    @Test
    public void loginFuc() throws InterruptedException {
        pi();
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys("somnath");
        driver.findElement(By.xpath("//input[@value='Log in' and @type='submit']")).click();
        driver.findElement(By.linkText("Jewelry")).click();
        driver.findElement(By.linkText("Vintage Style Engagement Ring")).click();
        driver.findElement(By.id("add-to-cart-button-42")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//input[@value='Go to cart' and @type='button']")).click();
        driver.findElement(By.linkText("Shopping cart")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();
       // assertTrue(driver.findElement(By.className("page-title")).getText().matches("Welcome, Please Sign In!"));
       // driver.findElement(By.id("Email")).sendKeys(email);
       // driver.findElement(By.id("Password")).sendKeys("somnath");
        new Select(driver.findElement(By.id("BillingNewAddress_CountryId"))).selectByVisibleText("United Kingdom");
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("London");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("38 Charterhouse Avenue");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("ha0 3df");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("07512530021");
        driver.findElement(By.xpath("//input[@value='Continue'  and @type='button']")).click();
        //driver.findElement(By.xpath("//input[@id='shippingoption_1' and @value='Next Day Air___Shipping.FixedOrByWeight']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@class='button-1 shipping-method-next-step-button' and @value='Continue']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='paymentmethod_1' and @value='Payments.Manual']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@class='button-1 payment-method-next-step-button' and @value='Continue']")).click();

        Thread.sleep(1000);
        driver.findElement(By.id("CardholderName")).sendKeys("kalpesh Ghinaiya");
        driver.findElement(By.id("CardNumber")).sendKeys("1234963214587896");
        new Select(driver.findElement(By.id("ExpireMonth"))).selectByVisibleText("04");
        new Select(driver.findElement(By.id("ExpireYear"))).selectByVisibleText("2018");
        driver.findElement(By.id("CardCode")).sendKeys("584");
        driver.findElement(By.xpath("//input [@class='button-1 payment-info-next-step-button' and @value='Continue']")).click();
       // driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()' and @class='button-1 payment-method-next-step-button']")).click();

       //Thread.sleep(5000);
      // driver.findElement(By.xpath("//input[@class='button-1 payment-method-next-step-button' and @value='Continue']")).click();

       // Thread.sleep(5000);
       // driver.findElement(By.xpath("//input[@class='button-1 payment-info-next-step-button' and @value='Continue']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='button' and @value='Confirm']")).click();
        Thread.sleep(3000);
        Assert.assertTrue((driver.findElement(By.xpath("//div[@class='page-title']"))).getText().matches("Thank you"));
        Thread.sleep(2000);
        driver.findElement(By.linkText("Log out")).click();
    }
      // @Test
        public void payment(){
            driver.get("https;//http://demo.nopcommerce.com/onepagecheckout");

            driver.findElement(By.xpath("//input[@class='button-1 payment-method-next-step-button' and @value='Continue']")).click();
            driver.findElement(By.id("CardholderName")).sendKeys("kalpesh Ghinaiya");
            driver.findElement(By.id("CardNumber")).sendKeys("1234963214587896");
            new Select(driver.findElement(By.id("ExpireMonth"))).selectByVisibleText("04");
            new Select(driver.findElement(By.id("ExpireYear"))).selectByVisibleText("2018");
            driver.findElement(By.id("CardCode")).sendKeys("584");
            driver.findElement(By.xpath("//input [@class='button-1 payment-info-next-step-button' and @value='Continue']")).click();
            driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()' and @class='button-1 payment-method-next-step-button']")).click();

        }



    public String getRandomEmail()
    {
        Random random = new Random();
        return  random.nextInt()+"test@gmail.com";
    }



    @After
    public void tearDown() throws Exception {
       // Thread.sleep(10000);
        driver.close();
      //  driver.quit();
    }

}
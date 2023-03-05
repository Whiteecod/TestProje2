package TestProje2;

import Untility.BaseDriver;
import Untility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Proje2 extends BaseDriver {

   @Test
    public void registerTest () {
       driver.get("http://demowebshop.tricentis.com/");

      Actions aksiyonlar=new Actions(driver);

       WebElement register=driver.findElement(By.xpath("//a[text()='Register']"));
       aksiyonlar.moveToElement(register).click().build().perform();


       MyFunc.Bekle(3);
       WebElement gender=driver.findElement(By.xpath("//input[@id='gender-male']"));
       aksiyonlar.moveToElement(gender).click().build().perform();

       MyFunc.Bekle(3);
       WebElement firstName=driver.findElement(By.xpath("//input[@id='FirstName']"));
       aksiyonlar.moveToElement(firstName).click().sendKeys("kubilayy").build().perform();

       MyFunc.Bekle(3);
       WebElement lastName=driver.findElement(By.xpath("//input[@id='LastName']"));
       aksiyonlar.moveToElement(lastName).click().sendKeys("culhaa").build().perform();

       MyFunc.Bekle(3);
       WebElement email=driver.findElement(By.xpath("//input[@id='Email']"));
       aksiyonlar.moveToElement(email).click().sendKeys("kubilayculhaaa@hotmail.com").build().perform();

      MyFunc.Bekle(3);
       WebElement password=driver.findElement(By.xpath("//input[@id='Password']"));
       aksiyonlar.moveToElement(password).click().sendKeys("pas123456").build().perform();

      MyFunc.Bekle(3);
       WebElement confirmPassword=driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
       aksiyonlar.moveToElement(confirmPassword).click().sendKeys("pas123456").build().perform();

      MyFunc.Bekle(3);
       WebElement register2=driver.findElement(By.cssSelector("input[id='register-button']"));
       aksiyonlar.moveToElement(register2).click().build().perform();

       WebElement dogrulamna=driver.findElement(By.cssSelector("div[class='result']"));

      Assert.assertEquals("Your registration completed" ,dogrulamna.getText());

      BekleKapat();
   }

   @Test
    public void failedLRegisterTest() {
       driver.get("http://demowebshop.tricentis.com/");

       Actions aksiyonlar=new Actions(driver);

       WebElement register=driver.findElement(By.xpath("//a[text()='Register']"));
       aksiyonlar.moveToElement(register).click().build().perform();


       MyFunc.Bekle(3);
       WebElement gender=driver.findElement(By.xpath("//input[@id='gender-male']"));
       aksiyonlar.moveToElement(gender).click().build().perform();

       MyFunc.Bekle(3);
       WebElement firstName=driver.findElement(By.xpath("//input[@id='FirstName']"));
       aksiyonlar.moveToElement(firstName).click().sendKeys("kubilayy").build().perform();

       MyFunc.Bekle(3);
       WebElement lastName=driver.findElement(By.xpath("//input[@id='LastName']"));
       aksiyonlar.moveToElement(lastName).click().sendKeys("culhaa").build().perform();

       MyFunc.Bekle(3);
       WebElement email=driver.findElement(By.xpath("//input[@id='Email']"));
       aksiyonlar.moveToElement(email).click().sendKeys("kubilayculhaaa@hotmail.com").build().perform();

       MyFunc.Bekle(3);
       WebElement password=driver.findElement(By.xpath("//input[@id='Password']"));
       aksiyonlar.moveToElement(password).click().sendKeys("pas123456").build().perform();

       MyFunc.Bekle(3);
       WebElement confirmPassword=driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
       aksiyonlar.moveToElement(confirmPassword).click().sendKeys("pas123456").build().perform();

       MyFunc.Bekle(3);
       WebElement register2=driver.findElement(By.cssSelector("input[id='register-button']"));
       aksiyonlar.moveToElement(register2).click().build().perform();

       WebElement dogrulamna=driver.findElement(By.xpath("//div[@class='validation-summary-errors']"));

       Assert.assertEquals("The specified email already exists" ,dogrulamna.getText());

       BekleKapat();
   }

   @Test
    public void loginTest () {
        driver.get("http://demowebshop.tricentis.com/");

        Actions aksiyonlar = new Actions(driver);

        WebElement login = driver.findElement(By.linkText("/login"));
        aksiyonlar.moveToElement(login).click().build().perform();

        MyFunc.Bekle(3);
       WebElement eMail = driver.findElement(By.xpath("//input[@id='Email']"));
       aksiyonlar.moveToElement(eMail).click().sendKeys("kubilayculhaaa@hotmail.com").build().perform();

       MyFunc.Bekle(3);
       WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
       aksiyonlar.moveToElement(eMail).click().sendKeys("pas123456").build().perform();

       MyFunc.Bekle(3);
       WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log in']"));

       MyFunc.Bekle(3);
       WebElement logout = driver.findElement(By.xpath("//*[@class='ico-logout']"));
       Assert.assertTrue("Giriş Başarısız", logout.isDisplayed());

       BekleKapat();
   }

    @Test
    public void failedLoginTest () {
        driver.get("http://demowebshop.tricentis.com/");

        Actions aksiyonlar = new Actions(driver);

        WebElement login = driver.findElement(By.linkText("/login"));
        aksiyonlar.moveToElement(login).click().build().perform();

        MyFunc.Bekle(3);
        WebElement eMail = driver.findElement(By.xpath("//input[@id='Email']"));
        aksiyonlar.moveToElement(eMail).click().sendKeys("kubilay__culhaaa@hotmail.com").build().perform();

        MyFunc.Bekle(3);
        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        aksiyonlar.moveToElement(eMail).click().sendKeys("pas123456").build().perform();

        MyFunc.Bekle(3);
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log in']"));

        MyFunc.Bekle(3);
        WebElement failedLogin = driver.findElement(By.xpath("//div[@class='validation-summary-errors']"));
        Assert.assertTrue("Login hatası oluşmadı", failedLogin.getText().contains("Login was unsuccessful. Please correct the errors and try again."));

        BekleKapat();
    }

    @Test
    public void orderTest() {

        driver.get("http://demowebshop.tricentis.com/");

        Actions aksiyonlar = new Actions(driver);

        WebElement login = driver.findElement(By.xpath("//a[@href='/login']"));
        aksiyonlar.moveToElement(login).click().build().perform();

        MyFunc.Bekle(3);
        WebElement eMail = driver.findElement(By.xpath("//input[@id='Email']"));
        aksiyonlar.moveToElement(eMail).click().sendKeys("kubilayculhaaa@hotmail.com").build().perform();

        MyFunc.Bekle(3);
        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        aksiyonlar.moveToElement(password).click().sendKeys("pas123456").build().perform();

        MyFunc.Bekle(3);
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log in']"));
        aksiyonlar.moveToElement(loginButton).click().build().perform();

        MyFunc.Bekle(3);
        WebElement computers = driver.findElement(By.xpath("//a[@href='/computers']"));
        aksiyonlar.moveToElement(computers).build().perform();

        MyFunc.Bekle(3);
        WebElement notebooks = driver.findElement(By.xpath("//a[@href='/notebooks']"));
        aksiyonlar.moveToElement(notebooks).click().build().perform();

        MyFunc.Bekle(3);
        WebElement laptop = driver.findElement(By.linkText("14.1-inch Laptop"));
        aksiyonlar.moveToElement(laptop).click().build().perform();

        MyFunc.Bekle(3);
        WebElement addToCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button-31']"));
        aksiyonlar.moveToElement(addToCart).click().build().perform();

        MyFunc.Bekle(3);
        WebElement addedToCart = driver.findElement(By.xpath("//*[@style='display: block;']"));
        Assert.assertTrue("Sepete Eklenemedi", addedToCart.isDisplayed());

        WebElement shoppingCart = driver.findElement(By.xpath("//a[text()='shopping cart']"));
        aksiyonlar.moveToElement(shoppingCart).click().build().perform();


        WebElement agree = driver.findElement(By.xpath("//input[@id='termsofservice']"));
        aksiyonlar.moveToElement(agree).click().build().perform();


        WebElement checkOut = driver.findElement(By.xpath("//*[@id='checkout']"));
        aksiyonlar.moveToElement(checkOut).click().build().perform();
        MyFunc.Bekle(2);


        WebElement company = driver.findElement(By.xpath("//*[@id='BillingNewAddress_Company']"));
        aksiyonlar.moveToElement(company).click().sendKeys("asdasd").build().perform();
        MyFunc.Bekle(2);

//
        WebElement country = driver.findElement(By.xpath("//*[@id='BillingNewAddress_CountryId']"));
        aksiyonlar.moveToElement(country).click().build().perform();

        Select countrySelect = new Select(country);
        countrySelect.selectByVisibleText("Turkey");

        WebElement city = driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']"));
        aksiyonlar.moveToElement(city).click().sendKeys("Gaziantep").build().perform();


        WebElement adress1 = driver.findElement(By.xpath("//*[@id='BillingNewAddress_Address1']"));
        aksiyonlar.moveToElement(adress1).click().sendKeys("Şehitkamil").build().perform();


        WebElement adress2 = driver.findElement(By.xpath("//*[@id='BillingNewAddress_Address2']"));
        aksiyonlar.moveToElement(adress2).click().sendKeys("Fatih").build().perform();


        WebElement zip = driver.findElement(By.xpath("//*[@id='BillingNewAddress_ZipPostalCode']"));
        aksiyonlar.moveToElement(zip).click().sendKeys("24325").build().perform();


        WebElement phone = driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"));
        aksiyonlar.moveToElement(phone).click().sendKeys("0345655555").build().perform();


        WebElement fax = driver.findElement(By.xpath("//*[@id='BillingNewAddress_FaxNumber']"));
        aksiyonlar.moveToElement(fax).click().sendKeys("4343").build().perform();

        MyFunc.Bekle(10);
        WebElement continueButton = driver.findElement(By.xpath("//*[@onclick='Billing.save()']"));
        aksiyonlar.moveToElement(continueButton).click().build().perform();
        MyFunc.Bekle(2);


        WebElement continue2 = driver.findElement(By.xpath("//*[@onclick='Shipping.save()']"));
        aksiyonlar.moveToElement(continue2).click().build().perform();
        MyFunc.Bekle(2);


        WebElement continue3 = driver.findElement(By.xpath("//*[@onclick='ShippingMethod.save()']"));
        aksiyonlar.moveToElement(continue3).click().build().perform();
        MyFunc.Bekle(2);


        WebElement continue4 = driver.findElement(By.xpath("//*[@onclick='PaymentMethod.save()']"));
        aksiyonlar.moveToElement(continue4).click().build().perform();
        MyFunc.Bekle(2);


        WebElement continue5 = driver.findElement(By.xpath("//*[@onclick='PaymentInfo.save()']"));
        aksiyonlar.moveToElement(continue5).click().build().perform();
        MyFunc.Bekle(2);


        WebElement continue6 = driver.findElement(By.xpath("//*[@onclick='ConfirmOrder.save()']"));
        aksiyonlar.moveToElement(continue6).click().build().perform();
        MyFunc.Bekle(2);

        MyFunc.Bekle(2);
        WebElement success = driver.findElement(By.xpath("//*[text()='Your order has been successfully processed!']"));
        Assert.assertTrue("Sipariş tamamlanamadı", success.getText().equals("Your order has been successfully processed!"));

        BekleKapat();


    }
}

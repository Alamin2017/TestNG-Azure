package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import utils.ElementActions;

import java.util.List;

public class ProductPage  {
    public  WebDriver driver;
    public ProductPage(WebDriver driver)
    {
        this.driver=driver;
    }
    By product1=By.xpath("//img[@alt='Hummingbird printed t-shirt']");
    public void product_one_click() throws InterruptedException {
        ElementActions ele=new ElementActions(driver);
        ele.click_Element(product1);
    }
    By title_product1=By.xpath("//*[@id=\"main\"]/div[1]/div[2]/h1");
    public String product_one_title() throws InterruptedException {
        ElementActions ele=new ElementActions(driver);
        return ele.get_text_Element(title_product1);
    }
    By login_button=By.xpath("//span[normalize-space()='Sign in']");
    public void click_login_button() throws InterruptedException {
        ElementActions ele=new ElementActions(driver);
        ele.click_Element(login_button);
    }
    By Email_text=By.xpath("//label[normalize-space()='Email']");
    public String Email_text() throws InterruptedException {
        ElementActions ele=new ElementActions(driver);
        return ele.get_text_Element(Email_text);
    }
    By submit_login_button=By.xpath("//button[@id='submit-login']");

    public boolean submit_Login_button() throws InterruptedException {
        ElementActions ele=new ElementActions(driver);
        return ele.doDisplayed(submit_login_button);

    }
    By username=By.xpath("//input[@class='form-control']");
    public void doEnterUserValue(String value) throws InterruptedException {
        ElementActions ele=new ElementActions(driver);
        ele.doEnterValue(username,value);
    }
    By all_product_info=By.xpath("//*[@id=\"content\"]/section/div/article/div");
    public List<WebElement> Multiple_product_List()
    {
        ElementActions ele=new ElementActions(driver);
        return ele.getElements(all_product_info);
    }
}

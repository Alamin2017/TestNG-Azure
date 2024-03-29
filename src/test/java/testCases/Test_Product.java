package testCases;
import Envpage.BaseEnv;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ProductPage;
public class Test_Product extends BaseEnv {
    ProductPage pp;
    @Test(priority = 1)
    public void test_product_title_text() throws InterruptedException
    {

        driver.get("http://teststore.automationtesting.co.uk/");
        Thread.sleep(5000);
        pp=new ProductPage(driver);
        pp.product_one_click();
        String get_title=pp.product_one_title();
        Assert.assertEquals(get_title,"HUMMINGBIRD PRINTED T-SHIRT");
        Allure.description("Click on Product one  and verify title Text");
        Thread.sleep(5000);
    }
    @Test(priority = 2)
    public void test_login() throws InterruptedException
    {
        driver.get("http://teststore.automationtesting.co.uk/");
        Thread.sleep(5000);
        pp=new ProductPage(driver);
        pp.click_login_button();
        Thread.sleep(5000);
        String email=pp.Email_text();
        System.out.println("Email text : "+email);
        Assert.assertEquals(email,"Email");
        boolean isDisplayed=pp.submit_Login_button();
        System.out.println("Submit login button Exist : "+isDisplayed);
        Assert.assertTrue(isDisplayed);
        pp.doEnterUserValue("Al-Amin");
        Thread.sleep(5000);

    }
    @Test(priority = 3)
    public void test_all_product_count() throws InterruptedException
    {
        driver.get("http://teststore.automationtesting.co.uk/");
        Thread.sleep(5000);
        pp=new ProductPage(driver);
        int product_count=pp.Multiple_product_List().size();
        for (int i=0;i<product_count;i++)
        {
            System.out.println("Product["+(i+1)+"]:"+pp.Multiple_product_List().get(i).getText());
        }
        System.out.println("ALl Product:"+product_count);
        Assert.assertEquals(8,product_count);

    }

}
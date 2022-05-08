package testng;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class Test1 {

    String url = "https://opencart.abstracta.us/";

    By lMyAccount =By.cssSelector("a[title='My Account']");
    By lLoginLink = By.xpath("//a[text()='Login']");
    By lInputEmail = By.id("input-email");
    By lInputPassword = By.id("input-password");
    By lSubmitButton = By.xpath("//input[@value='Login']");



    @Test
    public void test_login(){

        Configuration.browser ="firefox";
        Configuration.browserSize ="800x700";
        open(url);
        $(lMyAccount).shouldBe(Condition.visible).click();
        $(lLoginLink).shouldBe(Condition.visible).click();
        $(lInputEmail).shouldBe(Condition.visible).setValue("ZeydinToprak@hotmail.com");
        $(lInputPassword).shouldBe(Condition.enabled).setValue("123456");
        $(lSubmitButton).click();
        /*
        $$("ul.nav.navbar-nav>li")
                .filter(Condition.exactOwnText("*Comp.*"))
                .shouldBe(CollectionCondition.size(1));

                --> önüne yıldız koyduğumuzda önünde birden fazla karakter olabilir
                --> önüne veya arkasina nokta ve yildiz koydugumuzda önünde veya arkasinda herhangibir karakter olabilir.
         */

     //   $(By.xpath("//a[text()='Contact us']")).scrollIntoView(true).screenshot();

        By lMenu = By.cssSelector("ul.nav.navbar-nav>li");
        int num = $$(lMenu).size();

        for (int i = 0; i < num; i++) {
            $(lMenu,i).hover().screenshot();
            Selenide.refresh();
        }



      /*
        for (SelenideElement element : $$("ul.nav.navbar-nav>li")) {
            element.hover();
            sleep(100);
        }

       */


    }

}

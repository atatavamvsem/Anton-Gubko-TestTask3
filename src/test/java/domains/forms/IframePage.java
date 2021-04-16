package domains.forms;

import domains.elements.Label;
import org.examples.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class IframePage extends BaseForm {
    private static Label labelPage = new Label(By.xpath("//div[@id='content']//h3"), "idPage");
    private WebDriverManager instance = WebDriverManager.getInstance();
    private WebDriver driver;

    public IframePage() {
        super(labelPage, "idPage");
    }

    public void switchIframe() {
        Actions actionProvider = new Actions(driver);
        WebElement iframe = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//body[@id='tinymce']//p")).click();

        actionProvider.sendKeys("qwerty").build().perform();
        actionProvider.keyDown(Keys.CONTROL).sendKeys("a").build().perform();
        actionProvider.sendKeys(Keys.SPACE).build().perform();
        actionProvider.sendKeys(Keys.valueOf("sd")).build().perform();
        //driver.switchTo().defaultContent();
        //driver.findElement(By.xpath("//button[@title='Bold']")).click();
        //button[@title='Bold']
        //driver.switchTo().frame(iframe);

        driver.findElement(By.xpath("//body[@id='tinymce']//p")).click();
        actionProvider.sendKeys("qwerty").build().perform();
        driver.findElement(By.xpath("//body[@id='tinymce']//p")).sendKeys("as");
        System.out.println("s");
    }
}

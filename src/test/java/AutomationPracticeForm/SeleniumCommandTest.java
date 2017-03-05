package AutomationPracticeForm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamster on 3/4/2017.
 */
public class SeleniumCommandTest {
    WebDriver driver;

    @Before

    public void openAutomationPracticeForm(){

        File path_to_exe = new File("C:\\Users\\Hamster\\Desktop\\FirefoxPortable\\FirefoxPortable.exe");
        FirefoxBinary firefox_exe= new FirefoxBinary(path_to_exe);

        FirefoxProfile empty_profile = new FirefoxProfile();

        driver = new FirefoxDriver(firefox_exe,empty_profile);

        driver.get("http://toolsqa.com/automation-practice-form/");


    }



    @After
    public  void closeAutomationPracticeForm(){

        driver.quit();

    }


    @Test
    public void seleniumCommandUsabilityTest(){

        WebElement commands= driver.findElement(By.id("selenium_commands"));

        //check type
        Assert.assertEquals("select",commands.getTagName());

        Select commands_select = new Select(commands);

        //check multipleselect
        Assert.assertTrue(commands_select.isMultiple());

        //check nothing choose
        List<WebElement> selected = commands_select.getAllSelectedOptions();
        Assert.assertEquals(selected.size(),0);

        //check options order
        ArrayList<String> expected_commands= new ArrayList<String>();
        expected_commands.add("Browser Commands");
        expected_commands.add("Navigation Commands");
        expected_commands.add("Switch Commands");
        expected_commands.add("Wait Commands");
        expected_commands.add("WebElement Commands");

        ArrayList<String> actual_commands = new ArrayList<String>();

        for (WebElement option:commands_select.getOptions()
             ) {
            actual_commands.add(option.getText());
        }

        Assert.assertEquals(actual_commands,expected_commands);

        //check size
        int one_option_size=20;
        Assert.assertTrue(one_option_size*5>commands.getSize().getHeight());

    }

    @Test
    public void seleniumCommandReactionTest(){
        WebElement commands= driver.findElement(By.id("selenium_commands"));

        Select commands_select = new Select(commands);
        commands_select.deselectAll();


        //arrange
        ArrayList<String> expected_commands= new ArrayList<String>();
        expected_commands.add("Navigation Commands");
        expected_commands.add("Wait Commands");


        //act
        commands_select.selectByIndex(1);
        commands_select.selectByVisibleText("Wait Commands");

        ArrayList<String> actual_commands = new ArrayList<String>();

        for (WebElement option:commands_select.getAllSelectedOptions()
                ) {
            actual_commands.add(option.getText());
        }

        //assert
        Assert.assertEquals(actual_commands,expected_commands);

    }
}

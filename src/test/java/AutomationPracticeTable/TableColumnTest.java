package AutomationPracticeTable;

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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamster on 3/4/2017.
 */
public class TableColumnTest {
    WebDriver driver;

    @Before

    public void openAutomationPracticeForm(){

        File path_to_exe = new File("C:\\Users\\Hamster\\Desktop\\FirefoxPortable\\FirefoxPortable.exe");
        FirefoxBinary firefox_exe= new FirefoxBinary(path_to_exe);

        FirefoxProfile empty_profile = new FirefoxProfile();

        driver = new FirefoxDriver(firefox_exe,empty_profile);

        driver.get("http://toolsqa.com/automation-practice-table/");


    }



    @After
    public  void closeAutomationPracticeForm(){

        //driver.quit();

    }

    @Test
    public void columnCityTest(){


        List<WebElement> columnt_city =driver.findElements(By.xpath("//tbody/tr/td[2]"));


        ArrayList<String> expected_cities= new ArrayList<String>();

        expected_cities.add("Dubai");
        expected_cities.add("Mecca");
        expected_cities.add("Taipei");
        expected_cities.add("Shanghai");

        ArrayList<String> actual_cities= new ArrayList<String>();

        for (WebElement cell:columnt_city
             ) {
            actual_cities.add(cell.getText());
        }

        Assert.assertEquals(actual_cities,expected_cities);
    }


}

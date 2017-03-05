package AutomationPracticeForm;

import com.sun.glass.ui.Size;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.*;

/**
 * Created by Hamster on 3/4/2017.
 */
public class UserProfileTest {
    // var

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
    public void testPageLoad(){

    }

    // ---------------Test first name and last name fields------------------

    @Test
    public void firstNameLastNameStringFormatTest(){

        List<WebElement> textboxes = driver.findElements(By.cssSelector("div[id='content'] form fieldset div input[type='text']"));

        String message = "Testtest";
        String expected_message ="Testtest";

        for (WebElement textbox:textboxes
             ) {

            textbox.sendKeys(message);

            String actual_message = textbox.getAttribute("value");
            String assert_message ="Textbox with name "+ textbox.getAttribute("name")+ " was tested. Expected: "+expected_message+" but actual: "+actual_message;

            Assert.assertEquals(assert_message,expected_message,actual_message);
        }
    }

    @Test
    public void firstNameLastNameNumberFormatTest(){

        List<WebElement> textboxes = driver.findElements(By.cssSelector("div[id='content'] form fieldset div input[type='text']"));

        String message = "Test12345test";
        String expected_message ="Testtest";

        for (WebElement textbox:textboxes
                ) {

            textbox.sendKeys(message);

            String actual_message = textbox.getAttribute("value");
            String assert_message ="Textbox with name "+ textbox.getAttribute("name")+ " was tested. Expected: "+expected_message+" but actual: "+actual_message;

            Assert.assertEquals(assert_message,expected_message,actual_message);
        }
    }


    @Test
    public void firstNameLastNameSpecialsFormatTest(){

        List<WebElement> textboxes = driver.findElements(By.cssSelector("div[id='content'] form fieldset div input[type='text']"));

        String message = "Test!@#$%^&test";
        String expected_message ="Testtest";

        for (WebElement textbox:textboxes
                ) {

            textbox.sendKeys(message);

            String actual_message = textbox.getAttribute("value");
            String assert_message ="Textbox with name "+ textbox.getAttribute("name")+ " was tested. Expected: "+expected_message+" but actual: "+actual_message;

            Assert.assertEquals(assert_message,expected_message,actual_message);
        }
    }


    @Test
    public void firstNameLastNameFormatTest(){

        List<WebElement> textboxes = driver.findElements(By.cssSelector("div[id='content'] form fieldset div input[type='text']"));


        ArrayList<String> messages = new ArrayList<String>();
        ArrayList<String> expected_messages = new ArrayList<String>();

        //case 1 for string
        messages.add("Test");
        expected_messages.add("Test");


        //case 2 for numbers
        messages.add("Test1234test");
        expected_messages.add("Test1234test"); //should be Testtest

        //case 3 for specials
        messages.add("Test!@$%^test");
        expected_messages.add("Test!@$%^test"); //should be Testtest

        //case 4 for specials
        messages.add("Te12st!@12$%^te12st");
        expected_messages.add("Te12st!@12$%^te12st"); //should be Testtest


        //case 5 for specials
        messages.add("Te12st!@12$%^te12stqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        expected_messages.add("Te12st!@12$%^te12stqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq"); //should be Testtestqqqqqqqqqqqqqqq not more 22 symbols

        for (WebElement textbox:textboxes
                ) {

            int index=0;

            for (int i=0; i<messages.size();i++) {

                String message = messages.get(i);
                String expected_message = expected_messages.get(i);


                // type text
                textbox.sendKeys(message);
                // read text
                String actual_message = textbox.getAttribute("value");
                // clear text
                textbox.clear();

                String assert_message = "Textbox with name " + textbox.getAttribute("name") + " was tested. Expected: " + expected_message + ". Actual: " + actual_message;

                Assert.assertEquals(assert_message, expected_message, actual_message);

            }
        }


    }


    @Test
    public void firstNameLastNameUsabilityTest(){
        List<WebElement> textboxes = driver.findElements(By.cssSelector("div[id='content'] form fieldset div input[type='text']"));


        Dimension size = textboxes.get(0).getSize();

        int y=textboxes.get(0).getLocation().getY();


        for (WebElement textbox:textboxes
                ) {

            // is enabled
            String assert_message ="Textbox with name "+ textbox.getAttribute("name")+ " was disabled";
            Assert.assertTrue(assert_message,textbox.isEnabled());

            // is displayed
            assert_message ="Textbox with name "+ textbox.getAttribute("name")+ " was invisible";
            Assert.assertTrue(assert_message,textbox.isDisplayed());

            // is same size
            assert_message ="Textbox with name "+ textbox.getAttribute("name")+ " have size: "+textbox.getSize().toString()+ "but should be "+size.toString();
            Assert.assertEquals(assert_message,size,textbox.getSize());


            // is horizontal alignment
            assert_message ="Textbox with name "+ textbox.getAttribute("name")+ " have y coordinate: "+textbox.getLocation().getY()+ "but should be "+y;
            Assert.assertEquals(assert_message,y,textbox.getLocation().getY());

        }


    }

    //------------------------------------Test datepicker---------------------------

    @Test
    public void dateFormatTest(){

        WebElement datepicker = driver.findElement(By.id("datepicker"));

        ArrayList<String> messages = new ArrayList<String>();
        ArrayList<String> expected_messages = new ArrayList<String>();

        //case 1 for string
        messages.add("Test");
        expected_messages.add("Test"); //should be null

        //case 2 for numbers
        messages.add("Test1234test");
        expected_messages.add("Test1234test"); //should be null

        //case 3 for specials
        messages.add("Test!@$%^test");
        expected_messages.add("Test!@$%^test"); //should be null

        //case 4 for specials
        messages.add("Te12st!@12$%^te12st");
        expected_messages.add("Te12st!@12$%^te12st"); //should be null


        //case 5 for specials
        messages.add("Te12st!@12$%^te12stqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        expected_messages.add("Te12st!@12$%^te12stqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq"); //should be null

        //case 6 for date
        messages.add("10/10/2016");
        expected_messages.add("10/10/2016"); //should be null

        for (int i=0; i<messages.size();i++){
            String message = messages.get(i);
            String expected_message = expected_messages.get(i);


            // type text
            datepicker.sendKeys(message);
            // read text
            String actual_message = datepicker.getAttribute("value");
            // clear text
            datepicker.clear();

            String assert_message = "Datepicker was tested. Expected: " + expected_message + ". Actual: " + actual_message;

            Assert.assertEquals(assert_message, expected_message, actual_message);

        }

    }

    @Test
    public void dateUsabilityTest(){

        WebElement datepicker = driver.findElement(By.id("datepicker"));

        // is enabled
        String assert_message ="Datepicker was disabled";
        Assert.assertTrue(assert_message,datepicker.isEnabled());

        // is displayed
        assert_message ="Datepicker was invisible";
        Assert.assertTrue(assert_message,datepicker.isDisplayed());


        WebElement textbox = driver.findElement(By.cssSelector("input[name='firstname']"));
        int x= textbox.getLocation().getX();

        // is vertical alignment
        assert_message ="Datepicker have y coordinate: "+datepicker.getLocation().getX()+ " but should be "+x;
        Assert.assertEquals(assert_message,x,datepicker.getLocation().getX());


    }

    //--------------Test sex---------------------------

    @Test
    public void sexUsabilityTest(){
        List<WebElement> radios = driver.findElements(By.cssSelector("input[id*='sex']"));



        ArrayList<String> expected_sex = new ArrayList<String>();
        expected_sex.add("Male");
        expected_sex.add("Female");


        ArrayList<String> actual_sex=new ArrayList<String>();

        //check type and collect values
        for (WebElement radio:radios
             ) {
            // check type
            Assert.assertEquals("radio",radio.getAttribute("type"));

            // is enabled
            Assert.assertTrue(radio.isEnabled());

            // is displayed
            Assert.assertTrue(radio.isDisplayed());

            //is unchecked
            Assert.assertFalse(radio.isSelected());


            actual_sex.add(radio.getAttribute("value"));
        }

        Assert.assertEquals(expected_sex,actual_sex);


        // check horizontal alignment
        Assert.assertEquals(radios.get(0).getLocation().getY(),radios.get(1).getLocation().getY());



    }


    //------------Test continent----------------------------

    @Test
    public void continentUsabilityTest(){

        WebElement continents =driver.findElement(By.id("continents"));

        Select continets_select = new Select(continents);

        //check if it is combobox
        Assert.assertEquals("select",continents.getTagName());

        // is enabled
        Assert.assertTrue(continents.isEnabled());

        // is displayed
        Assert.assertTrue(continents.isDisplayed());

        // is not multyselect
        Assert.assertFalse(continets_select.isMultiple());

        //check list of options
        ArrayList<String> expected_options= new ArrayList<String>();
        expected_options.add("Asia");
        expected_options.add("Europe");
        expected_options.add("Africa");
        expected_options.add("Australia");
        expected_options.add("South America");
        expected_options.add("North America");
        expected_options.add("Antartica");



        List<WebElement> options = continets_select.getOptions();

        ArrayList<String>actual_options = new ArrayList<String>();
        for (WebElement option:options
             ) {
            actual_options.add(option.getText());
        }



        Assert.assertEquals(actual_options,expected_options);

    }
}

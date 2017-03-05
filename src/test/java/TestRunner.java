import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import AutomationPracticeTable.*;

/**
 * Created by Hamster on 3/4/2017.
 */
public class TestRunner {
    public  static  void main(String[] args){

        Result result = JUnitCore.runClasses(AutomationPracticeForm.SuiteTest.class,TableColumnTest.class);

        for(Failure failure : result.getFailures()){


            System.out.println(failure.toString());

        }


        System.out.print("Suite complited");
    }
}

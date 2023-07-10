import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class PersonTest {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Teenager test started");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("Teenager test done");
    }

    @DataProvider(name = "ageTest")
    Object[][] teenagerProvider(){
        return new Object[][]{
                {0, false},
                {5, false},
                {12, false},
                {13, true},
                {14, true},
                {16, true},
                {18, true},
                {19, true},
                {20, false},
                {30, false}
        };
    }

    @Test(dataProvider = "ageTest")
    public void testisTeenager(int age, boolean expectedResult) {
        boolean result = Person.isTeenager(age);
        if (result == false)  {
            if (age > 19) {
                System.out.println(age + " - это уже не тинейджер");}
            if (age < 13) {
                System.out.println(age + " - это еще не тинейджер");
            }
        } else {
            System.out.println(age + " - это тинейджер");
        }
        assertEquals(result, expectedResult);
    }
}

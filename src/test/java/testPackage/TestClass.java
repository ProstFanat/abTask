package testPackage;

import org.testng.annotations.*;

public class TestClass {

    @BeforeClass
    void beforeAll(){

    }

    @Test
    void startTest(){
        System.out.println("Test");
    }
}

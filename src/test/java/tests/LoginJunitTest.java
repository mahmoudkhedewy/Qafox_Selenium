package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LoginJunitTest {


//    @BeforeAll
//    public static void setDriver(){
//        System.out.println("Driver is set");
//    }
//
//    @BeforeEach
//    public void beforeEachTest(){
//        System.out.println("This runs before each test");
//    }
//
//
//    @Test
//    @DisplayName("test 1")
//     void sampleTest() {
//        System.out.println("This is a sample JUnit test.");
//    }
//
//    @AfterEach
//    public void afterEachTest(){
//        System.out.println("This runs after each test");
//    }
//    @AfterAll
//    public static void closeDriver(){
//        System.out.println("Driver is closed");
//    }

    @ParameterizedTest(name = "Run {index} with value:{arguments}")
    @ValueSource(ints = {1,2,3,4,5})
    void testWithValueSource(int argument) {
        System.out.println("Parameterized test with argument: " + argument);
    }
}

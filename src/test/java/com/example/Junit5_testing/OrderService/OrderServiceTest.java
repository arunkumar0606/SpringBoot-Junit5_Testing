package com.example.Junit5_testing.OrderService;

import com.example.Junit5_testing.service.OrderService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;


public class OrderServiceTest {


    @BeforeAll
    public static void ba(){
        System.out.println("Test is going to Start");
    }

    @BeforeEach
    public void be(){
        System.out.println("----------Test Started");
    }

    @AfterAll
    public static void al(){
        System.out.println("All Test Ended !");
    }

    @AfterEach
    public void ae(){
        System.out.println("--------Test Ended");
    }

    @Test
    @DisplayName("Test for assertEquals")
    public void AddOrderTest(){
        OrderService orderService=new OrderService();
        assertEquals(orderService.totalOrder(1,2),3);
    }

    @Test
    @DisplayName("Test for assertFalse")
    public void CostlyOrderTest(){
        OrderService orderService=new OrderService();
        assertFalse(orderService.isCostly(90));
    }

    @Test
    @DisplayName("Test for assertTrue")
    public void CostlyOrderTest1(){
        OrderService orderService=new OrderService();
        assertTrue(orderService.isCostly(190));
    }

    @Test
    @DisplayName("Test for assertNull")
    public void nullTest(){
        OrderService orderService=new OrderService();
        assertNull(orderService.isGood(999));
    }

    @Test
    @DisplayName("Test for assumeTrue")
    public void assumeTrueTest(){
        int value=10;
        OrderService orderService=new OrderService();
        assumeTrue(value>5);
        assertEquals(orderService.subTractOrder(1,2),1);
    }

    @Test
    @DisplayName("Test for assumeFalse")
    public void assumeFalseTest(){
        int value=100;
        OrderService orderService=new OrderService();
        assumeFalse(value<5);
        assertEquals(orderService.subTractOrder(1,2),1);
    }
    @Test
    @Tag("Super")
    @DisplayName("Test for assumingThat")
    public void assumingThatTest(){
        int value=100;
        OrderService orderService=new OrderService();
        assumingThat(value>5,()->System.out.println("This Value will be executed only if the condition is true "+value*value));
        assertEquals(orderService.subTractOrder(1,2),1);
    }


    @DisplayName("Test for @Parameterized test")
    @ParameterizedTest
    @MethodSource("provideParams")
    public void multipleParamTest(int a,int b){
        OrderService orderService=new OrderService();
        assertEquals(orderService.multipleOrder(a,b),2);
    }

    static Stream<Object[]> provideParams() {
        return Stream.of(
                new Object[]{1, 2},
                new Object[]{2, 1},
                new Object[]{5, 6}
        );
    }

    @TestFactory
    @DisplayName("Dynamic Test")
    Collection<DynamicTest> dynamicTestsFromCollection() {
        OrderService orderService=new OrderService();
        return Arrays.asList(
                dynamicTest("Add test", () ->    assertEquals(orderService.totalOrder(1,2),3)),
                dynamicTest("Subtract test", () -> assertEquals(orderService.subTractOrder(1,2),3))
        );
    }

    @Test
    @DisplayName("Test for @Disabled")
    @Disabled("Need to add more logic")
    public void MultiplyOrderTest(){
        OrderService orderService=new OrderService();
        assertEquals(orderService.multipleOrder(1,2),2);
    }
}

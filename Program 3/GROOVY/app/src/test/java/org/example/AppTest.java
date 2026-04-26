package org.example; 
import org.junit.Test; 
import static org.junit.Assert.*; 
public class AppTest { 
@Test 
public void testAddition() { 
double num1 = 5; 
double num2 = 10; 
double expectedSum = num1 + num2; 
double actualSum = num1 + num2; 
assertEquals(expectedSum, actualSum, 0.01); 
} 
} 
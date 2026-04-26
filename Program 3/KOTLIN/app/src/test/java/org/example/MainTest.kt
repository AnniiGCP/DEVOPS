package org.example 
import org.junit.Assert.* 
import org.junit.Test 
class MainTest { 
@Test 
fun testAddNumbers() { 
val num1 = 10.0 
val num2 = 5.0 
val result = addNumbers(num1, num2) 
assertEquals("The sum of $num1 and $num2 should be 15.0", 15.0, result, 0.001) 
} 
} 
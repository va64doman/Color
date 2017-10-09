/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing.Packages;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;
import colours.*;

/**
 *
 * @author Van Do
 */
public class ColorTest 
{
    ColorParser parse = new ColorParser();
    
    public ColorTest() 
    {
        
    }
    
    public List<ColorRainbow> testList()
    {
        List<ColorRainbow> color = new ArrayList<>();
        color.add(new ColorRainbow("red", "#FF0000", new int[]{255,0,0,1}));
        color.add(new ColorRainbow("green", "#00FF00", new int[]{0,255,0,1}));
        return color;
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void checkIfListIsNotEmpty()
    {
        // Test to see if list is empty
        assertFalse(testList().isEmpty());
    }
    
    @Test
    public void checkIfJsonStringIsNotEmpty()
    {
        // Test to see if list can be converted to JSON string
        List<ColorRainbow> list = testList();
        String jsonString = parse.serializeColours(list);
        assertTrue(jsonString.length() != 0);
    }
    
    @Test
    public void checkIfJsonStringCanConvertToList()
    {
        // Test to see Json string can be converted to list and match with list before
        List<ColorRainbow> list = testList();
        String jsonString = parse.serializeColours(list);
        List<ColorRainbow> deserialize = parse.deserializeColours(jsonString);
        assertTrue("Both lists should be same when deserialize.", list.get(0).getName().equals(deserialize.get(0).getName()));
        assertTrue("Both lists should be same when deserialize.", list.get(1).getName().equals(deserialize.get(1).getName()));
    }


}

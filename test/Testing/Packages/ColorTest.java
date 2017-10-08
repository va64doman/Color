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
        assertFalse(testList().isEmpty());
    }
    
    @Test
    public void checkIfJsonStringIsNotEmpty()
    {
        List<ColorRainbow> list = new ArrayList<>();
        String jsonString = parse.serializeColours(list);
        assertFalse(jsonString.length() != 0);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

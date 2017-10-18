/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing.Packages;

import java.util.*;
import static org.junit.Assert.*;
// Access project
import colours.*;
import org.junit.*;

/**
 *
 * @author Van Do
 */
public class ColorTest 
{
    // Access ColorParser class method
    ColorParser parse = new ColorParser();
    // Access ReadFile class method
    ReadFile file = new ReadFile();
    // Localise list of ColorRainbow objects
    List<ColorRainbow> list, json, deserialize;
    // Initialise list of ColorRainbow objects
    List<ColorRainbow> empty = new ArrayList<>();
    // Localise string
    String serialize;
    
    @Before
    public void checkIfFileExist()
    {
        // Read file before test methods
        // Check if enable to read both text file and JSON formatted file
        list = file.getFromTextFile("Colors.txt");
        json = file.getFromJsonFile("ColorJson.txt");
        // Check that both lists are not null
        assertNotNull("List is not empty when read text file.", list);
        assertNotNull("List is not empty when read JSON format file", json);
    }
    
    @Ignore
    public void checkIfFileDoesNotExist()
    {
        // Check if enable to read both text file and JSON formatted file
        // This test is ignored as been tested already
        list = file.getFromTextFile("Nonfile.txt");
        json = file.getFromJsonFile("Nonfile.txt");
        // Check that both lists are not null, should display as fail test
        assertNotNull("List is not empty when read text file.", list);
        assertNotNull("List is not empty when read JSON format file", json);
    }
    
    @Test
    public void checkIfListNotEmpty()
    {
        // Check if the list is not empty
        assertFalse(list.isEmpty());
        assertFalse(json.isEmpty());
    }
    
    @Test
    public void checkSerializeIntoJsonString()
    {
        // Check if the list can be converted into JSON string
        serialize = parse.serializeColours(list);
        System.out.println(serialize);
        // It should not display empty JSON string
        assertFalse("JSON string is empty.", serialize.equals("[]"));
    }
    
    @Ignore
    public void checkJsonStringIsNotEmpty()
    {
        // Check if list can be converted into JSON and should not be empty
        serialize = parse.serializeColours(empty);
        System.out.println(serialize);
        // Display test failed as JSON string is empty since list is empty
        assertFalse("JSON string is empty.", serialize.equals("[]"));
    }
    
    @After
    public void checkDeserializeIntoListOfColorRainbow()
    {
        // Display results after test
        // Even though it does catch null pointer exception.
        // This test focues on JSON string be able to convert to list of ColorRainbow objects
        // Convert JSON string to list of ColorRainbow objects
        deserialize = parse.deserializeColours(serialize);
        // Loop all list's elements and display on test
        for(int count = 0; count < deserialize.size(); count++)
        {
            if(deserialize.get(count) != null)
            {
                System.out.print(deserialize.get(count).getName() + " ");
                System.out.print(deserialize.get(count).getHexCode() + " ");
                System.out.print(Arrays.toString(deserialize.get(count).getRGBA()));
                System.out.println();
            }
        }
        // Should be false since list is not empty
        assertFalse("JSON string was unable to convert into list.", list.isEmpty());
    }
}

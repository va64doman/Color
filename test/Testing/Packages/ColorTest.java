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
// Use Color methods to test if enable to convert hex code to color
import java.awt.Color;
// Use FileNotFoundException to test existence of file
import java.io.*;
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
    List<ColorRainbow> list, json;
    // Initialise list of ColorRainbow objects
    List<ColorRainbow> empty = new ArrayList<>();
    // Localise string
    String serialize;
    // Check if file exists before testing
    @Before
    public void checkIfFileExist()
    {
        // Read file before test methods
        // Check if enable to read both text file and JSON formatted file
        list = file.getFromTextFile("Colors.txt");
        json = file.getFromJsonFile("ColorJson.txt");
    }
    // Ignore non existence file test
    @Ignore("Have already tested.")
    public void checkIfFileDoesNotExist()
    {
        // Check if enable to read both text file and JSON formatted file
        // This test is ignored as been tested already
        List<ColorRainbow> emptyList = file.getFromTextFile("Nonfile.txt");
        List<ColorRainbow> emptyJson = file.getFromJsonFile("Nonfile.txt");
        // Check that both lists are not null, should display as fail test
        assertTrue("List is empty when read text file.", emptyList.isEmpty());
        assertTrue("List is empty when read JSON format file", emptyJson.isEmpty());
    }
    // Test if the list is not empty when read files
    @Test
    public void checkIfListNotEmpty()
    {
        // Check if the list is not empty
        assertFalse(list.isEmpty());
        assertFalse(json.isEmpty());
    }
    // Test if be able to convert list into JSON string
    @Test
    public void checkSerializeIntoJsonString()
    {
        // Check if the list can be converted into JSON string
        serialize = parse.serializeColours(list);
        System.out.println(serialize);
        // It should not display empty JSON string
        assertFalse("JSON string is empty.", serialize.equals("[]"));
    }
    // Ignore empty JSON string test
    @Ignore("Have already tested.")
    public void checkJsonStringIsEmpty()
    {
        // This test is ignore as tested already
        // Check if list can be converted into JSON and should not be empty
        serialize = parse.serializeColours(empty);
        System.out.println(serialize);
        // Display test failed as JSON string is empty since list is empty
        assertEquals("JSON string is empty.", "[]", serialize);
    }
    // Test if convert JSON string to list is successful
    @Test
    public void checkDeserializeIntoListNotEmpty()
    {
        // Check if enable to convert JSON string to list and ensure list is not empty
        serialize = parse.serializeColours(list);
        List<ColorRainbow> deserialize = parse.deserializeColours(serialize);
        assertNotNull("List is not empty", deserialize);
    }
    // Ignore inverse operation from serialization test
    @Ignore("Have already tested.")
    public void checkDeserializeEmptyJsonStringIntoListEmpty()
    {
        // This test ignored as tested already
        // Check if convert empty JSON string to list is given empty list
        List<ColorRainbow> deserialize = parse.deserializeColours("[]");
        assertTrue("List is not empty", deserialize.isEmpty());
    }
    // Ignore checking exception test
    @Ignore("Have already tested.")
    public void readFileThatContainsMissingOrMistakenValues()
    {
        // Test if the file exists but read have problems compared from the variable requirements
        // from ColorRainbow
        List<ColorRainbow> errorList = file.getFromJsonFile("Fail Color.json");
    }
    // Test if the conversion between hex code to color is successful
    @Test
    public void convertHexCodeToColor()
    {
        // Display in red, green and blue format
        Color convertedColor = Color.decode(list.get(0).getHexCode());
        System.out.println(convertedColor);
        assertNotNull("The hex code to color conversion is successful", convertedColor);
    }
    // After the test, deserialize JSON string back to list
    @After
    public void checkDeserializeIntoListOfColorRainbow()
    {
        // Display results after test
        // This test focues on JSON string be able to convert to list of ColorRainbow objects
        // Convert JSON string to list of ColorRainbow objects
        serialize = parse.serializeColours(list);
        List<ColorRainbow> deserialize = parse.deserializeColours(serialize);
        for(int count = 0; count < deserialize.size(); count++)
        {
            System.out.print(deserialize.get(count).getName() + " ");
            System.out.print(deserialize.get(count).getHexCode() + " ");
            System.out.print(Arrays.toString(deserialize.get(count).getRGBA()));
            System.out.println();
        }
    }
}

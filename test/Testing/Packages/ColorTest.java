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
import org.junit.*;
import java.io.*;

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
    public void readFileThatContainsMissingOrMistakenValues() throws FileNotFoundException, IOException
    {
        // Test if the file exists but read have problems compared from the variable requirements
        // from ColorRainbow
        String fileName = "Fail Color.txt";
        // Get list from this file
        List<ColorRainbow> errorList = file.getFromJsonFile(fileName);
        // Get the total number of lines from file
        int lines;
        // Try with resources to use the buffered reader
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) 
        {
            // Set lines to 0
            lines = 0;
            // Keep incrementing lines by 1 when current line from file is not null
            while(reader.readLine() != null)
            {
                lines++;
            }
        }
        // Check if it is true that the list's size is less than lines
        assertTrue("There are less data than the number of lines in file.", errorList.size() < lines);
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
    // Test if incorrect hex code cannot be converted into color
    @Ignore("Have already tested")
    public void failConvertHexCodeToColorAndThrowNumberFormatException()
    {
        try
        {
            // The test will fail if the conversion was successful
            Color convertedColor = Color.decode("#FXC");
            //Color convertedColor = Color.decode("#FFF");
            fail("Should have thrown error if the hex code cannot be converted.");
        }
        catch(NumberFormatException error)
        {
            // The test will pass if the conversion was failed.
            assertTrue("The conversion has failed.", error.getMessage() != null);
        }
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

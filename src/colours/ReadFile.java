/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colours;
// Use for list to store ColorRainbow objects and return as list
import java.util.*;
// Use for reading the file
import java.io.*;
// Use for displaying message box
import javax.swing.*;
// Use for catching JSON exception
import org.json.*;

/**
 * ReadFile --- This class allows to read text file, including text file in JSON format.
 * @author Van Do
 */
public class ReadFile 
{
    // Access ColorParser methods to serialize list and deserialize JSON string
    // Use BufferedReader to read texts and buffer character
    ColorParser parse = new ColorParser();
    /**
     * Read characters from text file
     */
    private BufferedReader file;
    // Set List<ColorRainbow> to store ColorRainbow objects
    /**
     * The list of ColorRainbow objects
     * @see ColorRainbow
     */
    private List<ColorRainbow> list;
    /** This method allows to read from a text file and convert the data into a list.
     * @param fileName the name of the file you want to read from
     * @return the list of all color data
     */
    public List<ColorRainbow> getFromTextFile(String fileName)
    {
        // Read through all lines from text file
        // Initialise empty list
        list = new ArrayList<>();
        // Try and catch if file is not existed or line is incorrect
        try
        {
            // Set current line as string
            String currentLine;
            // Access stream reader class methods using the file by user input
            file = new BufferedReader(new FileReader(fileName));
            // Read the first line and set as currentLine
            currentLine = file.readLine();
            // While this line is not null
            while (currentLine != null)
            {
                // Set string arrays when spliting the line from commas
                String[] splits = currentLine.split(",");
                // Set name from splits[0]
                String name = splits[0];
                // Set hex code from splits[1]
                String hexCode = splits[1];
                // Set red from splits[2]
                int red = Integer.parseInt(splits[2]);
                // Set green from splits[3]
                int green = Integer.parseInt(splits[3]);
                // Set blue from splits[4]
                int blue = Integer.parseInt(splits[4]);
                // Set alpha from splits[5]
                int alpha = Integer.parseInt(splits[5]);
                // Set ColorRainbow object
                ColorRainbow colours = new ColorRainbow();
                // Set object's name by name
                colours.setName(name);
                // Set object's hex code by hex code
                colours.setHexCode(hexCode);
                // Set object rgba attribute by red, green, blue and alpha
                colours.setRGBA(new int[] { red, green, blue, alpha });
                // Add object to list
                list.add(colours);
                // Read the next line
                currentLine = file.readLine();
            }
        }
        // Throw error where file is not existed
        catch(FileNotFoundException ex)
        {
            System.out.println("Error message is " + ex);
            JOptionPane.showMessageDialog(null, "File does not existed.", "Unknown File", JOptionPane.INFORMATION_MESSAGE);
        }
        // Throw error where there are not enough attributes from file
        catch (IllegalArgumentException | IOException | ArrayIndexOutOfBoundsException ex)
        {
            System.out.println("Error message is " + ex);
            JOptionPane.showMessageDialog(null, "Something wrong with the data in file. Please check.", "Problem With File", JOptionPane.INFORMATION_MESSAGE);
        }
        // Throw error where the file is existed but transferring data is incorrect
        // Return list of colour
        return list;
    }
    /** Read a JSON-formatted file and deserialize the JSON string into list of ColorRainbow objects
     * @param fileName the name of the file you want to read
     * @return list of ColorRainbow objects
     */
    public List<ColorRainbow> getFromJsonFile(String fileName)
    {
        // Read JSON file and deserialize them into ColorRainbow list
        list = new ArrayList<>();
        // Try and catch if file is not existed or line is incorrect
        try
        {
            
            StringBuilder build = new StringBuilder();
            // Set current line as string
            String currentLine;
            // Access stream reader class methods using the file by user input
            file = new BufferedReader(new FileReader(fileName));
            // Read the first line and set as currentLine
            currentLine = file.readLine();
            // While this line is not null
            while (currentLine != null)
            {
                // Add character to String builder
                build.append(currentLine);
                // Check next line
                currentLine = file.readLine();
            }
            // Deserialize JSON string from file into list of colours
            list = parse.deserializeColours(build.toString());
        }
        // Throw error where file is not existed
        catch (FileNotFoundException ex)
        {
            System.out.println("Error message is " + ex);
            JOptionPane.showMessageDialog(null, "Something wrong with the data in file. Please check.", "Problem With File", JOptionPane.INFORMATION_MESSAGE);
        }
        // Throw error where line is not matched with the attribute from class
        catch (IOException | IllegalArgumentException | JSONException ex)
        {
            System.out.println("Error message is " + ex);
            JOptionPane.showMessageDialog(null, "Check if file is in JSON format.", "Problem With File", JOptionPane.INFORMATION_MESSAGE);
        }
        // Throw error if not JSON format
        // Return list of colours
        return list;
    }
}

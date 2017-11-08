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
    /** Read a JSON-formatted file and deserialize the JSON string into list of ColorRainbow objects.
     * @param fileName - the name of the file you want to read.
     * @return list of ColorRainbow objects.
     * @exception FileNotFoundException - catch errors if file does not existed.
     * @exception IOException - catch errors if input operation has failed to read.
     * @exception IllegalArgumentException - catch errors if the data from file does not match variable's requirement.
     * @exception JSONException - check if line is not in JSON format.
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

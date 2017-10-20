/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colours;
import java.util.*;
import javax.swing.*;
import org.json.*;

/**
 * ColorParser --- This class contains method to translate list of ColorRainbow objects to JSON string and back.
 * @author Van Do
 */
public class ColorParser 
{
    /**
     * Converting a list of ColorRainbow objects into a JSON string. See opposite of this method: {@link #deserializeColours}.
     * @param list - a list of ColorRainbow objects with color data.
     * @throws NullPointerException - it is thrown when it does not contains a data from key.
     * @return a converted JSON string when list of ColorRainbow objects was being translated into JSON format.
     */
    public String serializeColours(List<ColorRainbow> list) throws NullPointerException
    {
        // Create JSON array
        JSONArray array = new JSONArray();
        // Go through each color in a list
        for(ColorRainbow color : list)
        {
            // Set JSON object
            JSONObject json = new JSONObject();
            // Set JSON key, name, from color's name
            json.put("name", color.getName());
            // Set JSON key, hexCode, from color's hex code
            json.put("hexCode", color.getHexCode());
            // Set JSON key, rgba, from color's rgba
            json.put("rgba", color.getRGBA());
            // Add JSON object to JSON array
            array.put(json);
        }
        // Serialize list into JSON string format
        String jsonString = array.toString();
        // Return JSON string
        return jsonString;
    }
    /**
     * Converting a JSON string to a list of ColorRainbow objects. See opposite of this method: {@link #serializeColours }.
     * @param inputJsonString - a JSON-formatted string.
     * @exception NullPointerException - catch errors if one of the attributes of ColorRainbow objects are null.
     * @return a list of ColorRainbow objects when translated JSON string into list.
     */
    public List<ColorRainbow> deserializeColours(String inputJsonString)
    {
        // Initialize list of colours
        List<ColorRainbow> colours = new ArrayList<>();
        try
        {
            // Set JSON array from JSON string
            JSONArray array = new JSONArray(inputJsonString);
            // Iterate through each JSON object in JSON array
            for(int count = 0; count < array.length(); count++)
            {
                // Set JSON object from the element at this index in JSON array
                JSONObject json = array.getJSONObject(count);
                // Initialize colour object
                ColorRainbow color = new ColorRainbow();
                // Set colour's name from JSON object's name
                color.setName(json.getString("name"));
                // Set colour's hex code from JSON object's hex code
                color.setHexCode(json.getString("hexCode"));
                // Set JSON array of rgba attributes from a JSON array, rgba
                JSONArray rgba = json.optJSONArray("rgba");
                // Set integer array and set length as rgba attribute's length
                int[] attribute = new int[rgba.length()];
                // Iterate through each attribute from JSON array, using the key, rgba
                for(int aCount = 0; aCount < rgba.length(); aCount++)
                {
                    // Set element of attribute from rgba's element
                    attribute[aCount] = rgba.optInt(aCount);
                }
                // Set colour's rgba attribute from attribute
                color.setRGBA(attribute);
                // Add colour object to list
                colours.add(color);
            }
        }
        catch(NullPointerException error)
        {
            // Catch error if the string does not contain the requirement from colour's attribute
            System.out.println("Error message: " + error);
            JOptionPane.showMessageDialog(null, "Something wrong with data in file.", "Problem With File", JOptionPane.INFORMATION_MESSAGE);
        }
        // Return a list of colors
        return colours;
    }
}

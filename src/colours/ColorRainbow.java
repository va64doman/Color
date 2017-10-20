/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colours;

/**
 * ColorRainbow --- This class contains data of the color.
 * @author Van Do
 */
public class ColorRainbow 
{
    // Get and set colour's name
    /**
     * The name of the color.
     */
    private String name;
    // Get and set colour's hex code
    /**
     * The hexadecimal format of the color.
     */
    private String hexCode;
    // Get and set red, green, blue and alpha attritubes as integer array
    /**
     * The attribute of the color (red, green, blue and alpha).
     */
    private int[] rgba;
    // Null constructor
    /**
     * Null class constructor to access methods.
     */
    public ColorRainbow()
    {
        
    }
    // Parameterised constructor
    /**
     * Parameterized constructor to store object's color data
     * @param cName - the name of the color. See {@link #name}.
     * @param hex - the hex code of the color. See {@link #hexCode}.
     * @param attribute - the attribute of color using RGBA, (red, green, blue and alpha). See {@link #rgba}.
     */
    public ColorRainbow(String cName, String hex, int[] attribute)
    {
        name = cName;
        hexCode = hex;
        rgba = attribute;
    }
    // Getters
    /**
     * Get the name of the color. See {@link #name}.
     * @return name of the color.
     */
    public String getName()
    {
        // Return color's name
        return name;
    }
    /**
     * Get the hex code of the color. See {@link #hexCode}.
     * @return hex code format of the color.
     */
    public String getHexCode()
    {
        // Return color's hex code
        return hexCode;
    }
    /**
     * Get the red, green, blue and alpha, in order, of the color. See {@link #rgba}.
     * @return the RGBA attribute of the color.
     */
    public int[] getRGBA()
    {
        // Return color's rgba attribute
        return rgba;
    }
    // Setters
    /**
     * Set the name of the color. See {@link #name}.
     * @param cName - the name of the color.
     */
    public void setName(String cName)
    {
        // Set color's name
        name = cName;
    }
    /**
     * Set the hex code of the color. See {@link #hexCode}.
     * @param hex - the hex code of the color.
     */
    public void setHexCode(String hex)
    {
        // Set color's hex code
        hexCode = hex;
    }
    /**
     * Set the attribute of the color (RGBA). See {@link #rgba}.
     * @param attributes - the RGBA of color.
     */
    public void setRGBA(int[] attributes)
    {
        // Set color's attribute
        rgba = attributes;
    }
    
}

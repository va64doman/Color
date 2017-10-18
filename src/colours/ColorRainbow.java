/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colours;

/**
 *
 * @author Van Do
 */
public class ColorRainbow 
{
    // Get and set colour's name
    private String name;
    // Get and set colour's hex code
    private String hexCode;
    // Get and set red, green, blue and alpha attritubes as integer array
    private int[] rgba;
    // Null constructor
    /**
     * Null class constructor to access methods
     */
    public ColorRainbow()
    {
        
    }
    // Parameterized constructor
    /**
     * Parameterized constructor to store object's color data
     * @param cName the name of the color
     * @param hex the hex code of the color
     * @param attribute the attribute of color using RGBA, (red, green, blue and alpha)
     */
    public ColorRainbow(String cName, String hex, int[] attribute)
    {
        name = cName;
        hexCode = hex;
        rgba = attribute;
    }
    // Getters
    /**
     * Get the name of the color
     * @return name of the color
     */
    public String getName()
    {
        return name;
    }
    /**
     * Get the hex code of the color
     * @return hex code format of the color
     */
    public String getHexCode()
    {
        return hexCode;
    }
    /**
     * Get the red, green, blue and alpha, in order, of the color
     * @return the RGBA attribute of the color
     */
    public int[] getRGBA()
    {
        return rgba;
    }
    // Setters
    /**
     * Set the name of the color
     * @param cName the name of the color
     */
    public void setName(String cName)
    {
        name = cName;
    }
    /**
     * Set the hex code of the color
     * @param hex the hex code of the color
     */
    public void setHexCode(String hex)
    {
        hexCode = hex;
    }
    /**
     * Set the attribute of the color (RGBA)
     * @param attributes the RGBA of color
     */
    public void setRGBA(int[] attributes)
    {
        rgba = attributes;
    }
    
}

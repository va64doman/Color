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
    
    public String getName(){
        return name;
    }
    
    public String getHexCode(){
        return hexCode;
    }
    
    public int[] getRGBA(){
        return rgba;
    }
    
    public void setName(String cName){
        name = cName;
    }
    
    public void setHexCode(String hex){
        hexCode = hex;
    }
    
    public void setRGBA(int[] attributes){
        rgba = attributes;
    }
    
}

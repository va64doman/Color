/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colours;
import java.util.*;
import org.json.*;

/**
 *
 * @author Van Do
 */
public class ColorParser 
{
    public String serializeColours(List<ColorRainbow> list)
    {
        JSONArray array = new JSONArray();
        for(ColorRainbow color : list)
        {
            JSONObject json = new JSONObject();
            json.put("name", color.getName());
            json.put("hexCode", color.getHexCode());
            json.put("rgba", color.getRGBA());
            array.put(json);
        }
        // Serialize list into JSON string format
        String jsonString = array.toString();
        return jsonString;
    }

    public List<ColorRainbow> deserializeColours(String inputJsonString)
    {
        JSONArray array = new JSONArray(inputJsonString);
        List<ColorRainbow> colours = new ArrayList<>();
        for(int count = 0; count < array.length(); count++){
            JSONObject json = array.getJSONObject(count);
            ColorRainbow color = new ColorRainbow();
            color.setName(json.getString("name"));
            color.setHexCode(json.getString("hexCode"));
            JSONArray rgba = json.optJSONArray("rgba");
            int[] attribute = new int[rgba.length()];
            for(int aCount = 0; aCount < rgba.length(); aCount++)
            {
                attribute[aCount] = rgba.optInt(aCount);
            }
            color.setRGBA(attribute);
            colours.add(color);
        }
        
        return colours;
    }
}

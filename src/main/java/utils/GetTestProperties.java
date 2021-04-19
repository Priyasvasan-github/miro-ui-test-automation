package utils;

import java.util.ResourceBundle;

/**
 * Created by Sripriya Srinivasan on 10/29/2018.
 */
public class GetTestProperties {
    /**
     * This method returns the input values provided in config value
     * @param propName
     * @return the properties
     */
    public String getValue(String propName){
        ResourceBundle properties =ResourceBundle.getBundle("config");
       return properties.getString(propName);
    }
}

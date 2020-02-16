package br.com.simian.check.SimianCheck.utils;

public class UtilTransform {

	public static String stringToStringArray(String[] stringArray){
        StringBuilder builder= new StringBuilder();
        builder.append(stringArray[0]);
        for(int i=1; i<stringArray.length; i++){
            builder.append(", ").append(stringArray[i]);
        }
        return builder.toString();
    }
	
}

package utils;

public class StringManipulation {
    public static String removeLastChar(String s){
        System.out.println("remove");
        if(!(s.length() > 1)){
            return "";
        }
        return s.substring(0, s.length()-1);
    }
}

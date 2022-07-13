
package Dungchung;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Tester {
    public static boolean day(String x){
        String pattern="dd/mm/yyyy";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);
        simpleDateFormat.setLenient(false);
        try{
            simpleDateFormat.parse(x);
            return true;
        }
        catch(ParseException ex){
            return false;
        }
    }
    public static boolean numberPhone(String x){        
        try{
            String pattern="\\d{10}";
            if(x.matches(pattern )) return true;
        }
        catch(Exception ex){            
        }
        return false;
    }
}

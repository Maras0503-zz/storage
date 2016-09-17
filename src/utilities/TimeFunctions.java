/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import static java.lang.Math.round;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Marek
 */
public class TimeFunctions {
    public long timestampToLong(Timestamp time){
        long ans = time.getTime();
        return ans;
    }
    public Timestamp longToTimestamp(long number){
        Timestamp ans = new Timestamp(number);
        return ans;
    }
    public long nowTimestamp(){
    	 Date date= new Date();
	 Timestamp time = new Timestamp(date.getTime());
         long time1 = round(time.getTime()/1000);
         return time1;
    }
    public boolean passTime(long changeDate){
        long expirationTime = 0;
        expirationTime = 30*24*60*60*1000;
        boolean ans = false;
        if ((nowTimestamp()-changeDate > expirationTime)){
        }    
        return ans;
    }
    
}

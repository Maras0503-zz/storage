
package utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static utilities.TimeFunctions.nowTimestamp;
import static utilities.TimeFunctions.longToTimestamp;
/**
 *
 * @author Marek
 */
public  class FileManipulators {
    
    public static String readIp(){
        FileReader fr = null;
        String ip = "";
        try{
            fr = new FileReader("src/settings/sqlServerIp.txt");
        }   
        catch(FileNotFoundException e){
        }
        BufferedReader br = new BufferedReader(fr);
        try{
        ip = br.readLine();
        }
        catch(IOException e){
        }
        try {
            br.close();
            fr.close();
        } 
        catch (IOException e) {
        }
        return ip;
    }  
    public static void saveIp(String str){
        String ip = str;
        FileWriter fw = null;
        try {
            fw = new FileWriter("src/settings/sqlServerIp.txt");
        }
        catch(IOException e) { 
        }
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            bw.write(ip);
        }
        catch (IOException e) {
        }
        try {
            bw.close();
            fw.close();
        }
        catch (IOException e) {
        }
        
    }
    
    public static void saveLog(){
        FileWriter fw = null;
        try {
            fw = new FileWriter("src/settings/serverLog.txt", true);
        }
        catch(IOException e) { 
        }
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            bw.append(longToTimestamp(nowTimestamp()) 
                            + "-->> Nie odnaleziono serwera");
            bw.newLine();
        }
        catch (IOException e) {
        }
        try {
            bw.close();
            fw.close();
        }
        catch (IOException e) {
        }
        
    }
    
}

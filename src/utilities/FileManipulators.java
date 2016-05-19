/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Marek
 */
public class FileManipulators {
        public String readIp(){
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
    public void saveIp(String str){
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
}

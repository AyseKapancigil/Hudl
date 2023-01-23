package utilities;

import pojo.LogInPojo;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class TxtWriter {

    public static void saveData(LogInPojo logIn){

        try {

            FileWriter fileWriter = new FileWriter(ConfigReader.getProperty("path"),true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append(logIn.toString()+"\n");
            bufferedWriter.close();



        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
package net.alexanders.openfilebatch;

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BatchFileFactory
{
    public static void generateJSONAction(String name, Action action)
    {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./"+name));
            writer.write(new Gson().toJson(action));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            JDialog errorDialog = new JDialog((Frame)null, "Error Occured");
            errorDialog.getContentPane().add(new JLabel("Failed to save file:\n"+e.getMessage()));
            errorDialog.pack();
            errorDialog.setVisible(true);
            e.printStackTrace();
        }
    }
    public static void generateWindowsBatchFile(File path, String action)
    {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write("@echo off\r\njava -jar "+Main.jar_location+" "+action+"\r\n");
            writer.flush();
            writer.close();
        }catch(IOException e){
            JDialog errorDialog = new JDialog((Frame)null, "Error Occured");
            errorDialog.getContentPane().add(new JLabel("Failed to save file:\n"+e.getMessage()));
            errorDialog.pack();
            errorDialog.setVisible(true);
            e.printStackTrace();
        }
    }
}

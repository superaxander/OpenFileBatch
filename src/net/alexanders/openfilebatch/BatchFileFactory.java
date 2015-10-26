package net.alexanders.openfilebatch;

import com.google.gson.Gson;

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
            e.printStackTrace();
        }
    }
    public static void generateWindowsBatchFile(File path, String action)
    {

    }
}

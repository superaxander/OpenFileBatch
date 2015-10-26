package net.alexanders.openfilebatch;

import java.io.File;

public class FileOperationHelper
{
    public static String getFreeName(String location)
    {
        int i;
        File[] filelist = new File(location).listFiles();
        for(i = filelist.length; new File(location+"/"+"save"+i).exists(); i++)
        {}
        return "/save"+i;
    }
}

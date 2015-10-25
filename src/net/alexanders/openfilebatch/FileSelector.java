package net.alexanders.openfilebatch;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileSelector
{
    public enum filterTypes
    {
        STARTS_WITH, ENDS_WITH, CONTAINS, PATTERN, EQUALS
    }

    public static class Filter
    {
        private filterTypes filterType;
        private String value;

        public Filter(filterTypes filterType, String value)
        {
            this.filterType = filterType;
            this.value = value;
        }

        public boolean filter(String filename)
        {
            switch(filterType)
            {
                case STARTS_WITH: return filename.startsWith(value);
                case ENDS_WITH: return filename.endsWith(value);
                case CONTAINS: return filename.contains(value);
                case PATTERN: return filename.matches(value);
                case EQUALS: return filename.equals(value);
                default: return false;
            }
        }
    }

    private String location;
    private Filter filter;

    public FileSelector(String location, Filter filter)
    {
        this.location = location;
        this.filter = filter;
    }

    public ArrayList<File> getFileList()
    {
        ArrayList<File> fileList = new ArrayList<>();
        File loc = new File(location);
        if(loc.exists()) {
            if (loc.isDirectory()) {
                for(File file : loc.listFiles())
                {
                    if(filter.filter(file.getName()))
                    {
                        fileList.add(file);
                    }
                }
            }else{
                if(filter.filter(loc.getName()))
                {
                    fileList.add(loc);
                }
            }
            return fileList;
        }
        return fileList;
    }
}

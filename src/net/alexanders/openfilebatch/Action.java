package net.alexanders.openfilebatch;

import com.sun.istack.internal.Nullable;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Action
{
    public enum actionTypes
    {
        MOVE, COPY, DELETE, APPEND, PREPEND, SEARCH_REPLACE
    }

    private FileSelector filein;
    private File dirout;
    private actionTypes actionType;
    private boolean overwrite;
    @Nullable
    private String value1;
    @Nullable
    private String value2;

    public Action(FileSelector filein, String dirout, actionTypes actionType, boolean overwrite) throws IOException
    {
        this(filein, dirout, actionType, overwrite, null, null);
    }

    public Action(FileSelector filein, String dirout, actionTypes actionType, boolean overwrite, @Nullable String value1, @Nullable String value2) throws IOException
    {
        this.dirout = new File(dirout);
        if(this.dirout.exists() && this.dirout.isDirectory())
        {
            this.filein = filein;
            this.actionType = actionType;
            this.overwrite = overwrite;
            this.value1 = value1;
            this.value2 = value2;
        }else{
            throw new IOException("Selected directory is not a directory or doesn't exist.");
        }
    }

    public void execute()
    {
        filein.getFileList().forEach(file -> {
            try {
                File new_file;
                BufferedWriter writer;
                BufferedReader reader;
                String old_content;
                StringBuilder sb;
                switch (actionType) {
                    case MOVE:
                        Files.move(file.toPath(), new File(dirout.getAbsolutePath() + "/" + file.getName()).toPath(), overwrite ? StandardCopyOption.REPLACE_EXISTING : StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.COPY_ATTRIBUTES);
                        break;
                    case COPY:
                        Files.copy(file.toPath(), new File(dirout.getAbsolutePath() + "/" + file.getName()).toPath(), overwrite ? StandardCopyOption.REPLACE_EXISTING : StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.COPY_ATTRIBUTES);
                        break;
                    case DELETE:
                        Files.delete(file.toPath());
                        break;
                    case APPEND:
                        new_file = Files.copy(file.toPath(), new File(dirout.getAbsolutePath() + "/" + file.getName()).toPath(), overwrite ? StandardCopyOption.REPLACE_EXISTING : StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.COPY_ATTRIBUTES).toFile();
                        writer = new BufferedWriter(new FileWriter(new_file));
                        writer.append(value1);
                        writer.flush();
                        writer.close();
                        break;
                    case PREPEND: //TODO: Respect the overwrite boolean when prepending
                        reader = new BufferedReader(new FileReader(file));
                        sb = new StringBuilder();
                        reader.lines().forEach(line -> sb.append(line).append('\n'));
                        old_content = sb.toString();
                        reader.close();
                        writer = new BufferedWriter(new FileWriter(new File(dirout.getAbsolutePath() + "/" + file.getName())));
                        writer.write(value1);
                        writer.write(old_content);
                        writer.flush();
                        writer.close();
                        break;
                    case SEARCH_REPLACE: //TODO: Respect the overwrite boolean when search/replacing
                        reader = new BufferedReader(new FileReader(file));
                        sb = new StringBuilder();
                        reader.lines().forEach(line -> sb.append(line).append('\n'));
                        old_content = sb.toString().replaceAll(value1, value2);
                        reader.close();
                        writer = new BufferedWriter(new FileWriter(new File(dirout.getAbsolutePath() + "/" + file.getName())));
                        writer.write(old_content);
                        writer.flush();
                        writer.close();
                        break;
            }
            }catch(IOException exception)
            {}
        });

    }
}

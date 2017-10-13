package c.a.a.a.a;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public interface f extends FileFilter, FilenameFilter {
    boolean accept(File file);

    boolean accept(File file, String str);
}

package mmyrland.tools;

import mmyrland.domain.ScanResult;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

/**
 * Source: https://docs.oracle.com/javase/tutorial/essential/io/walk.html
 */

public class CustomFileVisitor extends SimpleFileVisitor<Path> {


    private int numberDirectories = 0;
    private int numberFiles = 0;
    private long totalBytes = 0L;

    // Print information about
    // each type of file.
    @Override
    public FileVisitResult visitFile(Path file,
                                     BasicFileAttributes attr) {
        //Only want to count valid files in directory
        if(file.toString().contains(".DS_Store")){return FileVisitResult.CONTINUE;}
        numberFiles++;
        totalBytes += attr.size();
        return FileVisitResult.CONTINUE;
    }

    // Print each directory visited.
    @Override
    public FileVisitResult postVisitDirectory(Path dir,
                                              IOException exc) {
        numberDirectories++;
        return FileVisitResult.CONTINUE;
    }

    // If there is some error accessing
    // the file, let the user know.
    // If you don't override this method
    // and an error occurs, an IOException
    // is thrown.
    @Override
    public FileVisitResult visitFileFailed(Path file,
                                           IOException exc) {
        System.err.println(exc);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
            throws IOException
    {
        Objects.requireNonNull(dir);
        Objects.requireNonNull(attrs);
        return FileVisitResult.CONTINUE;
    }

    ScanResult done() {
        long avgBytes;
//        if(numberDirectories == 0){ throw new IllegalArgumentException("directory not found.");}
        // Don't want to divide by zero of course.
        // Error shouldn't be thrown when no files are present -
        // scan results can still provide info.
        if(numberFiles == 0){
            avgBytes = 0L;
        } else {
            avgBytes = totalBytes / (long) numberFiles;
        }
        ScanResult scanResult = new ScanResult(numberFiles,numberDirectories,totalBytes,avgBytes);
        return scanResult;
    }
}

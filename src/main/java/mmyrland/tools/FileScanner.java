package mmyrland.tools;

import mmyrland.domain.ScanResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileScanner{
    public static ScanResult scan(String path) throws IOException{

            Path start = Paths.get(path);
            CustomFileVisitor customFileVisitor = new CustomFileVisitor();
            Files.walkFileTree(start, customFileVisitor);
            return customFileVisitor.done();
    }



}

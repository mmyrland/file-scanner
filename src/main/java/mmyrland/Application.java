package mmyrland;

import mmyrland.domain.ScanResult;
import mmyrland.tools.FileScanner;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("must pass valid directory as arg");
        }
        ScanResult scanResult = FileScanner.scan(args[0]);
        System.out.println("Results for Directory: " + args[0]);
        System.out.println(scanResult.toString());

    }
}

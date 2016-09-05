import mmyrland.domain.ScanResult;
import mmyrland.tools.FileScanner;
import org.junit.Test;

import java.io.IOException;

public class FileScannerSpec {

    @Test
    public void testScanRoot() throws IOException {

            ScanResult scanResult = FileScanner.scan("src/test/resources/testroot/");
            assert scanResult.getNumDirectories() == 7;
            assert scanResult.getNumFiles() == 7;
            assert scanResult.getTotalBytes() == 4155L;
            assert scanResult.getAvgBytes() == 593;
    }

    @Test
    public void testScanColors() throws IOException {

        ScanResult scanResult = FileScanner.scan("src/test/resources/testroot/favoritecolors");
        assert scanResult.getNumDirectories() == 1;
        assert scanResult.getNumFiles() == 3;
        assert scanResult.getTotalBytes() == 3867L;
        assert scanResult.getAvgBytes() == 1289L;
    }

    @Test
    public void testScanNoFiles() throws IOException {

        ScanResult scanResult = FileScanner.scan("src/test/resources/testroot/randomquotes/unknown/unknown");
        assert scanResult.getNumDirectories() == 1;
        assert scanResult.getNumFiles() == 0;
        assert scanResult.getTotalBytes() == 0L;
        assert scanResult.getAvgBytes() == 0L;
    }

    @Test(expected = IllegalArgumentException.class)
    public void badDirectory() throws IOException {
        FileScanner.scan("badDir/");
    }
}

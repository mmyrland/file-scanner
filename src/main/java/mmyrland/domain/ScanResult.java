package mmyrland.domain;

public class ScanResult {

    private int numFiles;
    private int numDirectories;
    private long totalBytes;
    private long avgBytes;

    public ScanResult(int numFiles, int numDirectories, long totalBytes, long avgBytes) {
        this.numFiles = numFiles;
        this.numDirectories = numDirectories;
        this.totalBytes = totalBytes;
        this.avgBytes = avgBytes;
    }

    public ScanResult() {
    }

    public int getNumFiles() {
        return numFiles;
    }

    public void setNumFiles(int numFiles) {
        this.numFiles = numFiles;
    }

    public int getNumDirectories() {
        return numDirectories;
    }

    public void setNumDirectories(int numDirectories) {
        this.numDirectories = numDirectories;
    }

    public long getTotalBytes() {
        return totalBytes;
    }

    public void setTotalBytes(long totalBytes) {
        this.totalBytes = totalBytes;
    }

    public long getAvgBytes() {
        return avgBytes;
    }

    public void setAvgBytes(long avgBytes) {
        this.avgBytes = avgBytes;
    }

    @Override
    public String toString() {
        return "ScanResult{" +
                "\n----------------------" +
                "\nnumFiles = " + numFiles +
                "\nnumDirectories = " + numDirectories +
                "\ntotalBytes = " + totalBytes +
                "\navgBytes = " + avgBytes +
                "\n----------------------";
    }
}

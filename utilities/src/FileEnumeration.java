
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Stack;

public class FileEnumeration
implements Enumeration {
    private File root = null;
    private File[] currentDir = null;
    private int currentFile = -1;
    private Stack dirStack = new Stack();
    private Stack fileStack = new Stack();
    private boolean debug = true;

    public FileEnumeration(File dir) throws FileNotFoundException {
        if (!dir.exists() || !dir.isDirectory()) {
            throw new FileNotFoundException("Directory not valid: " + dir.getAbsolutePath());
        }
        this.root = dir;
        this.currentDir = this.root.listFiles();
    }

    public FileEnumeration(String dirName) throws FileNotFoundException {
        this(new File(dirName));
    }

    private File findNextFile() {
        File nextFile = null;
        if (++this.currentFile < this.currentDir.length) {
            if (this.currentDir[this.currentFile].isFile()) {
                nextFile = this.currentDir[this.currentFile];
            } else if (this.currentDir[this.currentFile].isDirectory()) {
                this.dirStack.push(this.currentDir);
                this.fileStack.push(new Integer(this.currentFile));
                System.out.println("Descending into " + this.currentDir[this.currentFile].getAbsoluteFile());
                this.currentDir = this.currentDir[this.currentFile].listFiles();
                this.currentFile = -1;
                nextFile = this.findNextFile();
                if (nextFile == null) {
                    this.currentDir = (File[])this.dirStack.pop();
                    this.currentFile = (Integer)this.fileStack.pop();
                    System.out.println("Ascending to " + this.currentDir[this.currentFile].getAbsoluteFile());
                    nextFile = this.findNextFile();
                }
            }
        } else if (!this.dirStack.empty()) {
            this.currentDir = (File[])this.dirStack.pop();
            this.currentFile = (Integer)this.fileStack.pop();
            System.out.println("Ascending to " + this.currentDir[this.currentFile].getAbsoluteFile());
            nextFile = this.findNextFile();
        }
        return nextFile;
    }

    public boolean hasMoreElements() {
        if (this.findNextFile() == null) {
            return false;
        }
        return true;
    }

    public Object nextElement() {
        return this.currentDir[this.currentFile];
    }

    public void reset() {
        this.currentFile = -1;
        this.currentDir = this.root.listFiles();
    }
}
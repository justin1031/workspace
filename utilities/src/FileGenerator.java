
//import com.ibm.file.load.FileFolderCreator;
//import com.ibm.file.util.FileEnumeration;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class FileGenerator {
    public static String sourceDir = null;
    public static String targetDir = null;
    public static int numOfSubFolder;
    public static int numOfFile;
    public static int startNum;

    public static void main(String[] args) {
        FileEnumeration fileList = null;
        FileFolderCreator folderFileCreator = new FileFolderCreator();
        if (args.length < 5) {
            System.out.println("Userage: sourceDir targetDir numberOfSubFolder numberOfFile startNumber");
            System.exit(0);
        }
        sourceDir = args[0].trim();
        targetDir = args[1].trim();
        numOfSubFolder = Integer.parseInt(args[2].trim());
        numOfFile = Integer.parseInt(args[3].trim());
        startNum = Integer.parseInt(args[4].trim());
        if (numOfSubFolder > 20) {
            System.out.println("Please make numberOfSubFolder less then 20, otherwise the path name will be too long. The system can't handle it.");
            System.exit(0);
        }
        if (sourceDir != null) {
            try {
                fileList = new FileEnumeration(sourceDir);
            }
            catch (FileNotFoundException e) {
                System.out.println("No valid file directory found. No files will be added to folder.");
            }
        }
        if (folderFileCreator.createDirFile(fileList)) {
            System.out.println("Directories and Files have been created successfully.");
        }
    }

    public static int getNumOfFile() {
        return numOfFile;
    }

    public static int getNumOfSubFolder() {
        return numOfSubFolder;
    }

    public static String getSampleFileURL() {
        return sourceDir;
    }

    public static String getTargetDir() {
        return targetDir;
    }

    public static int getStartNum() {
        return startNum;
    }
}
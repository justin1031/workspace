/*
 * Decompiled with CFR 0_110.
 */
package com.ibm.file.load;

import com.ibm.file.load.FolderFileCreator;
import com.ibm.file.util.FileEnumeration;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class FileGenerator {
	public static String sourceDir = null;
	public static String targetDir = null;
	public static int numOfSubFolder;
	public static int numOfFile;
	public static int startNum;
	public static int numOfFolder;
	public static int numOfFPF;
	public static String mode;

	public static void main(String[] args) {
		FileEnumeration fileList = null;
		FolderFileCreator folderFileCreator = new FolderFileCreator();
		if (args.length < 7) {
			System.out.println("Userage: sourceDir targetDir depthOfFolders numberOfFiles widthOfFolders numberOfFilesPerFolder [random or systematic]");
			System.exit(0);
		}
		sourceDir = args[0].trim();
		targetDir = args[1].trim();
		numOfSubFolder = Integer.parseInt(args[2].trim());
		numOfFile = Integer.parseInt(args[3].trim());
		//        startNum = Integer.parseInt(args[4].trim());
		numOfFolder = Integer.parseInt(args[4].trim());
		numOfFPF = Integer.parseInt(args[5].trim());
		mode = args[6].trim().toLowerCase();

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

	public static int getNumOfFolder() {
		return numOfFolder;
	}

	public static String getMode() {
		return mode;
	}

	public static int getNumOfFPF() {
		return numOfFPF;
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

	//    public static int getStartNum() {
		//        return startNum;
	//    }
}


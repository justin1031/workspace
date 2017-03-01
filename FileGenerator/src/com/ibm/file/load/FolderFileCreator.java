/*
 * Decompiled with CFR 0_110.
 */
package com.ibm.file.load;

import com.ibm.file.load.FileGenerator;
import com.ibm.file.util.FileEnumeration;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class FolderFileCreator {
	public ArrayList<String> allFiles = new ArrayList();
	double byteSize = 0.0;
	private DecimalFormat twoDigits = new DecimalFormat("0.00");
	private int totalDoc = 1;

	public boolean createDirFile(FileEnumeration fileList) {
		String path = null;
		String newFileName = null;
		String mode = FileGenerator.getMode();
		int listMax = 0;

		if (mode.equals("random")) {
			int numFile = 1;
			int newNumOfFile = FileGenerator.getNumOfFile() + numFile;

			Random rand = new Random();
			while (numFile < newNumOfFile) {
				StringBuffer tempPath = new StringBuffer();
				int maxFolderNum = rand.nextInt(FileGenerator.getNumOfSubFolder());
				int startFolderNum = rand.nextInt(FileGenerator.getNumOfSubFolder());
				if (startFolderNum > maxFolderNum) {
					startFolderNum = 0;
				}
				int x = startFolderNum;
				while (x < maxFolderNum) {
					tempPath.append(String.valueOf(File.separatorChar) + "Folder_" + x);
					++x;
				}
				this.getAllFiles(fileList);
				path = String.valueOf(FileGenerator.getTargetDir()) + tempPath.toString();
				File fo = new File(path);
				if (!fo.exists()) {
					fo.mkdirs();
				}
				if (listMax == this.allFiles.size()) {
					listMax = 0;
				}
				if (listMax < this.allFiles.size()) {
					newFileName = this.modifyFileName(this.allFiles.get(listMax), numFile);
					this.copyFile(new File(String.valueOf(FileGenerator.getSampleFileURL()) + File.separatorChar + this.allFiles.get(listMax)), new File(String.valueOf(path) + File.separatorChar + newFileName));
					System.out.println("Creating file: " + newFileName + " Total size of files:" + this.twoDigits.format(this.byteSize / 1024.0) + "KB, " + this.twoDigits.format(this.byteSize / 1024.0 / 1024.0) + "MB, " + this.twoDigits.format(this.byteSize / 1024.0 / 1024.0 / 1024.0) + "GB, ");
					++listMax;
				}
				++numFile;
			}
		} else {
			int numFile = 0;
//			int newNumOfFile = FileGenerator.getNumOfFile();
			int numOfFPF = FileGenerator.getNumOfFPF() + numFile; 
			int numOfFolder = FileGenerator.getNumOfFolder();
//			int numOfSubFolder = FileGenerator.getNumOfSubFolder();
//			int x = 0;
			//Random rand = new Random();
			for (int i=0; i<numOfFolder; i++) {
				numFile = 0;
				while (numFile < numOfFPF) {
					StringBuffer tempPath = new StringBuffer();
//					int maxFolderNum = FileGenerator.getNumOfSubFolder();
					//		            int startFolderNum = rand.nextInt(FileGenerator.getNumOfSubFolder());
					//		            if (startFolderNum > maxFolderNum) {
					//		                startFolderNum = 0;
					//		            }

					tempPath.append(String.valueOf(File.separatorChar) + "Folder_" + i);

					this.getAllFiles(fileList);
					path = String.valueOf(FileGenerator.getTargetDir()) + tempPath.toString();
					File fo = new File(path);
					if (!fo.exists()) {
						fo.mkdirs();
					}
					if (listMax == this.allFiles.size()) {
						listMax = 0;
					}
					if (numFile < numOfFPF) {
						newFileName = this.modifyFileName(this.allFiles.get(listMax), totalDoc);
						this.copyFile(new File(String.valueOf(FileGenerator.getSampleFileURL()) + File.separatorChar + this.allFiles.get(listMax)), new File(String.valueOf(path) + File.separatorChar + newFileName));
						System.out.println("Creating file: " + newFileName + " Total size of files:" + this.twoDigits.format(this.byteSize / 1024.0) + "KB, " + this.twoDigits.format(this.byteSize / 1024.0 / 1024.0) + "MB, " + this.twoDigits.format(this.byteSize / 1024.0 / 1024.0 / 1024.0) + "GB, ");
						++listMax;
					}
					++numFile;	
					++totalDoc;
				}
			}
		}
		return true;
	}

	public ArrayList<String> getAllFiles(FileEnumeration fileList) {
		String temp = null;
		while (fileList.hasMoreElements()) {
			temp = fileList.nextElement().toString().substring(FileGenerator.getSampleFileURL().length() + 1, fileList.nextElement().toString().length());
			this.allFiles.add(temp);
		}
		return this.allFiles;
	}

	public String modifyFileName(String fName, int x) {
		String newName = null;
		fName = fName.replaceAll("\\s+", "");
		int dot = 0;
		if (fName.contains(".")){
			dot = fName.indexOf(".");
			newName = String.valueOf(fName.substring(0, dot)) + "_" + x + "." + fName.substring(dot + 1, fName.length());
		}else 
			newName = String.valueOf(fName.substring(0, fName.length())) + "_" + x;

		return newName;
	}

	public void copyFile(File in, File out) {
		try {
			if (!out.exists()) {
				out.createNewFile();
			}
			this.byteSize += (double)in.length();
			FileChannel sourceChannel = new FileInputStream(in).getChannel();
			FileChannel destinationChannel = new FileOutputStream(out).getChannel();
			sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);
			sourceChannel.close();
			destinationChannel.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}


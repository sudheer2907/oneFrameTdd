package com.oneframe.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import com.oneframe.base.TestBase;

public class FileUpload extends TestBase {
  String fileName = new Date().getTime() + ".txt";
  String filePath = prop.getProperty("uploadPath") + fileName;

  public String[] createFile() throws InterruptedException, IOException {
    String fileinfo[] = new String[2];
    fileinfo[0] = fileName;
    fileinfo[1] = filePath;
    try {
      File myObj = new File(prop.getProperty("uploadPath") + fileName);
      if (myObj.createNewFile()) {
        FileWriter fr = new FileWriter(filePath, true);
        fr.write("This is a file to be used for Automation testing");
        fr.close();
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return fileinfo;

  }

  public FileUpload() throws IOException {}
}

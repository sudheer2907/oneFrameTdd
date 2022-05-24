package com.oneframe.utils.fileutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oneframe.utils.LogPrinter;

public class FileUtil {
  public static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
  private static String sourceLocation;
  private static String targetLocation;
  private static PrintWriter printWriter;

  /**
   * Read excel data by passing fileName, sheetName, row, column value.
   *
   * @param fileName - name of the excel file whose data you want to read.
   * @param sheetName - sheet name of an excel sheet.
   * @param rowValue - row value.
   * @param columnValue - column value.
   * @return - Cell data of type Cell
   * @throws IOException - if in case file not found.
   */
  public static Cell readExcelData(String fileName, String sheetName, int rowValue, int columnValue)
      throws IOException {
    String path = "src/test/resources/properties/" + fileName;
    File file = new File(path);
    Cell cell1 = null;
    XSSFWorkbook wb = null;
    try {
      FileInputStream fis = new FileInputStream(file);
      wb = new XSSFWorkbook(fis);
      XSSFSheet sheet = wb.getSheet(sheetName);
      Row row = sheet.getRow(rowValue);
      cell1 = row.getCell(columnValue);
    } catch (IOException e) {
      LogPrinter.printLog(e.toString());
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return cell1;
  }

  /**
   * Load files as string.
   *
   * @param path - path where the files is present.
   * @return - file content in form of string.
   * @author sudheer.singh
   */
  public static String loadFileAsString(String path) {
    String fileContents = null;
    try (InputStream inputStream = FileUtil.class.getResourceAsStream(path)) {
      fileContents = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
    } catch (IOException e) {
      logger.error(e.toString());
    }
    return fileContents;
  }

  /**
   * Resource files from class resource.
   *
   * @param resourceFilePath - location of resource file path.
   * @return - file content.
   * @author sudheer.singh
   */
  public String readFileFromResources(String resourceFilePath) {
    String result = "";
    ClassLoader classLoader = getClass().getClassLoader();
    try {
      result = IOUtils.toString(classLoader.getResourceAsStream(resourceFilePath),
          StandardCharsets.UTF_8);
    } catch (IOException e) {
      logger.error(e.getMessage());
    }

    return result;
  }

  /**
   * Delete folder.
   *
   * @param pathString - folder location.
   */
  public static void deleteFolder(String pathString) {
    try {
      FileUtils.deleteDirectory(new File(pathString));
    } catch (IOException e) {
      logger.error(e.toString());
    }
  }

  /**
   * Check if file exist or not.
   *
   * @param filePath - path of the file.
   * @return - True if file exist else false.
   */
  public static boolean isExists(String filePath) {
    File fileObj = new File(filePath);
    return fileObj.exists() && fileObj.isFile();
  }

  /**
   * Delete file.
   *
   * @param pathString - path of the file.
   */
  public static void deleteFile(String pathString) {
    Path path = Paths.get(pathString);
    try {
      logger.info("Deleting file {}", path);
      Files.deleteIfExists(path);
    } catch (IOException e) {
      logger.error(e.toString());
    }
  }

  /**
   * Copy files from source location to target location, set source location and set target location
   * would be the prerequisit before you use this method.
   *
   * @param fileName - Name of the files which has to be copied.
   * @throws IOException if an IO error occurs during copying.
   * @author sudheer.singh
   */
  public static void copyFilesFromSourceToTarget(String fileName) throws IOException {
    if (FilesBeans.getSourceFileLocation() != null) {
      sourceLocation = FilesBeans.getSourceFileLocation() + fileName;
    }
    if (FilesBeans.getTargetFileLocation() != null) {
      targetLocation = FilesBeans.getTargetFileLocation() + fileName;
    }

    File sourceFile = new File(sourceLocation);
    File targetFile = new File(targetLocation);
    try {
      FileUtils.copyFile(sourceFile, targetFile);
    } catch (IOException e) {
      LogPrinter.printLog("Error occured while copying");
      throw e;
    }
  }

  /**
   * readJsonFile.
   *
   * @param fileName - json file name.
   * @return JsonObject - content in the form of json.
   * @throws JSONException - if in case of JSON exception.
   * @author sudheer.singh
   */
  public static JSONObject readJsonFile(String fileName) throws IOException, JSONException {
    InputStream inputStream = FileUtil.class.getResourceAsStream("/payloads/" + fileName);
    return new JSONObject(IOUtils.toString(inputStream, Charset.defaultCharset()));
  }

  /**
   * Read xml from resource directory.
   *
   * @param fileName - name of the file.
   * @return - file content
   * @throws IOException - if in case of IO exception
   * @author sudheer.singh
   */
  public static String readXmlFile(String fileName) throws IOException {
    String fileContent = null;
    try {
      InputStream inputStream = FileUtil.class.getResourceAsStream(fileName);
      fileContent = IOUtils.toString(inputStream, Charset.defaultCharset());
    } catch (IOException ioe) {
      LogPrinter.printLog("Error occured while reading XML file");
      throw ioe;
    }
    return fileContent;
  }

  /**
   * Close the Write instance to stop writing to file further and flush the contents from the
   * Writers Pipeline.
   */
  public static void closeWriter() {
    if (printWriter != null) {
      printWriter.flush();
      printWriter.close();
    }
    printWriter = null;
  }

  /**
   * Find total Number rows having some data.
   * 
   * @param fileName - name of the file.
   * @param sheetName - sheet name whose total num of rows to be calculated
   * @return - number of rows filled with some data.
   * @throws IOException - if in case of IO Exceptions.
   * @author kumsudhe
   */
  public static Integer findTotalNumOfRows(String fileName, String sheetName) throws IOException {
    String path = "src/test/resources/properties/" + fileName;
    File file = new File(path);
    XSSFWorkbook wb = null;
    int rowCount = 0;
    try {
      FileInputStream fis = new FileInputStream(file);
      wb = new XSSFWorkbook(fis);
      XSSFSheet sheet = wb.getSheet(sheetName);
      rowCount = sheet.getLastRowNum();
      return rowCount;
    } catch (IOException e) {
      LogPrinter.printLog(e.toString());
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return rowCount;
  }
}

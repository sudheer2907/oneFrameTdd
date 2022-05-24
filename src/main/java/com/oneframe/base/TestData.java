package com.oneframe.base;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestData {

    public static String[][] get(String filename,int sheetno) {
        String[][] dataTable = null;
        File file = new File(filename);
        try {
            // Create a file input stream to read Excel workbook and worksheet
            FileInputStream xlfile = new FileInputStream(file);
            XSSFWorkbook xlwb = new XSSFWorkbook (xlfile);
            XSSFSheet xlSheet = xlwb.getSheetAt(sheetno);

            // Get the number of rows and columns
            int numRows = xlSheet.getLastRowNum()+1;
            int numCols = xlSheet.getRow(0).getLastCellNum();

            // Create double array data table - rows x cols
            // We will return this data table
            dataTable = new String[numRows-1][numCols];

            // For each row, create a HSSFRow, then iterate through the "columns"
            // For each "column" create an HSSFCell to grab the value at the specified cell (i,j)
            for (int i = 1; i <= numRows-1; i++) {
                XSSFRow xlRow = xlSheet.getRow(i);
                for (int j = 0; j < numCols; j++) {
                    XSSFCell xlCell = xlRow.getCell(j);
                    dataTable[i-1][j] = xlCell.toString();
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR FILE HANDLING " + e.toString());
        }
        return dataTable;
    }



}

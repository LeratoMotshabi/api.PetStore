package api.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class XLUtility {
    public FileInputStream file;
    public FileOutputStream fo;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFCell cell;
    public XSSFRow row;
    public CellStyle style;
    String path;

    // Constructor to initialize file path
    public XLUtility(String path) {
        this.path = path;
    }

    // Method to get row count in a sheet
    public int getRowCount(String sheetName) throws IOException {
        file = new FileInputStream(path);
        workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        workbook.close();
        file.close();
        return rowCount;
    }

    // Method to get cell count in a row
    public int getCellCount(String sheetName, int rowNum) throws IOException {
        file = new FileInputStream(path);
        workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);

        int cellCount = (row == null) ? 0 : row.getLastCellNum();

        workbook.close();
        file.close();
        return cellCount;
    }

    // Method to get cell data
    public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
        file = new FileInputStream(path);
        workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        if (row == null) {
            workbook.close();
            file.close();
            return "";
        }
        cell = row.getCell(colNum);
        if (cell == null) {
            workbook.close();
            file.close();
            return "";
        }

        DataFormatter formatter = new DataFormatter();
        String data = formatter.formatCellValue(cell);

        workbook.close();
        file.close();
        return data;
    }

    // Method to set cell data
    public void setCellData(String sheetName, int rowNum, int colNum, String data) throws IOException {
        file = new FileInputStream(path);
        workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            sheet = workbook.createSheet(sheetName);
        }

        row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }

        cell = row.getCell(colNum);
        if (cell == null) {
            cell = row.createCell(colNum);
        }

        cell.setCellValue(data);

        file.close(); // Close input stream before writing

        fo = new FileOutputStream(path);
        workbook.write(fo);
        fo.close();
        workbook.close();
    }
}

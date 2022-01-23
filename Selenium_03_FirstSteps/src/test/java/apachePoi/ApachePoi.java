package apachePoi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ApachePoi {

    public ArrayList<Object[]> getExcelData(String filepath) throws IOException {
        ArrayList<Object[]> output = new ArrayList<Object[]>();

        FileInputStream is = new FileInputStream(filepath);

        XSSFWorkbook workbook = new XSSFWorkbook(is);
        XSSFSheet worksheet = workbook.getSheetAt(0);

        for (Row row : worksheet) {
            if (row.getRowNum() >= 1) {

                Object[] values = new Object[row.getPhysicalNumberOfCells()];

                Iterator<Cell> cellIterator = row.cellIterator();

                int column = 0;
                while (cellIterator.hasNext()) {
                    Cell cellValue = cellIterator.next();
                    if (cellValue.getCellType() == CellType.STRING) {
                        values[column] = cellValue.getStringCellValue();
                    } else {
                        values[column] = NumberToTextConverter.toText(cellValue.getNumericCellValue());
                    }
                    column++;
                }
                output.add(values);


            }
        }

        return output;


    }

    public static void main(String[] args) throws IOException {
        ApachePoi testFall = new ApachePoi();
        ArrayList<Object[]> list = testFall.getExcelData("./TestCaseTestform3.xlsx");
        for (Object[] objects: list) {
            for (Object object : objects) {
                System.out.println(object);
            }
            
        }
        
    }

}

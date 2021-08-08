import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtil {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelUtil() throws IOException {
        workbook = new XSSFWorkbook("src/test/resources/data.xlsx");
        sheet = workbook.getSheet("Sheet1");
    }

    public int readRowCnt() throws IOException {
        return sheet.getPhysicalNumberOfRows();
    }

    public String readData(int rowNum, int colNum){
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));

    }

    public int readColCnt(){
        return sheet.getRow(0).getLastCellNum();
    }
}

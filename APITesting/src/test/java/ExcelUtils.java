import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelpath, String sheetName) {
		try {
			
			XSSFWorkbook workbook = new XSSFWorkbook(excelpath);

			XSSFSheet sheet = workbook.getSheet(sheetName);
			
		}catch(Exception e) {
			
			System.out.println("Exception:"+ e.getMessage());
			System.out.println("Exception:"+ e.getCause());
		}	
	}
	
	public static Object getCellData(int rowNum, int colNum) { 

		DataFormatter formatter = new DataFormatter();

		Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
        System.out.println("value:" + value);
		return value;

}
}

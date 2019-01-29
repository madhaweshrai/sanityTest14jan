package baseClasses;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class RowsAndCells {
	public static String getcellvalue(String xlpath, String sheet, int r, int c)
			throws EncryptedDocumentException, InvalidFormatException,
			IOException {

		FileInputStream fis = new FileInputStream(xlpath);
		Workbook wb = WorkbookFactory.create(fis);
		String s = wb.getSheet(sheet).getRow(r).getCell(c).toString();
		System.out.println(s);
		return s;
	}

	public static int getRowCount(String xlpath, String sheet)
			throws EncryptedDocumentException, InvalidFormatException,
			IOException {
		FileInputStream fis = new FileInputStream(xlpath);
		Workbook wb = WorkbookFactory.create(fis);
		int rc = wb.getSheet(sheet).getLastRowNum();
		return rc;
	}

}

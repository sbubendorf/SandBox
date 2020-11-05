package ch.rusi.sandbox.itext;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.thedeanda.lorem.LoremIpsum;

public class CreatePDF {
	
	/*
	 * iText Tutorial:
	 * 
	 *	http://www.tutorialspoint.com/itext/index.htm
	 * 
	 */

	private static final String FILE_EXT = ".pdf";

	public static void main(String[] args) throws IOException {

		Document document = createDocument("01_empty_one_pager");
		document.close();
		
		// --------------------------------------------------------------------------------
		
		document = createDocument("02_area_break");
		AreaBreak ab = new AreaBreak();
		document.add(ab);
		document.close();

		// --------------------------------------------------------------------------------
		
		document = createDocument("03_paragraph");
		Paragraph para1 = new Paragraph(LoremIpsum.getInstance().getParagraphs(1, 1));
		Paragraph para2 = new Paragraph(LoremIpsum.getInstance().getParagraphs(1, 1));
		document.add(para1);
		document.add(para2);
		document.close();

		// --------------------------------------------------------------------------------
		
		document = createDocument("04_list");
		Paragraph para = new Paragraph("Check out the following list of Lorem Ipsum texts:");
		document.add(para);
		List list = new List();
		for (int i = 0 ; i < 10 ; i++) {
			list.add(LoremIpsum.getInstance().getWords(2, 5));
		}
		document.add(list);
		document.close();

		// --------------------------------------------------------------------------------
		
		document = createDocument("05_table");
		float[] colWidths = {150F,150F,150F};
		ArrayList<String> lastNames = new ArrayList<>();
		ArrayList<String> firstNames = new ArrayList<>();
		ArrayList<String> cities = new ArrayList<>();
		for (int i = 0 ; i < 10 ; i++) {
			lastNames.add(LoremIpsum.getInstance().getLastName());
			firstNames.add(LoremIpsum.getInstance().getFirstName());
			cities.add(LoremIpsum.getInstance().getCity());
		}
		Table tab = new Table(colWidths);
		tab.addCell(new Cell().add("Last name"));
		for (String lastName : lastNames) {
			tab.addCell(new Cell().add(lastName));
		}
		tab.addCell(new Cell().add("First name"));
		for (String firstName : firstNames) {
			tab.addCell(new Cell().add(firstName));
		}
		tab.addCell(new Cell().add("City"));
		for (String city : cities) {
			tab.addCell(new Cell().add(city));
		}
		document.add(tab);
		document.close();
		
	}
	
	private static Document createDocument(String fileName) throws FileNotFoundException {
	
		fileName = fileName.toLowerCase();
		if (!fileName.endsWith(FILE_EXT)) {
			fileName += FILE_EXT;
		}
		File file = new File("output/" + fileName);

		// Creating the PDF Writer
		PdfWriter writer = new PdfWriter(file.getAbsolutePath());
		
		// Creating the PDF document
		PdfDocument pdfDoc = new PdfDocument(writer);
		
		// The new document has at least one empty page
		pdfDoc.addNewPage();
		
		System.out.println("New file created : " + file.getAbsolutePath());
		
		// Creating a Document
		return new Document(pdfDoc);
		
	}

}

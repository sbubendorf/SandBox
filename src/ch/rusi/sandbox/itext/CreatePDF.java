package ch.rusi.sandbox.itext;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;

public class CreatePDF {
	
	/*
	 * iText Tutorial:
	 * 
	 *	http://www.tutorialspoint.com/itext/index.htm
	 * 
	 */
	
	private static PdfWriter writer = null;
	private static PdfDocument pdfDoc  = null;
	private static Document document = null;

	public static void main(String[] args) throws IOException {
		
		String destination = "output/sample.pdf";
		
		createDocument("01_empty_one_pager.pdf");
		
		
		try {
			
			// Creating the PDF Writer
			PdfWriter writer = new PdfWriter(destination);
			
			// Creating the PDF document
			PdfDocument pdfDoc = new PdfDocument(writer);
			
			// Creating a Document
			Document document = new Document(pdfDoc);
			
			// Creating an Area Break
			AreaBreak ab = new AreaBreak();
			
			// Adding the area break to the PDF
			document.add(ab);
			
			// Closing the document
			document.close();
			
			System.out.println("Empty PDF document successfully created!");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	private static void createDocument(String fileName) throws FileNotFoundException {

		// Creating the PDF Writer
		PdfWriter writer = new PdfWriter("output/" + fileName);
		
		// Creating the PDF document
		PdfDocument pdfDoc = new PdfDocument(writer);
		pdfDoc.addNewPage();
		
		// Creating a Document
		document = new Document(pdfDoc);
		
	}

}

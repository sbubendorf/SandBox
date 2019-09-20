package ch.rusi.sandbox.itext;

import java.io.FileNotFoundException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

public class CreatePDF {

	public static void main(String[] args) {
		
		String destination = "sample.pdf";
		
		try {
			
			// Creating the PDF Writer
			PdfWriter writer = new PdfWriter(destination);
			
			// Creating the PDF document
			PdfDocument doc = new PdfDocument(writer);
			
			// Adding a new page
			doc.addNewPage();
			
			// Creating a Document
			Document document = new Document(doc);
			
			// Closing the document
			document.close();
			
			System.out.println("Empty PDF document successfully created!");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

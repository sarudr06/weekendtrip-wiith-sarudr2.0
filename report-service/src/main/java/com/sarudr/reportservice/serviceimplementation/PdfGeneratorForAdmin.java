package com.sarudr.reportservice.serviceimplementation;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.sarudr.travellerservice.model.Passenger;
import com.sarudr.travellerservice.model.Traveller;

@Service
public class PdfGeneratorForAdmin {

	@Autowired
	private PdfGeneratorForUser service;

	public List<Passenger> getPassengersList() {
		return service.getAllPassengers();
	}

	public List<Traveller> getTravellersList() {
		return service.getAllTraveller();
	}

	public void generate(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "inline; filename=Mypdf.pdf");
		Document document = new Document(PageSize.A4);

		document.open();

		addRectangleBorder(document);
		addTitle(document);
		addLogo(document);

		for (Traveller traveller : getTravellersList()) {
			addTravellerDetails(document, traveller);
			addPassengerList(document, traveller.getPassenger());
		}

		document.add(Chunk.NEWLINE);
		document.setPageCount(2);
		document.addAuthor("MAHESH");
		document.setRole(new PdfName("MY PDF"));

		document.close();
	}

	private static void addRectangleBorder(Document document) throws DocumentException {
		Rectangle rect = new Rectangle(577, 825, 18, 15);
		rect.enableBorderSide(Rectangle.BOX);
		rect.setBorderColor(BaseColor.BLACK);
		rect.setBorderWidth(1);
		document.add(rect);
		document.add(Chunk.NEWLINE);
		document.add(Chunk.NEWLINE);
	}

	private static void addTitle(Document document) throws DocumentException {
		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setSize(30);
		Paragraph title = new Paragraph("Traveller's Details", fontTitle);
		title.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(title);
	}

	private static void addLogo(Document document) throws IOException, DocumentException {
		Image img = Image.getInstance(
				ClassLoader.getSystemResource("weekendtrips-low-resolution-logo-color-on-transparent-background.png"));
		img.scaleAbsolute(146, 70);
		Phrase phrase = new Phrase();
		phrase.add(new Chunk(img, 390, 0));
		document.add(new Paragraph(phrase));
		document.add(Chunk.NEWLINE);
	}

	private static void addTravellerDetails(Document document, Traveller traveller) throws DocumentException {
		document.add(new Paragraph("Traveller Id: " + traveller.getTravellerId()));
		document.add(new Paragraph("Traveller Email: " + traveller.getTravellerEmail()));

		List<Passenger> passengersList = traveller.getPassenger();

		long menCount = passengersList.stream().filter(e -> e.getPassengerGender().equalsIgnoreCase("male")).count();
		long womenCount = passengersList.stream().filter(e -> e.getPassengerGender().equalsIgnoreCase("female"))
				.count();
		long childCount = passengersList.stream().filter(e -> e.getPassengerAge() < 5).count();

		document.add(new Paragraph("List of Passengers - " + passengersList.size() + "    Male - " + menCount
				+ "    Female - " + womenCount + "    Child - " + childCount));
	}

	private static void addPassengerList(Document document, List<Passenger> passengersList) throws DocumentException {
		PdfPTable table = new PdfPTable(3);
		table.setWidthPercentage(100f);
		table.setWidths(new int[] { 3, 3, 3 });
		table.setSpacingBefore(3);

		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(CMYKColor.WHITE);
		cell.setPadding(3);
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(CMYKColor.BLACK.darker());

		cell.setPhrase(new Phrase("Name", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Age", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Gender", font));
		table.addCell(cell);

		for (Passenger passenger : passengersList) {
			table.addCell(passenger.getPassengerName());
			table.addCell(String.valueOf(passenger.getPassengerAge()));
			table.addCell(passenger.getPassengerGender());
		}

		document.add(table);
		document.add(new Paragraph(
				".............................................................................................................................."));
	}

}
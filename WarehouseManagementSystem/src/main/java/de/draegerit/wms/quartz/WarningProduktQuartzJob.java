package de.draegerit.wms.quartz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import de.draegerit.wms.ServiceFactory;
import de.draegerit.wms.db.Produkt;
import de.draegerit.wms.db.dao.ProduktDAO;
import de.draegerit.wms.mailer.MailService;

public class WarningProduktQuartzJob implements Job {

	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

	private Document document;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		List<Produkt> produkte = new ProduktDAO().findAllWithWarnings();
		File file = new File("warningProdukt_" + String.valueOf(System.currentTimeMillis() + ".pdf"));
		try {
			document = new Document();
			System.out.println(file.getAbsolutePath());
			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();
			generateTitelPage();
			if (produkte.isEmpty()) {
				generateEmptyReport();
			} else {
				generateReport(produkte);
			}
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		} finally {
			document.close();
		}

		sendMail(file);
	}

	private void sendMail(File file) {
		try {
			MailService mailService = ServiceFactory.getMailService();
			mailService.sendMail("stefandraeger1980@gmail.com", "Ein Produktbericht der Anwendung WarehouseManagementSystem",
					"Im Anhang findest du den aktuellen Bericht zu Produkten mit Warnungen.", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void generateTitelPage() throws DocumentException {
		Paragraph preface = new Paragraph();
		addEmptyLine(preface, 1);
		preface.add(new Paragraph("WarehouseManagementSystem V1.0", catFont));
		addEmptyLine(preface, 1);

		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - HH:mm:ss");

		preface.add(new Paragraph("Produktbericht vom " + dateFormat.format(new Date()), smallBold));
		addEmptyLine(preface, 3);
		preface.add(new Paragraph(
				"Dieser Bericht enthält die Produkte aus dem System welche eine Warnung in der Anzahl haben!",
				smallBold));

		document.add(preface);
		// Start a new page
		document.newPage();
	}

	private void generateEmptyReport() {
		Paragraph preface = new Paragraph();
		preface.add(new Paragraph("Es wurden keine Produkte mit Warnungen gefunden!", smallBold));
	}

	private void generateReport(List<Produkt> produkte) throws DocumentException {
		PdfPTable table = new PdfPTable(2);

		PdfPCell c1 = new PdfPCell(new Phrase("Name"));
		c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Anzahl"));
		c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		table.setHeaderRows(1);

		for (Produkt p : produkte) {
			table.addCell(p.getName());
			table.addCell(String.valueOf(p.getAnzahl()));
		}

		document.add(table);
	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
}

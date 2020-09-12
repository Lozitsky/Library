package com.kirilo.jsp.servlets;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.Document;
import com.kirilo.jsp.db.Database;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

// https://stackoverflow.com/a/5459519/9586230
// https://www.tutorialspoint.com/itext/itext_shrinking_the_content.htm
public class ITextFileReaderPdf extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream inputStream = null;


        String id = req.getParameter("id") != null ? req.getParameter("id") : "NA";

        resp.setContentType("application/pdf");
//        resp.setHeader("Content-Disposition", "attachment; filename=output.pdf");
        resp.setHeader("Content-Disposition", "inline; filename=" + id + ".pdf");

        try (Statement statement = Database.getConnection().createStatement();
             final ResultSet resultSet = statement.executeQuery("select content from book where id=" + id);
//             PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
             PdfWriter writer = new PdfWriter(resp.getOutputStream());
             PdfDocument destDocument = new PdfDocument(writer);
             Document document = new Document(destDocument)
        ) {
            while (resultSet.next()) {
                inputStream = resultSet.getBinaryStream("content");
            }
            final PdfReader reader = new PdfReader(inputStream);
            PdfDocument sourceDocument = new PdfDocument(reader);


            PdfPage originPage = sourceDocument.getPage(1);
//            Rectangle origin = originPage.getPageSizeWithRotation();

            PdfPage newPage = destDocument.addNewPage();
/*            AffineTransform transform = AffineTransform.getScaleInstance(
                    newPage.getPageSize().getWidth() / origin.getWidth() / 2,
                    newPage.getPageSize().getHeight() / origin.getHeight() / 2);*/
            PdfCanvas canvasDest = new PdfCanvas(newPage);
//            canvasDest.concatMatrix(transform);

            PdfFormXObject copyAsFormXObject = originPage.copyAsFormXObject(destDocument);
            canvasDest.addXObject(copyAsFormXObject, 0, 0);

        } catch (SQLException throwables) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Can't load book content from DB id=" + id, throwables);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}

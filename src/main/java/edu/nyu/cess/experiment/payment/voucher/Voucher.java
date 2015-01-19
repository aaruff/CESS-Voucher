package edu.nyu.cess.experiment.payment.voucher;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfWriter;
import edu.nyu.cess.experiment.payment.Payoff;

/**
 * The type Voucher.
 */
public class Voucher
{
    private Document document;

    private PdfWriter pdfWriter;

    private Payoff payoff;
    private Chunk payment;
    private Chunk total;
    private Chunk paymentInWords;

    private Voucher(Payoff payoff)
    {
        Font font = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD, BaseColor.BLACK);
        payment = new Chunk(payoff.getInDollars(), font);
        total = new Chunk(payoff.getInDollars(), font);

    }
}

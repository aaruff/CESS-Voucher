package edu.nyu.cess.experiment.payment.voucher;

import com.itextpdf.text.pdf.codec.wmf.Point;

import java.util.HashMap;

public class Voucher
{
    private HashMap<Point, String> items = new HashMap<Point, String>();

    public void addItem(Point point, String text)
    {
        items.put(point, text);
    }
}

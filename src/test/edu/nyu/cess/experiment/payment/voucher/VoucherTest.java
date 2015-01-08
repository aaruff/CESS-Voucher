package edu.nyu.cess.experiment.payment.voucher;

import com.itextpdf.text.pdf.codec.wmf.Point;
import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Tests the Voucher class.
 */
public class VoucherTest extends TestCase
{
    /**
     * Test get items.
     */
    public void testGetItems()
    {
        Voucher voucher = new Voucher();
        ArrayList<Item> expectedItems = new ArrayList<Item>();
        expectedItems.add(new Item(new Point(0, 0), "$2.00"));
        voucher.addItem(expectedItems.get(0));
        expectedItems.add(new Item(new Point(10,10), "$3.00"));
        voucher.addItem(expectedItems.get(1));

        ArrayList<Item> receivedItems = voucher.getItems();

        assertEquals(expectedItems.size(), receivedItems.size());

        for (int i = 0; i < expectedItems.size(); ++i) {
            assertEquals(expectedItems.get(i), receivedItems.get(i));
        }
    }
}
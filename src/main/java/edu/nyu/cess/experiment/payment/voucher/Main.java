package edu.nyu.cess.experiment.payment.voucher;

import edu.nyu.cess.experiment.payment.voucher.io.ConfigurationFile;
import org.apache.log4j.Logger;

import javax.swing.*;

/**
 * The type Main.
 */
public class Main
{
    private static final Logger LOG = Logger.getLogger(ConfigurationFile.class);

    /**
     * Main void.
     *
     * @param args the args
     */
    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
            VoucherPrinterView voucherPrinterView = new VoucherPrinterView();
            voucherPrinterView.display();
            }
        });
	}
}
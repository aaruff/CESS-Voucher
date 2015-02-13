package edu.nyu.cess.experiment.payment.voucher;

import edu.nyu.cess.experiment.payment.voucher.io.ZTreePayFileConverter;
import edu.nyu.cess.experiment.payment.voucher.ui.MainPanel;
import edu.nyu.cess.experiment.payment.voucher.ui.PrinterMenu;
import org.apache.log4j.Logger;

import javax.swing.*;

public class VoucherPrinterView
{
    private JFrame viewFrame;
    private static final Logger LOG = Logger.getLogger(VoucherPrinterView.class);

    public VoucherPrinterView()
    {
        viewFrame = new JFrame();
    }

    public void display()
    {
        ZTreePayFileConverter payFileConverter = new ZTreePayFileConverter();
        MainPanel MainPanel = new MainPanel(payFileConverter);
        PrinterMenu menu = new PrinterMenu(viewFrame, MainPanel);

        setupLookAndFeel();

        viewFrame.setTitle("Z-Tree Payment Voucher Generator");
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.add(MainPanel);
        viewFrame.setJMenuBar(menu.getJMenuBar());
        viewFrame.setVisible(true);
        viewFrame.pack();
    }

    public void setupLookAndFeel()
    {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch(Exception e) {
            LOG.debug("Error setting Java Look and Feel: " + e);
        }
    }
}

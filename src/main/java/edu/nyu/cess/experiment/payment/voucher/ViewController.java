package edu.nyu.cess.experiment.payment.voucher;

import edu.nyu.cess.experiment.payment.voucher.ui.PrinterMenu;
import edu.nyu.cess.experiment.payment.voucher.io.ZTreePayFileConverter;
import edu.nyu.cess.experiment.payment.voucher.ui.MainPanel;

import javax.swing.*;

public class ViewController
{
    private JFrame viewFrame;

    public ViewController(JFrame viewFrame)
    {
        this.viewFrame = viewFrame;
    }

    public void displayGui()
    {
        viewFrame.setTitle("Z-Tree Payment Voucher Generator");

        ZTreePayFileConverter payFileConverter = new ZTreePayFileConverter();

        MainPanel MainPanel = new MainPanel(payFileConverter);

        PrinterMenu menu = new PrinterMenu(viewFrame, MainPanel);

        viewFrame.add(MainPanel);
        viewFrame.setJMenuBar(menu.getJMenuBar());
        viewFrame.setVisible(true);
        viewFrame.pack();
    }
}

package edu.nyu.cess.experiment.payment.voucher.printer;

import edu.nyu.cess.experiment.payment.voucher.printer.ui.PrinterMenu;
import edu.nyu.cess.experiment.payment.voucher.printer.io.ZTreePayFileConverter;
import edu.nyu.cess.experiment.payment.voucher.printer.ui.MainPanel;

import javax.swing.*;

public class Controller
{
    private JFrame viewFrame;

    public Controller(JFrame viewFrame)
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

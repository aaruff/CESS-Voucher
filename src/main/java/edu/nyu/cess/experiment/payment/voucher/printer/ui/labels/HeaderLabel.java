package edu.nyu.cess.experiment.payment.voucher.printer.ui.labels;

import javax.swing.*;
import java.awt.*;

public class HeaderLabel extends JLabel
{
    public HeaderLabel()
    {
        setText("CESS Lab Toolkit");
        setFont(new Font("Helvetica", Font.BOLD, 28));
        setForeground(new Color(19, 19, 33));
    }
}

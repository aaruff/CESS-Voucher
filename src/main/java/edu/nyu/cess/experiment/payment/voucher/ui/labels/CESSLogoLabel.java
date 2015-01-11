package edu.nyu.cess.experiment.payment.voucher.ui.labels;

import edu.nyu.cess.experiment.payment.voucher.ui.IconFactory;

import javax.swing.*;
import java.awt.*;

public class CESSLogoLabel extends JLabel
{
    public CESSLogoLabel()
    {
        setIcon(IconFactory.produceCessIcon());
        setFont(new Font("Helvetica", Font.BOLD, 28));
        setForeground(new Color(19, 19, 33));
    }
}

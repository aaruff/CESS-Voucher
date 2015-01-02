package edu.nyu.cess.payment.ui.labels;

import edu.nyu.cess.payment.ui.IconFactory;

import javax.swing.*;
import java.awt.*;

public class CESSLogoLabel extends JLabel
{
    public CESSLogoLabel()
    {
        setText("CESS Lab Toolkit");
        setIcon(IconFactory.produceCessIcon());
        setFont(new Font("Helvetica", Font.BOLD, 28));
        setForeground(new Color(19, 19, 33));
    }
}

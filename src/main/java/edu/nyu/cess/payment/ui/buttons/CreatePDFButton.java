package edu.nyu.cess.payment.ui.buttons;

import edu.nyu.cess.payment.ui.IconFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreatePDFButton extends JButton
{
    private String iconPath = "/images/pdf_ico.png";
    private String iconDescription = "PDF";

    public CreatePDFButton(ActionListener actionListener)
    {
        setText("Convert to Voucher PDF");
        setPreferredSize(new Dimension(190, 40));
        setIcon(IconFactory.createImageIcon(iconPath, iconDescription));
        addActionListener(actionListener);
    }
}

package edu.nyu.cess.payment.ui.buttons;

import edu.nyu.cess.payment.ui.IconFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreatePDFButton extends JButton
{
    public CreatePDFButton(ActionListener actionListener)
    {
        setText("Convert to Voucher PDF");
        setPreferredSize(new Dimension(190, 40));
        setIcon(IconFactory.producePdfIcon());
        addActionListener(actionListener);
    }
}

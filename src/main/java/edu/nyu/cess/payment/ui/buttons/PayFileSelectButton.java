package edu.nyu.cess.payment.ui.buttons;

import edu.nyu.cess.payment.ui.IconFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PayFileSelectButton extends JButton
{
    public PayFileSelectButton(ActionListener actionListener)
    {
        setText("Open File");
        setPreferredSize(new Dimension(190, 40));
        setIcon(IconFactory.openFileIcon());
        addActionListener(actionListener);
    }
}

package edu.nyu.cess.experiment.payment.voucher.ui.buttons;

import edu.nyu.cess.experiment.payment.voucher.ui.IconFactory;

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

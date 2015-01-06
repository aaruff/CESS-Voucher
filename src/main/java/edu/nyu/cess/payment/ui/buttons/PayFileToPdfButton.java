package edu.nyu.cess.payment.ui.buttons;

import edu.nyu.cess.payment.ui.IconFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The Pay file to pdf JButton.
 */
public class PayFileToPdfButton extends JButton
{
    /**
     * Instantiates a new Pay file to pdf button.
     *
     * @param actionListener the action listener
     */
    public PayFileToPdfButton(ActionListener actionListener)
    {
        setEnabled(false);
        setText("Convert to Voucher PDF");
        setPreferredSize(new Dimension(190, 40));
        setIcon(IconFactory.producePdfIcon());
        addActionListener(actionListener);
    }
}

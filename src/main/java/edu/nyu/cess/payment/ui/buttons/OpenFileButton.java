package edu.nyu.cess.payment.ui.buttons;

import edu.nyu.cess.payment.ui.IconFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class OpenFileButton extends JButton
{
    private String iconPath = "/images/file_open.png";
    private String iconDescription = "Open File";

    public OpenFileButton(ActionListener actionListener)
    {
        setText("Open File");
        setPreferredSize(new Dimension(190, 40));
        setIcon(IconFactory.createImageIcon(iconPath, iconDescription));
        addActionListener(actionListener);
    }
}

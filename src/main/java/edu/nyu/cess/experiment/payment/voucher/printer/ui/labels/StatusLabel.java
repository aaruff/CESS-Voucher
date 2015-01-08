package edu.nyu.cess.experiment.payment.voucher.printer.ui.labels;

import javax.swing.*;

public class StatusLabel extends JLabel
{
    public StatusLabel(LabelProperty labelProperty)
    {
        updateLabel(labelProperty);
    }

    public void updateLabel(LabelProperty labelProperty)
    {
        setIcon(labelProperty.getImageIcon());
        setForeground(labelProperty.getFontColor());
        setText(labelProperty.getLabelText());
    }
}

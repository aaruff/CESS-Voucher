package edu.nyu.cess.experiment.payment.voucher.ui.labels;

import edu.nyu.cess.experiment.payment.voucher.ui.IconFactory;

import java.awt.*;

public class ErrorLabelProperty extends LabelProperty
{
    public ErrorLabelProperty(String message)
    {
        labelText = message;
        imageIcon = IconFactory.errorIcon();
        fontColor =  Color.RED;
    }
}

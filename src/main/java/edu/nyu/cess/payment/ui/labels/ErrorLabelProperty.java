package edu.nyu.cess.payment.ui.labels;

import edu.nyu.cess.payment.ui.IconFactory;

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

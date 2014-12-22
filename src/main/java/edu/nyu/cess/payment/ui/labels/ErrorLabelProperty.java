package edu.nyu.cess.payment.ui.labels;

import edu.nyu.cess.payment.ui.IconFactory;

import java.awt.*;

public class ErrorLabelProperty extends LabelProperty
{
    private final String iconPath = "/images/error.png";
    private final String iconDescription = "Error";

    public ErrorLabelProperty(String message)
    {
        labelText = message;
        imageIcon = IconFactory.createImageIcon(iconPath, iconDescription);
        fontColor =  Color.RED;
    }
}

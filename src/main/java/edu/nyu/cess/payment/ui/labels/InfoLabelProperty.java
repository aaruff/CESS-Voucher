package edu.nyu.cess.payment.ui.labels;

import edu.nyu.cess.payment.io.IconFactory;

import java.awt.*;

/**
 * Information Label
 */
public class InfoLabelProperty extends LabelProperty
{
    private final String iconPath = "/images/info.png";
    private final String iconDescription = "Information";

    /**
     * Instantiates a new Info label property.
     */
    public InfoLabelProperty()
    {
        imageIcon = IconFactory.createImageIcon(iconPath, iconDescription);
        labelText = "Select \"Open File\" to set your payment file.";
        fontColor =  Color.BLACK;
    }
}

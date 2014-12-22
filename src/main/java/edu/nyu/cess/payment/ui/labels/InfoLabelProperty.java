package edu.nyu.cess.payment.ui.labels;

import edu.nyu.cess.payment.ui.IconFactory;

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
        init("Select \"Open File\" to set your payment file.");
    }

    public InfoLabelProperty(String labelText)
    {
        init(labelText);
    }

    private void init(String labelText)
    {
        this.labelText = labelText;
        imageIcon = IconFactory.createImageIcon(iconPath, iconDescription);
        fontColor =  Color.BLACK;
    }
}

package edu.nyu.cess.payment.ui.labels;

import edu.nyu.cess.payment.ui.IconFactory;

import java.awt.*;

/**
 * Information Label
 */
public class InfoLabelProperty extends LabelProperty
{
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
        imageIcon = IconFactory.produceInfoIcon();
        fontColor =  Color.BLACK;
    }
}

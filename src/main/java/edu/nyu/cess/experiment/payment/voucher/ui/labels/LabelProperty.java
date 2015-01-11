package edu.nyu.cess.experiment.payment.voucher.ui.labels;

import javax.swing.*;
import java.awt.*;

/**
 * The type Label property.
 */
public abstract class LabelProperty
{
    protected String labelText;
    protected Color fontColor;
    protected ImageIcon imageIcon;

    /**
     * Gets default font color.
     *
     * @return the default font color
     */
    public Color getFontColor()
    {
        return fontColor;
    }

    /**
     * Gets info icon.
     *
     * @return the info icon
     */
    public ImageIcon getImageIcon()
    {
        return imageIcon;
    }

    /**
     * Gets label text.
     *
     * @return the label text
     */
    public String getLabelText()
    {
        return labelText;
    }
}

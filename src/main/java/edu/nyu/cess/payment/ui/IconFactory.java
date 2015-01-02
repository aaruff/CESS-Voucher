package edu.nyu.cess.payment.ui;

import edu.nyu.cess.payment.ui.images.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * This class is used to generate image icons
 */
public class IconFactory extends ImageIcon
{
    /**
     * Creates an image icon given a path and its description. If the path is invalid an initialized ImageIcon is
     * returned.
     *
     * @param iconImage the icon image
     * @return image icon
     * @throws IOException
     */
    public static ImageIcon createImageIcon(IconImage iconImage)
    {
        try
        {
            Image image = ImageIO.read(IconFactory.class.getClassLoader().getResourceAsStream(iconImage.getPath()));
            return new ImageIcon(image, iconImage.getDescription());
        }
        catch (Exception e)
        {
            return new ImageIcon();
        }
    }

    /**
     * Produce next icon.
     *
     * @return the image icon
     */
    public static ImageIcon produceNextIcon()
    {
        return createImageIcon(new NextImage());
    }

    /**
     * Produce info icon.
     *
     * @return the image icon
     */
    public static ImageIcon produceInfoIcon()
    {
        return createImageIcon(new InfoImage());
    }

    /**
     * Produce cess icon.
     *
     * @return the image icon
     */
    public static ImageIcon produceCessIcon()
    {
        return createImageIcon(new CessImage());
    }

    /**
     * Produce pdf icon.
     *
     * @return the image icon
     */
    public static ImageIcon producePdfIcon()
    {
        return createImageIcon(new PdfImage());
    }

    /**
     * Open file icon.
     *
     * @return the image icon
     */
    public static ImageIcon openFileIcon()
    {
        return createImageIcon(new OpenFileImage());
    }

    /**
     * Error icon.
     *
     * @return the image icon
     */
    public static ImageIcon errorIcon()
    {
        return createImageIcon(new ErrorImage());
    }
}

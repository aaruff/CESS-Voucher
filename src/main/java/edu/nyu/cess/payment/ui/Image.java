package edu.nyu.cess.payment.ui;

import javax.swing.*;

/**
 * This class is used to retrieve and reference image icons.
 */
public class Image extends ImageIcon
{
    protected ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

}

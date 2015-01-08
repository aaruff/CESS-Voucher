package edu.nyu.cess.experiment.payment.voucher.printer.io;

import edu.nyu.cess.experiment.payment.voucher.printer.exceptions.InvalidFileSelectedException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class ZTreeJFileChooser
{
    private final static String EXTENSION_DESCRIPTION = "Z-Tree Pay Files";
    private final static String EXTENSION = "pay";

    private JFileChooser fileChooser;

    ConfigurationFile configFile = new ConfigurationFile();

    public ZTreeJFileChooser()
    {
        fileChooser = new JFileChooser(configFile.getPayoffPath());
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(EXTENSION_DESCRIPTION, EXTENSION));
        fileChooser.setAcceptAllFileFilterUsed(true);
    }

    public File openZTreePayoffDialogSelection(Component component) throws InvalidFileSelectedException
    {
        int returnVal = fileChooser.showOpenDialog(component);

        if (returnVal != fileChooser.APPROVE_OPTION) {
            throw new InvalidFileSelectedException("Error: Invalid format. Please select a Z-Tree payoff file.");
        }

        return fileChooser.getSelectedFile();
    }
}

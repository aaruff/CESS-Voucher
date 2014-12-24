package edu.nyu.cess.payment.ui;

import java.io.File;

/**
 * The interface for the File selection observer.
 */
public interface FileSelectionObserver extends ViewObserver
{
    /**
     * Update the observer with the selected file.
     *
     * @param file the file
     */
    public void updateFileSelection(File file);
}

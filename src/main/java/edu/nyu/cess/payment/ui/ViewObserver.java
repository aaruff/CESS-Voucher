package edu.nyu.cess.payment.ui;

import javax.swing.*;

/**
 * The view observer interface.
 */
public interface ViewObserver
{
    /**
     * Returns a reference to the JPanel implementing the interface.
     *
     * @return the j panel
     */
    public JPanel getJPanel();

    /**
     * Is called to update the callee with a status message.
     *
     * @param statusType the status type
     * @param message the message
     */
    public void updateStatus(StatusType statusType, String message);
}

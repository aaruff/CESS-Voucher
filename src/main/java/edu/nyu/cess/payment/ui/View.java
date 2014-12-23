package edu.nyu.cess.payment.ui;

import javax.swing.*;

/**
 * Created by aruff on 12/22/14.
 */
public interface View
{
    public JPanel getJPanel();

    public void updateStatus(StatusType statusType, String message);
}

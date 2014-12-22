package edu.nyu.cess.payment.ui.labels;

import edu.nyu.cess.payment.ui.StatusType;

/**
 * Builds label properties
 */
public class LabelPropertyFactory
{
    public static LabelProperty buildLabelProperty(StatusType statusType, String message)
    {

        LabelProperty property = null;
        switch (statusType) {
            case INFO:
                property = new InfoLabelProperty(message);
                break;
            case ERROR:
                property = new  ErrorLabelProperty(message);
        }

        return property;
    }
}

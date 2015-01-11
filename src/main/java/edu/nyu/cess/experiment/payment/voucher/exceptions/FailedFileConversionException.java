package edu.nyu.cess.experiment.payment.voucher.exceptions;

/**
 * The exception thrown when a file fails to be converted.
 */
public class FailedFileConversionException extends Exception
{
    public FailedFileConversionException(String message)
    {
        super(message);
    }
}

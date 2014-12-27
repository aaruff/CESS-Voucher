package edu.nyu.cess.payment.exceptions;

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

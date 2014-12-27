package edu.nyu.cess.payment.exceptions;

/**
 * The Exception that is thrown when I file has not been selected.
 */
public class FileNotSelectedException extends Exception
{
    public FileNotSelectedException(String message)
    {
        super(message);
    }
}

package edu.nyu.cess.payment.exceptions;

/**
 * The exception that occurs when an invalid file is selected.
 */
public class InvalidFileSelectedException extends Exception
{
    public InvalidFileSelectedException(String message){
        super(message);
    }
}

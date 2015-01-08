package edu.nyu.cess.experiment.payment.voucher.printer.exceptions;

/**
 * The exception that occurs when an invalid file is selected.
 */
public class InvalidFileSelectedException extends Exception
{
    public InvalidFileSelectedException(String message){
        super(message);
    }
}

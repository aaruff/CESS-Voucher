package edu.nyu.cess.experiment.payment.voucher;

import com.itextpdf.text.pdf.codec.wmf.Point;

/**
 * The voucher item.
 */
public class Item
{
    private String text;
    private Point position;

    /**
     * Gets text.
     *
     * @return the text
     */
    public String getText()
    {
        return text;
    }

    /**
     * Gets position.
     *
     * @return the position
     */
    public Point getPosition()
    {
        return position;
    }


    /**
     * Equals boolean.
     *
     * @param o the o
     * @return the boolean
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (!position.equals(item.position)) return false;
        if (!text.equals(item.text)) return false;

        return true;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode()
    {
        int result = text.hashCode();
        result = 31 * result + position.hashCode();
        return result;
    }

    /**
     * Instantiates a new Item.
     *
     * @param position the position
     * @param text the text
     */
    public Item(Point position, String text)
    {
        this.position = position;
        this.text = text;
    }
}

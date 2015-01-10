package edu.nyu.cess.experiment.payment.voucher;

import java.util.ArrayList;

/**
 * The type Voucher.
 */
public class Voucher
{
    private ArrayList<Item> items = new ArrayList<Item>();

    /**
     * Add item.
     *
     * @param item the item
     */
    public void addItem(Item item)
    {
        items.add(item);
    }

    /**
     * Gets items.
     *
     * @return the items
     */
    public ArrayList<Item> getItems()
    {
        return this.items;
    }

}

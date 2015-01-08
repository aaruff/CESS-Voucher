package edu.nyu.cess.experiment.payment.voucher;

import java.util.ArrayList;

public class Voucher
{
    private ArrayList<Item> items = new ArrayList<Item>();

    public void addItem(Item item)
    {
        items.add(item);
    }

    public ArrayList<Item> getItems()
    {
        return this.items;
    }

}

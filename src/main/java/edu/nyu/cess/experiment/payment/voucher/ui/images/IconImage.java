package edu.nyu.cess.experiment.payment.voucher.ui.images;

/**
 * The abstract image icon class.
 */
public abstract class IconImage
{
    private String path;
    private String description;

    public IconImage(String path, String description)
    {
        this.path = path;
        this.description = description;
    }

    /**
     * Returns the icon path
     *
     * @return String
     */
    public String getPath()
    {
        return path;
    }

    /**
     * Returns the icon description.
     *
     * @return String
     */
    public String getDescription()
    {
        return description;
    }
}

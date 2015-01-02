package edu.nyu.cess.payment.ui.images;

/**
 * The abstract image icon class.
 */
public abstract class IconImage
{
    private String path;
    private String description;

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

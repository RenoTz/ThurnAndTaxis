package model.beans;

import java.io.Serializable;

public class Actions implements Serializable
{

    private static final long serialVersionUID = -7823006335893925720L;

    private boolean takeOneCard;

    private boolean usePostMaster;

    private boolean usePostalCarrier;

    private boolean useAdministrator;

    private boolean useCartwright;

    public boolean isUsePostMaster()
    {
        return this.usePostMaster;
    }

    public void setUsePostMaster(final boolean usePostMaster)
    {
        this.usePostMaster = usePostMaster;
    }

    public boolean isUsePostalCarrier()
    {
        return this.usePostalCarrier;
    }

    public void setUsePostalCarrier(final boolean usePostalCarrier)
    {
        this.usePostalCarrier = usePostalCarrier;
    }

    public boolean isUseAdministrator()
    {
        return this.useAdministrator;
    }

    public void setUseAdministrator(final boolean useAdministrator)
    {
        this.useAdministrator = useAdministrator;
    }

    public boolean isUseCartwright()
    {
        return this.useCartwright;
    }

    public void setUseCartwright(final boolean useCartwright)
    {
        this.useCartwright = useCartwright;
    }

    public boolean isTakeOneCard()
    {
        return this.takeOneCard;
    }

    public void setTakeOneCard(final boolean takeOneCard)
    {
        this.takeOneCard = takeOneCard;
    }

}

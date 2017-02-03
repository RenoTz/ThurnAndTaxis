package data.beans;

public class Actions {
    
    private boolean takeOneCard;
    private boolean usePostMaster;
    private boolean usePostalCarrier;
    private boolean useAdministrator;
    private boolean useCartwright;

    public boolean isUsePostMaster() {
        return this.usePostMaster;
    }

    public void setUsePostMaster(boolean usePostMaster) {
        this.usePostMaster = usePostMaster;
    }

    public boolean isUsePostalCarrier() {
        return this.usePostalCarrier;
    }

    public void setUsePostalCarrier(boolean usePostalCarrier) {
        this.usePostalCarrier = usePostalCarrier;
    }

    public boolean isUseAdministrator() {
        return this.useAdministrator;
    }

    public void setUseAdministrator(boolean useAdministrator) {
        this.useAdministrator = useAdministrator;
    }

    public boolean isUseCartwright() {
        return this.useCartwright;
    }

    public void setUseCartwright(boolean useCartwright) {
        this.useCartwright = useCartwright;
    }
    
    public boolean isTakeOneCard() {
        return this.takeOneCard;
    }
    
    public void setTakeOneCard(boolean takeOneCard) {
        this.takeOneCard = takeOneCard;
    }
    
}

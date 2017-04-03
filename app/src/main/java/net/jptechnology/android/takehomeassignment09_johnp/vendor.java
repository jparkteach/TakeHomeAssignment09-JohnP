package net.jptechnology.android.takehomeassignment09_johnp;

public class vendor {
    private String name;
    private String logoUrl;
    private double exchangeRateYen;
    private double exchangeRateEuro;
    private double exchangeRateReal;
    private boolean freeShip;
    private boolean isPickupAvailable;

    public vendor() {
    }

    public vendor(String name, String logoUrl, double exchangeRateYen, double exchangeRateEuro, double exchangeRateReal, boolean freeShip, boolean isPickupAvailable) {
        this.name = name;
        this.logoUrl = logoUrl;
        this.exchangeRateYen = exchangeRateYen;
        this.exchangeRateEuro = exchangeRateEuro;
        this.exchangeRateReal = exchangeRateReal;
        this.freeShip = freeShip;
        this.isPickupAvailable = isPickupAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public double getExchangeRateYen() {
        return exchangeRateYen;
    }

    public void setExchangeRateYen(double exchangeRateYen) {
        this.exchangeRateYen = exchangeRateYen;
    }

    public double getExchangeRateEuro() {
        return exchangeRateEuro;
    }

    public void setExchangeRateEuro(double exchangeRateEuro) {
        this.exchangeRateEuro = exchangeRateEuro;
    }

    public double getExchangeRateReal() {
        return exchangeRateReal;
    }

    public void setExchangeRateReal(double exchangeRateReal) {
        this.exchangeRateReal = exchangeRateReal;
    }

    public boolean isFreeShip() {
        return freeShip;
    }

    public void setFreeShip(boolean freeShip) {
        this.freeShip = freeShip;
    }

    public boolean isPickupAvailable() {
        return isPickupAvailable;
    }

    public void setPickupAvailable(boolean pickupAvailable) {
        isPickupAvailable = pickupAvailable;
    }

    @Override
    public String toString() {
        return name + " " + exchangeRateYen + " " + exchangeRateEuro + " " + exchangeRateReal + "\n"
                + freeShip + " " + isPickupAvailable + "\n" + logoUrl;
    }
}

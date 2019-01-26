package sbt.data;

public class Transfer {

    private final int serviceId;
    private final int fromId;

    private boolean isConfirmed;

    public Transfer(int serviceId, int fromId) {
        this.serviceId = serviceId;
        this.fromId = fromId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public int getFromId() {
        return fromId;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }
}

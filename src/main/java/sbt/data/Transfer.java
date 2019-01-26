package sbt.data;

import org.apache.log4j.Logger;

public class Transfer {
    private static final Logger logger = Logger.getLogger(Transfer.class);


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

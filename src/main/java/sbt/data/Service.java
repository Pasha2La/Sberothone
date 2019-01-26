package sbt.data;

import org.apache.log4j.Logger;

public class Service {
    private static final Logger logger = Logger.getLogger(Service.class);


    private final String name;
    private final int serviceId;

    private final int accountId;
    private int cost;
    private String serviceDescription;

    public Service(String name, int id, int accountId) {
        this.name = name;
        this.serviceId = id;
        this.accountId = accountId;
    }


    public Service(String name, int id, int accountId, int cost) {
        this(name, id, accountId);
        this.cost = cost;
    }


    public String getName() {
        return name;
    }

    public int getServiceId() {
        return serviceId;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }
}

package sbt.data;

import org.apache.log4j.Logger;
import sbt.dao.Dao;

public class Transfer {
    private static final Logger logger = Logger.getLogger(Transfer.class);


    private int serviceId;
    private int fromId;

    private boolean isConfirmed;
}

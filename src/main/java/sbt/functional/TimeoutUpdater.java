package sbt.functional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sbt.dao.Dao;

@Component
@EnableScheduling
public class TimeoutUpdater {

    private static final Logger logger = Logger.getLogger(TimeoutUpdater.class);

    private final String SQL_UPDATE_VIEW_COUNT = "UPDATE sberfood_receipt SET n_view_count=0";

    @Autowired
    private Dao dao;

    @Scheduled(fixedDelay = 24 * 60 * 60 * 100)
    public void cleanViewCounters() {
        while (true) {
            try {
                dao.update(SQL_UPDATE_VIEW_COUNT);
                break;
            } catch (Exception e) {
                logger.error("Can't clean view counters" + e.getMessage());
            }
        }
    }
}

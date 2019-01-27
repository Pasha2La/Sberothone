package sbt.functional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sbt.dao.Dao;
import sbt.dao.model.Receipt;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class InfoUpdater {

    private static final Logger logger = Logger.getLogger(InfoUpdater.class);

    @Autowired
    private Dao dao;

    public void increaseReceiptCounter(final Long id) {
        Optional<Receipt> receipt = dao.getByIdReceipt(id);

        if (receipt.isPresent()) {
            dao.update("UPDATE sberfood_receipt SET n_view_count = n_view_count + 1 WHERE n_id = " + id);
        }
    }

    public List<Receipt> getMostPopularReceipt(final int count) {
        return dao.getSortByView().stream()
                .limit(count)
                .collect(Collectors.toList());
    }

    public List<Receipt> getMostPopularReceipt() {
        return getMostPopularReceipt(10);
    }
}

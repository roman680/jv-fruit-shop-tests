package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String createReport(Map<String, Integer> fruitStorage) {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry: fruitStorage.entrySet()) {
            reportBuilder.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}

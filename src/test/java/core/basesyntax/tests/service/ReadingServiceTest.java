package core.basesyntax.tests.service;

import static org.junit.Assert.assertEquals;

import core.basesyntax.service.ReadingService;
import core.basesyntax.service.impl.ReadingServiceImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class ReadingServiceTest {
    private static final String FILE_PATH
            = "src/test/java/test_resouces/test_read_from.csv";
    private ReadingService readingService;

    @Test
    public void readingService_CorrectPath_OK() {
        readingService = new ReadingServiceImpl();
        List<String> list = new ArrayList<>(Collections
                .singleton("type,fruit,quantity, b,banana,20, b,apple,100"));
        assertEquals(readingService.readFromFile(FILE_PATH).toString(), list.toString());
    }

    @Test (expected = RuntimeException.class)
    public void readingService_IncorrectPath_NotOk() {
        String filePath = "wrongPath";
        readingService.readFromFile(filePath);
    }

    @Test (expected = RuntimeException.class)
    public void readingService_Null_NotOk() {
        readingService.readFromFile(null);
    }

    @Test (expected = RuntimeException.class)
    public void readingService_Empty_NotOk() {
        String filePath = "";
        readingService.readFromFile(filePath);
    }
}

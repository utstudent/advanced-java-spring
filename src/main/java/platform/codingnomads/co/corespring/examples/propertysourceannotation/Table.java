package platform.codingnomads.co.corespring.examples.propertysourceannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Table {
    @Value("${table.height}")
    private int height;

    @Value("${table.length}")
    private int length;

    @Value("${table.width}")
    private int width;

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
}

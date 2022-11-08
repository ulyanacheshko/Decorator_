import java.io.IOException;

public class BaseDecorator implements DataSource {
    private DataSource ds;

    BaseDecorator(DataSource source) {
        this.ds = source;
    }

    @Override
    public void writeData(String data) throws IOException {
        ds.writeData(data);
    }

    @Override
    public String readData() throws IOException {
        return ds.readData();
    }
}
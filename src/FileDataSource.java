import java.io.*;
public class FileDataSource implements DataSource {
    private String name;
    public FileDataSource(String name) {
        this.name = name;
    }
    @Override
    public void writeData(String data) throws IOException {
        File file = new File(name);
        OutputStream fos = new FileOutputStream(file);
        fos.write(data.getBytes(), 0, data.length());
    }
    @Override
    public String readData() throws IOException {
        char[] buffer = null;
        File file = new File(name);
        FileReader reader = new FileReader(file);
        buffer = new char[(int) file.length()];
        reader.read(buffer);
        return new String(buffer);
    }
}
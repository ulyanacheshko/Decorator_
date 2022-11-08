import java.io.IOException;
import java.util.Base64;

public class EncryptDecorator extends BaseDecorator {

    static final byte[] KEYVALUE = "6^)(9-p35@%3#4S!4S0)$Y%%^&5(j.&^&o(*0)$Y%!#O@*GpG@=+@j.&6^)(0-=+".getBytes();
    static final int BUFFERLEN = 1024;

    EncryptDecorator(DataSource source) {
        super(source);
    }
    @Override
    public void writeData(String data) throws IOException {
        super.writeData(encode(data));
    }

    @Override
    public String readData() throws IOException {
        return decode(super.readData());
    }

    private String encode(String data) {
        int c, pos, keylen;
        pos = 0;
        keylen = KEYVALUE.length;
        byte buffer[] = data.getBytes();
        for (int i = 0; i < data.length(); i++) {
            buffer[i] ^= KEYVALUE[pos];
            pos++;
            if (pos == keylen)
                pos = 0;
        }
        return new String(buffer);
    }

    private String decode(String data) {
        int c, pos, keylen;
        pos = 0;
        keylen = KEYVALUE.length;
        byte buffer[] = data.getBytes();
        for (int i = 0; i < data.length(); i++) {
            buffer[i] ^= KEYVALUE[pos];
            pos++;
            if (pos == keylen) {
                pos = 0;
            }
        }
        return new String(buffer);
    }
}
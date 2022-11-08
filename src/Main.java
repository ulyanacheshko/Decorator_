import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String students = "Ivanov Ivan\nPetrov Victor\nSidorov Ilya";
        BaseDecorator encoded = new EncryptDecorator(
                new FileDataSource("out/Demo.txt"));
        encoded.writeData(students);
        DataSource plain = new FileDataSource("out/Demo.txt");

        System.out.println("input : ");
        System.out.println(students);
        System.out.println("encoded : ");
        System.out.println(plain.readData());
        System.out.println("decoded : ");
        System.out.println(encoded.readData());
    }
}

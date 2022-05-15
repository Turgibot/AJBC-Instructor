package ajbc.patterns.decorator;

public class Runner {
	public static void main(String[] args) {
        String salaryRecords = "Name,Salary\n"
        					+ "John Smith,100000\n"
        					+ "Steven Jobs,912000";
        DataSourceDecorator encoded =  new EncryptionDecorator(
        								new CompressionDecorator(
                                         new EncryptionDecorator(
                                           new FileDataSource("outputDemo.txt"))));
        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource("outputDemo.txt");

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());
    }
}

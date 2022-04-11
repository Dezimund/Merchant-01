package app;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Класс-входная точка в приложение.
// App launcher.
public class App {

    static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    static String merchantName;
    static String email;
    static String phone;
    static String productName;
    static int quantity;
    static double price;
    static String roundBonus;
    static ProductA product;
    static MerchantA merchantA;
    static String infoMerchant;
    static String infoProduct;

    // Делаем метод main() наименее загруженным логикой
    public static void main(String[] args) throws IOException {
        initVars();
        showData(processData());
    }

    // Инициализация переменных.
    // Имитация ввода данных пользователем.
    private static void initVars() throws IOException {
        System.out.println("Input Name");
        merchantName = READER.readLine();
        System.out.println("Input email");
        email = READER.readLine();
        System.out.println("Input phone");
        phone = READER.readLine();
        System.out.println("Input Product Name");
        productName = READER.readLine();
        System.out.println("Input quantity");
        quantity = Integer.parseInt(READER.readLine());
        System.out.println("Input price");
        price = Double.parseDouble(READER.readLine());
    }

    // Передача данных на обработку.
    // Вызовы методов через экземпляры классов
    // для получения результатов расчетов.
    // Здесь же получение расчета и округления бонуса.
    // Получение шаблона для вывода.
    private static String processData() {
        merchantA = new MerchantA(merchantName, phone, email);
        infoMerchant = merchantA.infoMerchant();
        product = new ProductA(productName, quantity, price);
        infoProduct = product.infoProduct();
        double sales = product.calcSales(quantity, price);
        roundBonus = Rounder.roundValue(merchantA.calcBonus(sales));
        return infoMerchant + infoProduct + "\nБонус (грн.): " + roundBonus;
    }

    // Вывод данных
    private static void showData(String output) {
        System.out.println(output);
    }
}

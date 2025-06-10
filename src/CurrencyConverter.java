import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        // Фиксированные курсы для примера
        exchangeRates.put("USD", 1.0);       // Базовая валюта
        exchangeRates.put("EUR", 0.92);
        exchangeRates.put("GBP", 0.78);
        exchangeRates.put("JPY", 156.20);
        exchangeRates.put("UZS", 12500.0);
        exchangeRates.put("RUB", 89.50);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Конвертер валют ===");

        while (true) {
            System.out.println("\nДоступные валюты: " + exchangeRates.keySet());

            System.out.print("Введите исходную валюту (например, USD): ");
            String fromCurrency = scanner.next().toUpperCase();

            System.out.print("Введите валюту назначения (например, EUR): ");
            String toCurrency = scanner.next().toUpperCase();

            if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
                System.out.println("Ошибка: Одна или обе валюты недоступны.");
                continue;
            }

            System.out.print("Введите сумму для конвертации: ");
            double amount = scanner.nextDouble();

            double convertedAmount = convert(fromCurrency, toCurrency, amount);
            System.out.printf("%.2f %s = %.2f %s\n", amount, fromCurrency, convertedAmount, toCurrency);

            System.out.print("Хотите продолжить? (y/n): ");
            char cont = scanner.next().charAt(0);
            if (cont != 'y' && cont != 'Y') {
                System.out.println("Выход из программы.");
                break;
            }
        }

        scanner.close();
    }

    private static double convert(String fromCurrency, String toCurrency, double amount) {
        double amountInUSD = amount / exchangeRates.get(fromCurrency);
        return amountInUSD * exchangeRates.get(toCurrency);
    }
}

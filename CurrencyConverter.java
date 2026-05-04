import java.util.Scanner;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CurrencyConverter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double amount, result = 0;
        int choice;

        System.out.println("===== CURRENCY CONVERTER =====");
        System.out.println("1. INR to USD");
        System.out.println("2. USD to INR");
        System.out.println("3. INR to EUR");
        System.out.println("4. EUR to INR");

        System.out.print("Choose option: ");
        choice = sc.nextInt();

        System.out.print("Enter amount: ");
        amount = sc.nextDouble();

        try {
            switch (choice) {

                case 1: // INR → USD
                    result = amount * getRate("INR", "USD");
                    System.out.println("Converted Amount: " + result + " USD");
                    break;

                case 2: // USD → INR
                    result = amount * getRate("USD", "INR");
                    System.out.println("Converted Amount: " + result + " INR");
                    break;

                case 3: // INR → EUR
                    result = amount * getRate("INR", "EUR");
                    System.out.println("Converted Amount: " + result + " EUR");
                    break;

                case 4: // EUR → INR
                    result = amount * getRate("EUR", "INR");
                    System.out.println("Converted Amount: " + result + " INR");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } catch (Exception e) {
            System.out.println("Error fetching exchange rate.");
        }

        sc.close();
    }

    // Method to fetch real-time exchange rate
    public static double getRate(String base, String target) throws Exception {

        String urlStr = "https://api.exchangerate-api.com/v4/latest/" + base;
        URL url = new URL(urlStr);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream())
        );

        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();

        String data = response.toString();

        // find rate manually (no JSON library)
        String search = "\"" + target + "\":";
        int index = data.indexOf(search);

        int start = index + search.length();
        int end = data.indexOf(",", start);

        return Double.parseDouble(data.substring(start, end));
    }
}
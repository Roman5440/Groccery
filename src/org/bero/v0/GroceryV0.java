package org.bero.v0;

import java.util.Scanner;

public class GroceryV0 implements Runnable {

    public void run() {

        String[] products = {"Хлеб", "Молоко", "Макароны"};
        int[] prices = {50, 200, 300};
        for(int i = 0; i < products.length; i++){
            System.out.println(i + 1  + "." + products[i] + " " + prices[i]);
        }
        int[] visitMarket = visitMarket(products.length);// то, что хочет купить пользователь
        int overallPrice = overallPrices(visitMarket, prices);
        System.out.println("Итоговый чек на сумму " + overallPrice);
        if (overallPrice == 0){
            System.out.println("Кажется вы забыли зачем пришли :)");
        }
    }

    public static int[] visitMarket(int productsLength){
        Scanner scanner = new Scanner(System.in);
        int[] productsCount = new int [productsLength];
        while(true) {

            System.out.println("Введите номер товара и его количество или слово end");
            String input = scanner.nextLine();
            if (input.equals("end")) break;

            String[] parts = input.split(" ");
            int productIdx = Integer.parseInt(parts[0]) - 1;
            int quantity = Integer.parseInt(parts[1]);
            productsCount[productIdx] = quantity;
        }
        return productsCount;
    }

    public static int overallPrices(int[] visitMarket, int[] prices){
        int sum = 0;
        for(int i = 0; i < prices.length; i++){
            sum += prices[i] * visitMarket[i];
        }
        return sum;
    }
}

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

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

        int[] productsCount = new int [productsLength];
        while(true) {
            Scanner scanner = new Scanner(System.in);
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
/*Вы пишете программу, планирующую продуктовую корзину.
У вас есть список доступных продуктов в одном массиве и соответствующая им цена в другом массиве.
Пользователь вводит номер продукта из первого списка и количество продуктов этого вида, которое хочет купить.
Программа добавляет указанное количество выбранного продукта в итоговую сумму продуктовой корзины.
Действие повторяется до тех пор, пока пользователь не введет команду "end".
Только после этого выводится вся корзина выбранных товаров и итоговая сумма.*/
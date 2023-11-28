package itog;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Итоговая работа
 *входной файл - xml, выходной - json
 *Itog-класс где само решение, answer1 и answer2 - классы для создания листов ответов
 */

public class Itog {
    public static void main(String[] args) throws Exception {
        // Чтение XML-файлов
        XmlMapper xmlMapper = new XmlMapper();

        File xmlFile1 = new File("src/Sellers.xml");
        SellerData SL = xmlMapper.readValue(xmlFile1, SellerData.class);

        File xmlFile2 = new File("src/Products.xml");
        ProductData PD = xmlMapper.readValue(xmlFile2, ProductData.class);

        File xmlFile3 = new File("src/Availability.xml");
        SellerProductData SPD = xmlMapper.readValue(xmlFile3, SellerProductData.class);

        File xmlFile4 = new File("src/Sold.xml");
        SalesData SD = xmlMapper.readValue(xmlFile4, SalesData.class);

        List<ProductInfo> answer1 = new ArrayList<>();
        List<TopDate> answer2 = new ArrayList<>();

        // Задача 1: Для каждого товара вывести в файл продавца с самой низкой ценой и саму цену
        Map<Integer, SellerHasProduct> lowestPriceMap = new HashMap<>();
        for (SellerHasProduct shp : SPD.getSellerHasProduct()) {
            int productId = shp.getIdProduct();
            if (!lowestPriceMap.containsKey(productId) || lowestPriceMap.get(productId).getprice() > shp.getprice()) {
                lowestPriceMap.put(productId, shp);
            }
        }
        for (Map.Entry<Integer, SellerHasProduct> entry : lowestPriceMap.entrySet()) {
            int productId = entry.getKey();
            SellerHasProduct shp = entry.getValue();
            int sellerId = shp.getIdSeller();

            // Получение информации о продавце по его ID
            Seller seller = getSellerById(SL, sellerId);

            // Создание объекта ProductInfo с именем и фамилией продавца
            ProductInfo ans = new ProductInfo(
                    PD.getProductById(productId).getTitle(),
                    (seller != null) ? seller.getFirstName() + " " + seller.getSecondName() : "",
                    shp.getprice()
            );
            answer1.add(ans);
        }
        // Запись ответа для Задачи 1 в файл
        ObjectMapper mapper1 = new ObjectMapper();
        ObjectWriter writer1 = mapper1.writer(new DefaultPrettyPrinter());
        writer1.writeValue(new File("src/task1.json"), answer1);

        // Задача 2: Вывести в файл топ 5 дат с наибольшим количеством проданных товаров
        Map<String, Integer> dateSoldMap = new HashMap<>();
        for (Sells s : SD.getSells()) {
            dateSoldMap.put(s.getSellData(), dateSoldMap.getOrDefault(s.getSellData(), 0) + s.getsold());
        }
        List<Map.Entry<String, Integer>> sortedDateSoldList = new ArrayList<>(dateSoldMap.entrySet());
        sortedDateSoldList.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));
        for (int i = 0; i < Math.min(5, sortedDateSoldList.size()); i++) {
            String date = sortedDateSoldList.get(i).getKey();
            answer2.add(new TopDate(date));
        }
        // Запись ответа для Задачи 2 в файл
        ObjectMapper mapper2 = new ObjectMapper();
        ObjectWriter writer2 = mapper2.writer(new DefaultPrettyPrinter());
        writer2.writeValue(new File("src/task2.json"), answer2);
    }

    private static Seller getSellerById(SellerData sellerData, int id) {
        for (Seller seller : sellerData.getSellers()) {
            if (seller.getId() == id) {
                return seller;
            }
        }
        return null;
    }
}

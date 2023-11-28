package itog;

public class ProductInfo {
    private String productName;
    private String sellerName; // Изменил тип переменной на String
    private int productPrise;

    public ProductInfo(String pN, String sN, int pp) {
        this.productName = pN;
        this.productPrise = pp;
        this.sellerName = sN;
    }

    public int getProductPrise() {
        return productPrise;
    }

    public String getProductName() {
        return productName;
    }

    public String getSellerName() { // Изменил тип возвращаемого значения на String
        return sellerName;
    }
}

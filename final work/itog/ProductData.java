package itog;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductData {
    private List<Product> listProduct;

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public Product getProductById(int productId) {
        for (Product product : listProduct) {
            if (product.getIdProduct() == productId) {
                return product;
            }
        }
        return null; // Если продукт не найден
    }
}

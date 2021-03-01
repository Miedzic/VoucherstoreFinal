package pl.mdziedzic.voucherstore.productcatalog;

import org.junit.Test;
import pl.mdziedzic.voucherstore.productcatalog.ListProductStorage;
import pl.mdziedzic.voucherstore.productcatalog.Product;
import pl.mdziedzic.voucherstore.productcatalog.ProductStorage;

import java.math.BigDecimal;
import java.util.UUID;


public class ListProductStorageTest {
    @Test
    public void itAllowStoreProduct() {
        Product p1 = thereIsProduct();
        ProductStorage storage = new ListProductStorage();

        storage.save(p1);

    }

    private Product thereIsProduct() {
        Product product = new Product(UUID.randomUUID());
        product.setPrice(BigDecimal.valueOf(10));

        return product;
    }
}

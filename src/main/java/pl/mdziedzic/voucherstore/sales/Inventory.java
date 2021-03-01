package pl.mdziedzic.voucherstore.sales;

public interface Inventory {
    boolean isAvailable(String productId);
}

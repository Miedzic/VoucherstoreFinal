package pl.mdziedzic.voucherstore.sales;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.mdziedzic.payu.PayU;
import pl.mdziedzic.payu.PayUCredentials;
import pl.mdziedzic.payu.http.JavaHttpPayUApiClient;
import pl.mdziedzic.voucherstore.productcatalog.ProductCatalogFacade;
import pl.mdziedzic.voucherstore.sales.basket.InMemoryBasketStorage;
import pl.mdziedzic.voucherstore.sales.offer.OfferMaker;
import pl.mdziedzic.voucherstore.sales.ordering.ReservationRepository;
import pl.mdziedzic.voucherstore.sales.payment.PayUPaymentGateway;
import pl.mdziedzic.voucherstore.sales.payment.PaymentGateway;
import pl.mdziedzic.voucherstore.sales.product.ProductCatalogProductDetailsProvider;
import pl.mdziedzic.voucherstore.sales.product.ProductDetailsProvider;

@Configuration
public class SalesConfiguration {

    @Bean
    SalesFacade salesFacade(ProductCatalogFacade productCatalogFacade, OfferMaker offerMaker, PaymentGateway paymentGateway, ReservationRepository reservationRepository) {
        return new SalesFacade(
                productCatalogFacade,
                new InMemoryBasketStorage(),
                () -> "customer_1",
                (productId) -> true,
                offerMaker,
                paymentGateway,
                reservationRepository);
    }

    @Bean
    PaymentGateway payUPaymentGateway() {
        return new PayUPaymentGateway(new PayU(
                PayUCredentials.productionOfEnv(),
                new JavaHttpPayUApiClient()
        ));
    }

    @Bean
    OfferMaker offerMaker(ProductDetailsProvider productDetailsProvider) {
        return new OfferMaker(productDetailsProvider);
    }

    @Bean
    ProductDetailsProvider productDetailsProvider(ProductCatalogFacade productCatalogFacade) {
        return new ProductCatalogProductDetailsProvider(productCatalogFacade);
    }
}

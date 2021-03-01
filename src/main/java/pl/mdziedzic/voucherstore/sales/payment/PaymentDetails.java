package pl.mdziedzic.voucherstore.sales.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class PaymentDetails {
    String reservationId;
    String paymentUrl;
    String paymentId;
}

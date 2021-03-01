package pl.mdziedzic.voucherstore.sales.payment;

import pl.mdziedzic.voucherstore.sales.ordering.Reservation;

import java.util.UUID;

public class DummyPaymentGateway implements PaymentGateway {
    @Override
    public PaymentDetails register(Reservation reservation) {
        return PaymentDetails.builder()
                .reservationId(reservation.getId())
                .paymentUrl("some_url")
                .paymentId(UUID.randomUUID().toString())
                .build();
    }

    @Override
    public boolean isTrusted(PaymentUpdateStatusRequest paymentUpdateStatusRequest) {
        return true;
    }
}

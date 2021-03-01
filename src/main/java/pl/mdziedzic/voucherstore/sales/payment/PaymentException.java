package pl.mdziedzic.voucherstore.sales.payment;

import pl.mdziedzic.payu.exceptions.PayUException;

public class PaymentException extends IllegalStateException {
    public PaymentException(PayUException e) {
        super(e);
    }
}

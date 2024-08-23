package com.uic.rentalservice.Util;

import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class PaymentRetryUtil {
    private static final int MAX_RETRIES = 3;
    private static final long RETRY_DELAY = 2000L; // 2 seconds

    public boolean retryPayment(Supplier<Boolean> paymentSupplier) throws InterruptedException {
        int attempts = 0;
        while (attempts < MAX_RETRIES) {
            if (paymentSupplier.get()) {
                return true;
            }
            attempts++;
            Thread.sleep(RETRY_DELAY);
        }
        return false;
    }
}

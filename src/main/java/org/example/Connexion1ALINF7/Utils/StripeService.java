package org.example.Connexion1ALINF7.Utils;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.param.ChargeCreateParams;
import com.stripe.param.CustomerCreateParams;

public class StripeService {

    private String apiKey = "sk_test_51P4UOD04wzCf273NSxlQbUyYV8Gr4o3E5JvcU1lWUJMHpLAwabS4SUs34bKDPQZF7UAcujDBhm1NGuU9Lkd4EoFB00ECZI46go";

    public StripeService() {
        Stripe.apiKey = apiKey;
    }

    public String createNewCustomer(String source, String email, String username) throws StripeException {
        CustomerCreateParams customerParams =
                CustomerCreateParams.builder()
                        .setSource(source)
                        .setEmail(email)
                        .setName(username)
                        .build();

        Customer customer = Customer.create(customerParams);
        return customer.getId();
    }

    public boolean chargeNewCustomer(String customerId, long amount) throws StripeException {

        ChargeCreateParams chargeParams =
                ChargeCreateParams.builder()
                        .setAmount(amount)
                        .setCurrency("eur")
                        .setCustomer(customerId)
                        .build();

        Charge charge = Charge.create(chargeParams);
        return charge.getId() != null;
    }


}

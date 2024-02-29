package at.ac.fhcampuswien;

import at.ac.fhcampuswien.ws.client.*;

public class Main {

    public static CurrencyConversionRequest buildCurrencyConversionRequest(String fromCurrency, double amount, String toCurrency){

        ObjectFactory factory = new ObjectFactory();
        CurrencyConversionRequest request = factory.createCurrencyConversionRequest();
        request.setAmount(amount);
        request.setFromCurrency(factory.createString(fromCurrency));
        request.setToCurrency(factory.createString(toCurrency));

        return request;
    }

    public static CurrencyConversionResult convertCurrency(CurrencyConversionRequest request){

        ICurrencyConverterService_Service service = new ICurrencyConverterService_Service();

        return service.getBasicHttpBindingICurrencyConverterService().convertCurrency(request);
    }

    public static void main(String[] args) {

        for(int i = 0; i < 10 ; i ++){
            CurrencyConversionRequest req = buildCurrencyConversionRequest("EUR", 250, "USD");
            CurrencyConversionResult res = convertCurrency(req);

            System.out.println("Converted:");
            System.out.println(res.getAmount());
            System.out.println(res.getCurrency().getValue());
        }

    }
}
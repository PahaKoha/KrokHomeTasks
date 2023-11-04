package Task7_Gerasimik_Pavel;

public class OrderReceiptDatIsOverdueException extends RuntimeException{
    @Override
    public String getMessage() {
        return "К сожалению дата получения заказа уже прошла!";
    }
}

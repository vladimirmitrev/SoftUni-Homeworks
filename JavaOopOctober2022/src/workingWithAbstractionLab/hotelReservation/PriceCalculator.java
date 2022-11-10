package workingWithAbstractionLab.hotelReservation;

public class PriceCalculator {

    public static double calculatePrice(double pricePerNight, int days, Season season, DiscountType discountType) {
        double totalPrice = pricePerNight * days * season.getMultiplier();

        totalPrice = totalPrice - totalPrice * (discountType.getPercent() / 100);

        return totalPrice;

    }
}

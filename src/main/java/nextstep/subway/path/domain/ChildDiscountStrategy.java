package nextstep.subway.path.domain;

public class ChildDiscountStrategy implements DiscountStrategy {

    @Override
    public int discount(int fare) {
        return (fare - COMMON_DISCOUNT_AMOUNT) / 2;
    }
}

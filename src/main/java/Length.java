public class Length {
    private final double value;
    private final String unit;
    public static final String FOOT = "f";
    private static final String YARD = "yard";

    public Length(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(String targetUnit) {
        Length result = this;
        final String FOOT = Length.FOOT;
        final String YARD = Length.YARD;
        final String INCH = "inch";
        if (this.unit.equals(FOOT)) {
            if (targetUnit.equals(YARD)) {
                result = new Length(this.value / 3, targetUnit);
            } else if (targetUnit.equals(INCH)) {
                result = new Length(this.value * 12, targetUnit);
            }
        }

        if (this.unit.equals(YARD)) {
            if (targetUnit.equals(INCH)) {
                result = new Length(this.value * 36, targetUnit);
            } else if (targetUnit.equals(FOOT)){
                result = new Length(this.value * 3, targetUnit);
            }
        }

        if (this.unit.equals(INCH)) {
            if (targetUnit.equals(FOOT)) {
                result = new Length(this.value / 12, targetUnit);
            } else if (targetUnit.equals(YARD)) {
                result = new Length(this.value / 36, targetUnit);
            }
        }

        return result;
    }

    public double getValue() {
        return this.value;
    }

    public String getUnit() {
        return this.unit;
    }
}

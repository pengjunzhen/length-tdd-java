public class Length {
    private final double value;
    private final String unit;
    public static final String FOOT = "foot";
    public static final String YARD = "yard";
    public static final String INCH = "inch";

    public Length(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(String targetUnit) {
        Unit temp_unit = null;
        if (targetUnit.equals(Length.INCH)) {
            temp_unit = Unit.INCH;
        } else if (targetUnit.equals(Length.YARD)) {
            temp_unit = Unit.YARD;
        } else if (targetUnit.equals(Length.FOOT)) {
            temp_unit = Unit.FOOT;
        }
        return temp_as(targetUnit, temp_unit);
    }

    public Length temp_as(String targetUnit, Unit temp_unit) {
        Length result = this;
        if (this.unit.equals(Length.FOOT)) {
            if (temp_unit == Unit.YARD) {
                result = new Length(this.value / 3, targetUnit);
            } else if (temp_unit == Unit.INCH) {
                result = new Length(this.value * 12, targetUnit);
            }
        }

        if (this.unit.equals(Length.YARD)) {
            if (temp_unit == Unit.INCH) {
                result = new Length(this.value * 36, targetUnit);
            } else if (temp_unit == Unit.FOOT){
                result = new Length(this.value * 3, targetUnit);
            }
        }

        if (this.unit.equals(Length.INCH)) {
            if (targetUnit.equals(Length.FOOT)) {
                result = new Length(this.value / 12, targetUnit);
            } else if (temp_unit == Unit.YARD) {
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

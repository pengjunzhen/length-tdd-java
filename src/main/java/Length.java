public class Length {
    private final double value;
    private final String unit;
    private final Unit temp_unit;
    public static final String FOOT = "foot";
    public static final String YARD = "yard";
    public static final String INCH = "inch";

    public Length(double value, String unit) {
        this(value, unit, temp_determineUnit(unit));
    }

    public Length(double value, String unit, Unit temp_unit) {
        this.value = value;
        this.unit = unit;
        this.temp_unit = temp_unit;
    }

    public static Unit temp_determineUnit(String targetUnit) {
        Unit temp_unit = null;
        if (targetUnit.equals(Length.INCH)) {
            temp_unit = Unit.INCH;
        } else if (targetUnit.equals(Length.YARD)) {
            temp_unit = Unit.YARD;
        } else if (targetUnit.equals(Length.FOOT)) {
            temp_unit = Unit.FOOT;
        }
        return temp_unit;
    }

    public Length temp_as(Unit temp_unit) {
        Length result = this;
        if (this.unit.equals(Length.FOOT)) {
            if (temp_unit == Unit.YARD) {
                result = new Length(this.value / 3, null, temp_unit);
            } else if (temp_unit == Unit.INCH) {
                result = new Length(this.value * 12, null, temp_unit);
            }
        }

        if (this.unit.equals(Length.YARD)) {
            if (temp_unit == Unit.INCH) {
                result = new Length(this.value * 36, null, temp_unit);
            } else if (temp_unit == Unit.FOOT){
                result = new Length(this.value * 3, null, temp_unit);
            }
        }

        if (this.unit.equals(Length.INCH)) {
            if (temp_unit == Unit.FOOT) {
                result = new Length(this.value / 12, null, temp_unit);
            } else if (temp_unit == Unit.YARD) {
                result = new Length(this.value / 36, null, temp_unit);
            }
        }

        return result;
    }

    public double getValue() {
        return this.value;
    }

    public Unit getUnit() {
        return temp_unit;
    }
}

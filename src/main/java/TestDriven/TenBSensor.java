package TestDriven;

public enum TenBSensor {

    SENSOR10BIT(10, 1022, 0);
    private final int SENSORBIT;
    private final int maxValue;
    private final int minValue;

    TenBSensor(int sensorbit, int maxValue, int minValue) {
        this.SENSORBIT = sensorbit;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getSENSORBIT() {
        return SENSORBIT;
    }
}

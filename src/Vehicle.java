public abstract class Vehicle {
    protected int[] coordinates;
    protected int[] colour;
    protected int facingAngle;
    protected int[] dimensions;

    public abstract int[] getCoordinates();

    public abstract int[] getColour();

    public abstract int getFacingAngle();

    public abstract int[] getDimensions();
}

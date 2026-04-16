public abstract class Vehicle {
    protected int[] coordinates;
    protected int[] colour;
    protected double facingAngleRad;
    protected int[] dimensions;

    public abstract int[] getCoordinates();

    public abstract int[] getColour();

    public abstract double getFacingAngleRad();

    public abstract int[] getDimensions();
}

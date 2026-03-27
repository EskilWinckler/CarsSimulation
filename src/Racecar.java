public class Racecar extends Vehicle implements PhysicsBasedVehicle {
    private int[] previousVector;
    private int thrustForce;
    private int mass;
    private int[] colour;
    private double facingAngleRad; // we might need this?
    private int[] coordinates;
    private int[] dimensions;

    public Racecar(int[] colour, int thrustForce, double facingAngleRad, int[] coordinates, int mass, int[] dimensions){
        this.colour = colour;
        this.thrustForce = thrustForce;
        this.facingAngleRad = facingAngleRad;
        this.coordinates = coordinates;
        this.mass = mass;
        this.dimensions = dimensions;
    }
    @Override
    public int[] getPreviousForceVector() {
        return previousVector;
    }

    @Override
    public int getThrustForce() {
        return thrustForce;
    }

    @Override
    public int getMass() {
        return mass;
    }

    @Override
    public int[] getCoordinates() {
        return coordinates;
    }

    @Override
    public int[] getColour() {
        return colour;
    }

    public double getFacingAngleRad() {
        return facingAngleRad;
    }
    @Override
    public int[] getDimensions() {
        return dimensions;
    }
}

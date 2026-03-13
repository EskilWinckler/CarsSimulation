public class Racecar implements PhysicsBasedVehicle, Vehicle {
    private int[] previousVector;
    private int thrustForce;
    private int mass;
    private int[] colour;
    private int facingAngle;
    private int[] coordinates;

    public Racecar(int[] colour, int facingAngle, int thrustForce, int[] coordinates, int mass){
        this.colour = colour;
        this.facingAngle = facingAngle;
        this.thrustForce = thrustForce;
        this.coordinates = coordinates;
        this.mass = mass;
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

    @Override
    public int getFacingAngle() {
        return facingAngle;
    }
}

public class Racecar implements PhysicsBasedVehicle, Vehicle {
    @Override
    public int[] getPreviousForceVector() {
        return new int[0];
    }

    @Override
    public int getThrustForce() {
        return 0;
    }

    @Override
    public int getMass() {
        return 0;
    }

    @Override
    public int[] getCoordinates() {
        return new int[0];
    }

    @Override
    public int[] getColour() {
        return new int[0];
    }

    @Override
    public int getFacingAngle() {
        return 0;
    }
}

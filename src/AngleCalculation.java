import java.util.*;

public class AngleCalculation {
    public double calculateThrustAngleByCurrentCoordinatesAndTarget(int[] currentCoordinates, int[] targetCoordinates) {
        int dx = targetCoordinates[0] - currentCoordinates[0];
        int dy = targetCoordinates[1] - currentCoordinates[1];
        double angleInRadians;
        if (dx > 0) {
            return calculateAngle(new int[]{dx, -dy});
        } else {
            return calculateAngle(new int[]{dx, -dy});
        }
    }

    public double calculateAngle(int[] coordinates) {
        if (coordinates[0] != 0) {
            // I don't know how any of this type casting works
            return Math.atan((double) coordinates[1] /coordinates[0]);
        } else if (coordinates[0] == 0 && coordinates[1] > 0) {
            // the reason I'm fine with type casting here is that the final angle value will be in integer degrees
            return (Math.PI/2);
        } else if (coordinates[0] == 0 && coordinates[1] < 0) {
            return (Math.PI*3/2);
        } else {
            return 0; // I don't think this else condition will ever hit, it's just here to get the IDE to shut up (I hope)
        }
    }
}

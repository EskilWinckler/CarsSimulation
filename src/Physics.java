public class Physics {
    public float[] sumVectors(float[][] vectorList) {
        // I don't think I need an ArrayList here but I do need higher-than integer precision, so I will be using floats for now
        float[] newVector = {0,0};
        for (int i = 0; i < vectorList.length; i++) {
            newVector[0] += vectorList[i][0];
            newVector[1] += vectorList[i][1];
        }
        return newVector;
    }

    public int[] updatePosition(int[] coordinates, float[] velocity, float dt) {
        float[] deltaCoordinates = {velocity[0]*dt, velocity[1]*dt};
        return new int[]{(int) (coordinates[0]+deltaCoordinates[0]), (int) (coordinates[0]+deltaCoordinates[0])};
    }

    public float[] getVectorFromForceAndAngle(double angle, int force) {
        // I have a strong feeling that we'll need to refactor the code to only use radians. (aka doubles)
        return new float[]{(float) (Math.cos(angle)*force), (float) (Math.sin(angle)*force)};
    }
}

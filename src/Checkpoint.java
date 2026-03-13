public class Checkpoint {
    int[] coordinates;

    public Checkpoint(int x, int y) {
        this.coordinates = new int[]{x, y};
    }

    public int[] getCoordinates() {
        return coordinates;
    }

}

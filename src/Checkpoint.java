public class Checkpoint {
    int[] coordinates;

    public Checkpoint(int x, int y) {
        this.coordinates = new int[]{x, y};
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    //private void hardCoded() {
    //    [[90,350],[600,100],[1110,350],[600,600]]
    //}
}

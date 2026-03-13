public class Racecar extends Vehicles{
    private Integer speed = getSpeed();
    private Integer direction = getDirection();
    private String color = getColor();
    private String team = null;
    private String gear = null;

    public Racecar(Integer speed, Integer direction, String color) {
        this.speed = speed;
        this.direction = direction;
        this.color = color;
        this.team = team;
    }

    public void move(Integer speed, String direction) {

    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
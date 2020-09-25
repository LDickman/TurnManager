import java.util.Objects;

public class SimpleActor implements Actor{
    private final String name;
    private final int speed;

    public SimpleActor(String name, int speed){
        this.name = name;
        this.speed = speed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor other = (SimpleActor) o;
        return other.getName().equals(name) && other.getSpeed() == speed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, speed);
    }
}

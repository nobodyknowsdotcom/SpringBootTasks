import lombok.Getter;
import lombok.Setter;

class example {
    @Getter
    @Setter
    String name = "John";

    @Override
    public String toString() {
        return "Hi, " + name + '!';
    }
}

import lombok.Getter;
import lombok.Setter;

class example {
    @Getter
    @Setter
    String name = "John";
    @Getter
    @Setter
    String secondName = "Somebody";

    @Override
    public String toString() {
        return "Hi, " + name +' '+secondName+'!';
    }
}

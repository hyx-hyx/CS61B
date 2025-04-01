import java.util.Comparator;

class Animal {
    int speak(Dog a) { return 1; }
    int speak(Animal a) { return 2; }
}
class Dog extends Animal {
    int speak(Animal a) { return 3; }
}
class Poodle extends Dog {
    int speak(Dog a) { return 4; }
}
public class DMSComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        int first = ((Animal)o1).speak(new Animal());
        int second = ((Animal)o2).speak(new Animal());
        int third = ((Animal)o1).speak(new Dog());
        int fourth = ((Animal)o2).speak(new Dog());
        if (first==second && third==fourth) {
            return 0;
        } else if (third>fourth) {
            return 1;
        } else {
            return-1;
        }
    }
}

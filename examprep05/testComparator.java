import org.junit.Test;

import static java.util.Objects.compare;

public class testComparator {
    @Test
    public void test(){
        DMSComparator dmsComparator=new DMSComparator();
        Animal animal = new Animal();
        Animal dog = new Dog();
        Animal poodle = new Poodle();
        System.out.println(dmsComparator.compare(animal, dog)); // negative number
        System.out.println(dmsComparator.compare(dog, dog)); // zero
        System.out.println(dmsComparator.compare(poodle, dog)); // positive numbe
    }
}

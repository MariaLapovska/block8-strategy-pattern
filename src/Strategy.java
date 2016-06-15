import java.util.List;
import java.util.LinkedList;

/**
 *
 */
public class Strategy {

    public static void main(String[] args) {
        Human human = new Human();
        human.setPlace(new NearBeast());
        human.doSomething();
        human.addPlace(new Riverside());
        human.doSomething();
        human.setPlace(new MushroomGlade());
        human.addPlace(new Riverside());
        human.doSomething();
    }
}

// Context
class Human {
    List<Place> places = new LinkedList<>();

    public void doSomething() {
        for (Place place : places) {
            place.doSomething(this);
        }
    }

    public void setPlace(Place place) {
        this.places.clear();
        this.places.add(place);
    }

    public void addPlace(Place place) {
        this.places.add(place);
    }

    void printActivity(){}
}

class Fisher extends Human {

    @Override
    void printActivity() {
        System.out.println("I am fisher");
    }
}

class Mushroomer extends Human {

    @Override
    void printActivity() {
        System.out.println("I am mushroomer");
    }
}

class Hunter extends Human {

    @Override
    void printActivity() {
        System.out.println("I am hunter");
    }
}

// State
interface Place {
    void doSomething(Human context);
}

class Riverside implements Place {

    @Override
    public void doSomething(Human context) {
        context = new Fisher();
        System.out.println("At the river");
        context.printActivity();
    }
}

class MushroomGlade implements Place {

    @Override
    public void doSomething(Human context) {
        context = new Mushroomer();
        System.out.println("At the mushroom field");
        context.printActivity();
    }
}

class NearBeast implements Place {

    @Override
    public void doSomething(Human context) {
        context = new Hunter();
        System.out.println("Near the beast");
        context.printActivity();
    }
}
package DesignPatternsExercise.proxyExample;

public class LionProxy implements Animal {

    Lion lion;

    public LionProxy() {
        this.lion = new Lion();
    }

    @Override
    public void speak() {
        System.out.println("Before speak method");
        lion.speak();
        System.out.println("After speak method");
    }
}

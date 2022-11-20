package DesignPatternsExercise.proxyExample;

public class Lion implements Animal{
    @Override
    public void speak() {
        System.out.println("Roar");
    }
}

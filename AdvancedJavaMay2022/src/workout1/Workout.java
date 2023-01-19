package workout1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public int getExerciseCount() {
        return exerciseCount;
    }
    public void addExercise(Exercise exercise) {
        if(exerciseCount > exercises.size() ) {
            exercises.add(exercise);
        }
    }
    public boolean removeExercise(String name, String muscle) {
        return this.exercises.removeIf(entry -> entry.getName().equals(name) && entry.getMuscle().equals(muscle));
    }

    public Exercise getExercise(String name, String muscle) {

        return this.exercises.stream()
                .filter(exercise -> exercise.getName().equals(name)
                        && exercise.getMuscle().equals(muscle))
                .findFirst()
                .orElse(null);
    }
    public Exercise getMostBurnedCaloriesExercise() {
        return this.exercises.stream().max(Comparator.comparingInt(Exercise::getBurnedCalories)).orElse(null);
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Workout type: ").append(getType()).append(System.lineSeparator());
        this.exercises.forEach(element -> sb.append(element).append(System.lineSeparator()));
        return sb.toString();
    }
    //Workout type: strength
//Exercise: Deadlift, back, 50
//Exercise: Squats, legs, 60

}

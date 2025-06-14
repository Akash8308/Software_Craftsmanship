## Fitness Tracking Application
### Problem Statement:
You are tasked with designing a simple fitness tracking application for individual users.
The system should help users log their workouts, track progress, and manage their exercises.

## Questions: 
1. Do we want Categories? (Running, Cycling, Swimming, Hiking, etc)
2. Do we want detailed stats?
3. Do we want report?
4. Do we allow user to delete workout?
5. Do we allow user to update workout?


### Class: User

- Attributes: id, name, age, weight, height, workout: list(workout)
- Behaviors: get/set(), updateworkout(), addWorkout(), viewReport()

### Class: Workout

- Attribute: id, workout (Enum), description, stats: list(stats)
- Behaviors: get/set(), update

### Enum: WorkoutTypes
{
  SWIMMING,
  HIKING,
  STRENGTH_TRAINING,
  CYCLING,
  YOGA
}

### Class: Stats
- Attributes: id, calories, timetaken, steps, distance, trends(Move, Walking pace, Runnning Pace, Distance)
- Behavior: get/set(), update()
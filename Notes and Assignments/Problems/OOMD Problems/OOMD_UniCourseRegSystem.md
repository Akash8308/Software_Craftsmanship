## Problem Statement: Managing a University Course Registration System

You need to design a system for a university to manage its course offerings,
student registrations, and instructor assignments.


### Analysis
- Course Offerings
- Student should be able to register
- Should be abble to assign Instructor for the course.


### Questions
1. Multiplpe instructor for single course?

### Classes
1. Course
   - Attributes: id : int, name: CourseName (Enum), description: String, duration: int, instructor : Instrucotr, studentCapacity : int
   - Behaviors: get/set, addCourse(), updateCourse(), isFull(), addStudent(), removeStudent(), getReport() - report of current status of enrolled students

[//]: # (2. User:)

[//]: # (   - Attributes: id : int, userName, passWord, courses : List<Course>)

[//]: # (   - Behaviors: get,set&#40;&#41;, registerStudent, registerInstructor&#40;&#41;)

3. Instructor:
   - Attributes: id : int, name: String: string, course : Course, capacity : int
   - Behaviors: get/set(), assignCourse(), removeCourse(), addInstructor(), isFull()

4. University
   - Attributes: id : int, name: String, student : <Student>, course : <Course>, instructor : <Instructor>
   - Behaviors: get/set(), 

5. Student:
   - Attributes: id : int, name: String, email : String, reisteredCourse : <course>, feesPaid : boolean
   - Behaviors: get/set(), registerForCourse(), cancelCourse(), payFees()

### Enums
1. CourseName : {MCA, BE, BTECH, CIVIL, etc}
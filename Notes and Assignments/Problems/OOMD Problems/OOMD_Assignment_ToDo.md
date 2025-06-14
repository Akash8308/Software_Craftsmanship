## We want to create a simple command-line application to manage a personal to-do list. The application should allow a user to: Add/View/Complete/Delete

### Classes
 #### 1. Task
    Members:

    int id

    String description
    
    boolean isCompleted

    boolean isPriority
    
    Methods:
    
    Constructor
    
    getId(), setId()
    
    getDescription(), setDescription()
    
    isCompleted()
    
    markCompleted()


#### 2. ToDoList
    Members:

    List<Task> tasks

    int nextId
    
    Methods:
    
    addTask(String description)
    
    viewTasks()
    
    completeTask(int id)
    
    deleteTask(int id)
    
    getTaskById(int id) (optional, for internal use)

### 3. ToDoApp
    Members:
    
    Scanner scanner
    
    ToDoList toDoList
    
    Methods:
    
    main(String[] args)
    
    printMenu()
    
    handleUserInput()
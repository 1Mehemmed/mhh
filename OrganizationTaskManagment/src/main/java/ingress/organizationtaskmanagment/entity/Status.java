package ingress.organizationtaskmanagment.entity;

public enum Status {
    ACTIVE("Task is active, but not running"),
    DONE("Task is done"),
    TODO("Task is running");
    private final String message;
    Status(String message){
        this.message= message;
    }
    @Override
    public String toString(){
        return message;
    }
}

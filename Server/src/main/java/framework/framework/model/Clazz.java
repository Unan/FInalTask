package framework.framework.model;

public class Clazz {

    private Integer integer;

    private String string = "string";


    public void init() {
        System.out.println(this);
    }

    public Clazz (Integer integer) {
        System.out.println(this);
        this.integer = integer;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "integer=" + integer +
                ", string='" + string + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Clazz clazz = new Clazz(10);
        System.out.println(clazz);
    }
}

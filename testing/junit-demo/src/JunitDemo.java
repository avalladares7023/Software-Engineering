public class JunitDemo {
    private String name;
    private boolean happy = false;

    public JunitDemo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isHappy() {
        return happy;
    }

    public void play() {
        happy = true;
    }
}

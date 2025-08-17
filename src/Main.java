public class Main {
    public static void main(String[] args) {
        Gameview view = new Gameview();
        GameController controller = new GameController(view);
        controller.run();
    }
}
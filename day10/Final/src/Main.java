public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();

        controller.addDefenceController(new Helicopter());
        controller.addDefenceController(new Tank());
        controller.addDefenceController(new Submarine());

        new DefenceSystem(controller);

    }
}
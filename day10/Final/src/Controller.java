import java.util.ArrayList;
import java.util.List;

public class Controller {
    List<DefenceController> defenceControllers = new ArrayList<>();

    public void addDefenceController(DefenceController defenceController) {
        defenceControllers.add(defenceController);
    }

    public void setArea(Boolean isClear){
        defenceControllers.forEach(defenceController -> {
            defenceController.isAreaClear(isClear);
        });
    }

    public void setMessage(String message){
        defenceControllers.forEach(defenceController -> {
            defenceController.messagePassing(message);
        });
    }

    public void setOption(Integer num){
        defenceControllers.forEach(defenceController -> {
            defenceController.position(num);
        });
    }

}

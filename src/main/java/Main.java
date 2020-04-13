import GUI.GUI;
import Model.Model;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        GUI view = new GUI(model);
        model.setView(view);
        view.setVisible(true);
    }
}

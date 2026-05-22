// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.layout.StackPane;
// import javafx.stage.Stage;

// public class Main extends Application {

//     @Override
//     public void start(Stage stage) {

//         Button button = new Button("JavaFX Working");

//         StackPane root = new StackPane(button);

//         Scene scene = new Scene(root, 400, 300);

//         stage.setScene(scene);

//         stage.setTitle("Hospital Management");

//         stage.show();
//     }

//     public static void main(String[] args) {

//         launch(args);
//     }   
// }

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        new PatientForm().start(stage);
    }

    public static void main(String[] args) {

        launch();
    }
}
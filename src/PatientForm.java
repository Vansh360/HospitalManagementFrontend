// import javafx.geometry.Insets;
// import javafx.scene.Scene;
// import javafx.scene.control.*;
// import javafx.scene.layout.VBox;
// import javafx.stage.Stage;

// public class PatientForm {

//     public void start(Stage stage) {

//         TextField nameField = new TextField();
//         nameField.setPromptText("Enter Name");

//         TextField ageField = new TextField();
//         ageField.setPromptText("Enter Age");

//         TextField diseaseField = new TextField();
//         diseaseField.setPromptText("Enter Disease");

//         Button saveBtn = new Button("Save Patient");

//         saveBtn.setOnAction(e -> {

//             String name = nameField.getText();

//             int age =
//                     Integer.parseInt(ageField.getText());

//             String disease =
//                     diseaseField.getText();

//             ApiService.savePatient(
//                     name,
//                     age,
//                     disease
//             );

//             Alert alert =
//                     new Alert(Alert.AlertType.INFORMATION);

//             alert.setContentText(
//                     "Patient Saved Successfully"
//             );

//             alert.show();
//         });

//         VBox root = new VBox(
//                 10,
//                 nameField,
//                 ageField,
//                 diseaseField,
//                 saveBtn
//         );

//         root.setPadding(new Insets(20));

//         Scene scene =
//                 new Scene(root, 350, 250);

//         stage.setScene(scene);

//         stage.setTitle("Hospital Management");

//         stage.show();
//     }
// }


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PatientForm {

    public void start(Stage stage) {

        TextField nameField = new TextField();
        nameField.setPromptText("Enter Name");

        TextField ageField = new TextField();
        ageField.setPromptText("Enter Age");

        TextField diseaseField = new TextField();
        diseaseField.setPromptText("Enter Disease");

        Button saveBtn = new Button("Save Patient");

        saveBtn.setOnAction(e -> {

            String name = nameField.getText();

            int age =
                    Integer.parseInt(ageField.getText());

            String disease =
                    diseaseField.getText();

            ApiService.savePatient(
                    name,
                    age,
                    disease
            );

            Alert alert =
                    new Alert(Alert.AlertType.INFORMATION);

            alert.setContentText(
                    "Patient Saved Successfully"
            );

            alert.show();
        });

        VBox root = new VBox(
                10,
                nameField,
                ageField,
                diseaseField,
                saveBtn
        );

        root.setPadding(new Insets(20));

        Scene scene =
                new Scene(root, 350, 250);

        stage.setScene(scene);

        stage.setTitle("Hospital Management");

        stage.show();
    }
}
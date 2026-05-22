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

// import javafx.application.Application;
// import javafx.stage.Stage;

// public class Main extends Application {

//     @Override
//     public void start(Stage stage) {

//         new PatientForm().start(stage);
//     }

//     public static void main(String[] args) {

//         launch();
//     }
// }


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        // ================= SIDEBAR =================

        Label menuTitle = new Label("HMS");

        menuTitle.setStyle(
                "-fx-font-size: 22px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: white;"
        );

        Button dashboardBtn = new Button("Dashboard");

        Button patientBtn = new Button("Patients");

        Button doctorBtn = new Button("Doctors");

        Button medicineBtn = new Button("Medicines");

        dashboardBtn.setMaxWidth(Double.MAX_VALUE);
        patientBtn.setMaxWidth(Double.MAX_VALUE);
        doctorBtn.setMaxWidth(Double.MAX_VALUE);
        medicineBtn.setMaxWidth(Double.MAX_VALUE);

        String sidebarButtonStyle =
                "-fx-background-color: transparent;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 15px;" +
                "-fx-alignment: CENTER-LEFT;" +
                "-fx-padding: 10 15 10 15;";

        dashboardBtn.setStyle(sidebarButtonStyle);
        patientBtn.setStyle(sidebarButtonStyle);
        doctorBtn.setStyle(sidebarButtonStyle);
        medicineBtn.setStyle(sidebarButtonStyle);

        VBox sidebar = new VBox(
                20,
                menuTitle,
                dashboardBtn,
                patientBtn,
                doctorBtn,
                medicineBtn
        );

        sidebar.setPadding(new Insets(20));

        sidebar.setPrefWidth(200);

        sidebar.setStyle(
                "-fx-background-color: #16213E;"
        );

        // ================= TOP TITLE =================

        Label title =
                new Label("Hospital Management Dashboard");

        title.setStyle(
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #16213E;"
        );

        // ================= PATIENT FORM =================

        TextField nameField = new TextField();
        nameField.setPromptText("Patient Name");

        TextField ageField = new TextField();
        ageField.setPromptText("Age");

        TextField diseaseField = new TextField();
        diseaseField.setPromptText("Disease");

        Button saveBtn = new Button("Save Patient");

        saveBtn.setStyle(
                "-fx-background-color: #00ADB5;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 10;"
        );

        // ================= TABLE =================

        TableView<Patient> table =
                new TableView<>();

        TableColumn<Patient, String> nameCol =
                new TableColumn<>("Name");

        nameCol.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );

        TableColumn<Patient, Integer> ageCol =
                new TableColumn<>("Age");

        ageCol.setCellValueFactory(
                new PropertyValueFactory<>("age")
        );

        TableColumn<Patient, String> diseaseCol =
                new TableColumn<>("Disease");

        diseaseCol.setCellValueFactory(
                new PropertyValueFactory<>("disease")
        );

        table.getColumns().addAll(
                nameCol,
                ageCol,
                diseaseCol
        );

        table.setPrefHeight(250);

        ObservableList<Patient> patientList =
                FXCollections.observableArrayList();

        table.setItems(patientList);

        // ================= BUTTON ACTION =================

      saveBtn.setOnAction(e -> {

    String name = nameField.getText();

    int age =
            Integer.parseInt(ageField.getText());

    String disease =
            diseaseField.getText();

    Patient patient =
            new Patient(name, age, disease);

    // Add to table
    patientList.add(patient);

    // Save to backend API
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

    // Clear fields
    nameField.clear();
    ageField.clear();
    diseaseField.clear();
});
        // ================= PIE CHART =================

        ObservableList<PieChart.Data> chartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Patients", 40),
                        new PieChart.Data("Doctors", 15),
                        new PieChart.Data("Medicines", 25)
                );

        PieChart chart = new PieChart(chartData);

        chart.setTitle("Hospital Analytics");

        chart.setPrefWidth(350);

        // ================= FORM SECTION =================

        VBox formSection = new VBox(
                15,
                title,
                nameField,
                ageField,
                diseaseField,
                saveBtn,
                table
        );

        formSection.setPadding(new Insets(20));

        formSection.setAlignment(Pos.TOP_CENTER);

        // ================= CENTER LAYOUT =================

        HBox centerContent = new HBox(
                20,
                formSection,
                chart
        );

        centerContent.setPadding(new Insets(20));

        // ================= ROOT =================

        BorderPane root = new BorderPane();

        root.setLeft(sidebar);

        root.setCenter(centerContent);

        root.setStyle(
                "-fx-background-color: #F5F7FA;"
        );

        // ================= SCENE =================

        Scene scene =
                new Scene(root, 1200, 700);

        stage.setTitle(
                "Hospital Management System"
        );

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}
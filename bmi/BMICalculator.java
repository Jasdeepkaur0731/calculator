import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BMICalculator {

    private TableView<BMIRange> table;
    private Label resultLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("BMI Calculator");

        Label weightLabel = new Label("Weight (kg):");
        TextField weightField = new TextField();
        HBox weightBox = new HBox(weightLabel, weightField);
        weightBox.setSpacing(10);

    
        Label heightLabel = new Label("Height (m):");
        TextField heightField = new TextField();
        HBox heightBox = new HBox(heightLabel, heightField);
        heightBox.setSpacing(10);

        Button calculateButton = new Button("Calculate BMI");
        calculateButton.setOnAction(event -> calculateBMI(weightField.getText(), heightField.getText()));

        resultLabel = new Label();

        table = new TableView<>();
        TableColumn<BMIRange, String> rangeColumn = new TableColumn<>("BMI Range");
        rangeColumn.setCellValueFactory(data -> data.getValue().rangeProperty());
        TableColumn<BMIRange, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(data -> data.getValue().statusProperty());
        table.getColumns().addAll(rangeColumn, statusColumn);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(weightBox, heightBox, calculateButton, resultLabel, table);

        VBox.setVgrow(table, Priority.ALWAYS);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateBMI(String weightText, String heightText) {
        try {
            double weight = Double.parseDouble(weightText);
            double height = Double.parseDouble(heightText);

            double bmi = weight / (height * height);
            resultLabel.setText("BMI: " + String.format("%.2f", bmi));

            highlightBMIRange(bmi);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input");
        }
    }

    private void highlightBMIRange(double bmi) {
        table.getSelectionModel().clearSelection();

        for (BMIRange range : table.getItems()) {
            if (bmi >= range.getLowerBound() && bmi < range.getUpperBound()) {
                table.getSelectionModel().select(range);
                break;
            }
        }
    }
}

class BMIRange {
    private final String range;
    private final String status;
    private final double lowerBound;
    private final double upperBound;

    public BMIRange(String range, String status, double lowerBound, double upperBound) {
        this.range = range;
        this.status = status;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public String getRange() {
        return range;
    }

    public String getStatus() {
        return status;
    }

    public double getLowerBound() {
        return lowerBound;
    }

    public double getUpperBound() {
        return upperBound;
    }

    public StringProperty rangeProperty() {
        return

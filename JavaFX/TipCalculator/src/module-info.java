module TipCalculator {

	requires javafx.base;
	requires javafx.graphics;
    requires javafx.fxml;
	requires javafx.controls;

	opens main to javafx.graphics, javafx.fxml;
	opens gui to javafx.graphics, javafx.fxml;
}
module dieren {
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;

	opens main to javafx.graphics,javafx.fxml, javafx.base, javafx.controls;
	opens gui to javafx.graphics,javafx.fxml, javafx.base, javafx.controls;
}
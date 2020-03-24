module FXVoorbeeld7_met_SceneBuilder {
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens main to javafx.graphics,javafx.fxml;
	opens gui to javafx.graphics,javafx.fxml;
}
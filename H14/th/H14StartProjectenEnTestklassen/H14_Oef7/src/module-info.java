module OO.Programmeren.II {
    exports gui;
    exports main;
    exports domein;

    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;

    opens main to javafx.graphics, javafx.fxml;
}
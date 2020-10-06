import com.alex.expiry.ExpiryDate;
import com.alex.expiry.LongExpiry;
import com.alex.expiry.RegularExpiry;
import com.alex.supermarket.*;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private static final Supermarket supermarket = new Supermarket("Carrefour Supermarket");
    private LinkedList<Product> inventory = new LinkedList<>();
    private TableView<Product> truckTable;
    private TableView<Product> shovelTable;
    private TableView<Product> milkTable;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle(supermarket.getSupermarketName());
        var box = new VBox();
        HBox hBox = new HBox();

        var changeToPrimaryScene = new Button("Back");
        var updateButton = new Button("Update quantity");
        var deleteProduct = new Button("Delete product");
        VBox menu = new VBox();
        menu.getChildren().addAll(changeToPrimaryScene, updateButton, deleteProduct);


        Image image = new Image(new FileInputStream("src/main/resources/careffour_picture.jpg"));
        ImageView imageView = new ImageView(image);
        imageView.setX(220);
        imageView.setY(-50);
        imageView.setFitHeight(300);
        imageView.setFitWidth(700);
        imageView.setPreserveRatio(true);

        Group root = new Group(imageView);

        var addTruck = new Button("Add Truck");
        var addShovel = new Button("Add Shovel");
        var addMilk = new Button("Add Milk");

        MenuButton menuButton = new MenuButton("Add products");
        menuButton.setFocusTraversable(false);
        menuButton.getItems().addAll(new MenuItem("", addTruck), new MenuItem("", addMilk), new MenuItem("", addShovel));

        var showAllProducts = new Button("Show All Products");
        var showAllTrucks = new Button("Show All Trucks");
        var showAllShovels = new Button("Show All Shovels");
        var showAllDiaryMilk = new Button("Show All Diary Milk");
        var checkExpiredMilk = new Button("Check for expired items");

        ArrayList<Button> buttons = new ArrayList<>();

        buttons.add(showAllProducts);
        buttons.add(showAllTrucks);
        buttons.add(showAllShovels);
        buttons.add(showAllDiaryMilk);
        buttons.add(checkExpiredMilk);
        buttons.add(addMilk);
        buttons.add(addShovel);
        buttons.add(addTruck);

        for(Button button : buttons){
            button.setFocusTraversable(false);
        }

        Alert a = new Alert(Alert.AlertType.NONE);




        showAllProducts.setOnAction(show -> {
            System.out.println(supermarket.showAllTrucks());
        });

        showAllTrucks.setOnAction(showTrucks ->{
            TableColumn<Product, String> brandColumn = new TableColumn<>("Brand Name");
            brandColumn.setMinWidth(200);
            brandColumn.setCellValueFactory(new PropertyValueFactory<>("brandName"));

            TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
            quantityColumn.setMinWidth(200);
            quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

            TableColumn<Product, Integer> wheelColumn = new TableColumn<>("Wheel Number");
            wheelColumn.setMinWidth(200);
            wheelColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfWheels"));

            TableColumn<Product, UUID> idColumn = new TableColumn<>("UUID");
            idColumn.setMinWidth(200);
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

            truckTable = new TableView<>();
            truckTable.setItems(getTrucksProduct());
            truckTable.getColumns().addAll(brandColumn, quantityColumn, wheelColumn, idColumn);

            HBox tableBox = new HBox();
            tableBox.getChildren().addAll(menu, truckTable);
            var tableScene = new Scene(tableBox, 1000, 480);

            primaryStage.setScene(tableScene);

        });

        showAllShovels.setOnAction(showTrucks ->{

            TableColumn<Product, String> brandColumn = new TableColumn<>("Brand Name");
            brandColumn.setMinWidth(150);
            brandColumn.setCellValueFactory(new PropertyValueFactory<>("brandName"));

            TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
            quantityColumn.setMinWidth(150);
            quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

            TableColumn<Product, Integer> materialColumn = new TableColumn<>("Material");
            materialColumn.setMinWidth(150);
            materialColumn.setCellValueFactory(new PropertyValueFactory<>("material"));

            TableColumn<Product, Integer> sizeColumn = new TableColumn<>("Size");
            sizeColumn.setMinWidth(150);
            sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));

            TableColumn<Product, UUID> idColumn = new TableColumn<>("UUID");
            idColumn.setMinWidth(150);
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

            shovelTable = new TableView<>();
            shovelTable.setItems(getShovelProduct());
            shovelTable.getColumns().addAll(brandColumn, quantityColumn, materialColumn, sizeColumn, idColumn);

            HBox tableBox = new HBox();
            tableBox.getChildren().addAll(menu, shovelTable);
            var tableScene = new Scene(tableBox, 1000, 480);

            primaryStage.setScene(tableScene);
        });

        showAllDiaryMilk.setOnAction(showTrucks ->{
            TableColumn<Product, String> brandColumn = new TableColumn<>("Brand Name");
            brandColumn.setMinWidth(150);
            brandColumn.setCellValueFactory(new PropertyValueFactory<>("brandName"));

            TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
            quantityColumn.setMinWidth(150);
            quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

            TableColumn<Product, ExpiryDate> expiryColumn = new TableColumn<>("Expiry Date");
            expiryColumn.setMinWidth(150);
            expiryColumn.setCellValueFactory(new PropertyValueFactory<>("expiryDate"));


            TableColumn<Product, UUID> idColumn = new TableColumn<>("UUID");
            idColumn.setMinWidth(150);
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

            milkTable = new TableView<>();
            milkTable.setItems(getMilkProduct());
            milkTable.getColumns().addAll(brandColumn, quantityColumn, expiryColumn, idColumn);

            HBox tableBox = new HBox();
            tableBox.getChildren().addAll(menu, milkTable);
            var tableScene = new Scene(tableBox, 1000, 480);

            primaryStage.setScene(tableScene);
        });

        addTruck.setOnAction(add -> {
            Stage popupwindow =new Stage();
            popupwindow.initModality(Modality.APPLICATION_MODAL);
            popupwindow.setTitle("Add Truck");


            ObservableList<String> brandOption =
                    FXCollections.observableArrayList(
                            "Mercedes Benz",
                            "Volvo Trucks",
                            "MAN",
                            "ELVO",
                            "Ford",
                            "BMW",
                            "Mann",
                            "Skoda",
                            "BMC",
                            "Iveco",
                            "Avia Trucks",
                            "Other"
                    );

            ObservableList<Integer> wheelNumberOption =
                    FXCollections.observableArrayList(
                            4,
                            6,
                            8,
                            10,
                            12,
                            16
                    );

            final ComboBox brandComboBox = new ComboBox(brandOption);
            brandComboBox.setPromptText("Choose brand");

            final ComboBox wheelNumberComboBox = new ComboBox(wheelNumberOption);
            wheelNumberComboBox.setPromptText("Choose wheel number");

            Label quantityLabel = new Label("Quantity : ");
            TextField quantity = new TextField();
            quantity.setMaxWidth(200);


            Button enter= new Button("Enter");

            enter.setOnAction(e -> {
                int truckQuantity = Integer.parseInt(quantity.getText());
                int wheelNumber = Integer.parseInt(wheelNumberComboBox.getValue().toString());
                supermarket.addProducts(new Truck(brandComboBox.getValue().toString(), truckQuantity, wheelNumber));
                popupwindow.close();
            });

            VBox layout= new VBox(10);


            HBox quantityLayout = new HBox();
            quantityLayout.getChildren().addAll(quantityLabel, quantity);
            quantityLayout.setAlignment(Pos.CENTER);



            layout.getChildren().addAll(brandComboBox, quantityLayout, wheelNumberComboBox, enter);

            layout.setAlignment(Pos.CENTER);

            Scene scene1= new Scene(layout, 400, 150);

            popupwindow.setScene(scene1);


            popupwindow.showAndWait();
        });

        addShovel.setOnAction(add -> {
            Stage popupwindow =new Stage();
            popupwindow.initModality(Modality.APPLICATION_MODAL);
            popupwindow.setTitle("Add Shovel");

            Label quantityLabel = new Label("Quantity : ");
            TextField quantity = new TextField();
            quantity.setMaxWidth(200);

            ObservableList<String> brandOption =
                    FXCollections.observableArrayList(
                            "Dedeman",
                            "Ikea",
                            "Arabesque",
                            "MatHouse",
                            "Brico Store",
                            "Leroy Merlin",
                            "Praktiker",
                            "Hornbach",
                            "Interhome",
                            "Other"
                    );

            ObservableList<String> materialOptions =
                    FXCollections.observableArrayList(
                            "plastic",
                            "steel",
                            "aluminium"
                    );

            ObservableList<String> sizeOptions =
                    FXCollections.observableArrayList(
                            "small",
                            "normal",
                            "big"
                    );
            final ComboBox brandComboBox = new ComboBox(brandOption);
            brandComboBox.setPromptText("Choose brand");

            final ComboBox materialComboBox = new ComboBox(materialOptions);
            materialComboBox.setPromptText("Choose material type");

            final ComboBox sizeComboBox = new ComboBox(sizeOptions);
            sizeComboBox.setPromptText("Choose size");


            Button enter= new Button("Enter");

            enter.setOnAction(e -> {
                int shovelQuantity = Integer.parseInt(quantity.getText());
                if(materialComboBox.getValue().equals("plastic") && sizeComboBox.getValue().equals("small")){
                    supermarket.addProducts(new Shovel(brandComboBox.getValue().toString(), shovelQuantity, Shovel.ShovelMaterial.PLASTIC, Shovel.ShovelSize.SMALL));
                }else if(materialComboBox.getValue().equals("plastic") && sizeComboBox.getValue().equals("normal")){
                    supermarket.addProducts(new Shovel(brandComboBox.getValue().toString(), shovelQuantity, Shovel.ShovelMaterial.PLASTIC, Shovel.ShovelSize.NORMAL));
                }else if(materialComboBox.getValue().equals("plastic") && sizeComboBox.getValue().equals("big")){
                    supermarket.addProducts(new Shovel(brandComboBox.getValue().toString(), shovelQuantity, Shovel.ShovelMaterial.PLASTIC, Shovel.ShovelSize.BIG));
                }else if(materialComboBox.getValue().equals("steel") && sizeComboBox.getValue().equals("small")){
                    supermarket.addProducts(new Shovel(brandComboBox.getValue().toString(), shovelQuantity, Shovel.ShovelMaterial.STEEL, Shovel.ShovelSize.SMALL));
                }else if(materialComboBox.getValue().equals("steel") && sizeComboBox.getValue().equals("normal")){
                    supermarket.addProducts(new Shovel(brandComboBox.getValue().toString(), shovelQuantity, Shovel.ShovelMaterial.STEEL, Shovel.ShovelSize.NORMAL));
                }else if(materialComboBox.getValue().equals("steel") && sizeComboBox.getValue().equals("big")){
                    supermarket.addProducts(new Shovel(brandComboBox.getValue().toString(), shovelQuantity, Shovel.ShovelMaterial.STEEL, Shovel.ShovelSize.BIG));
                }else if(materialComboBox.getValue().equals("aluminium") && sizeComboBox.getValue().equals("small")){
                    supermarket.addProducts(new Shovel(brandComboBox.getValue().toString(), shovelQuantity, Shovel.ShovelMaterial.ALUMINIUM, Shovel.ShovelSize.SMALL));
                }else if(materialComboBox.getValue().equals("aluminium") && sizeComboBox.getValue().equals("normal")){
                    supermarket.addProducts(new Shovel(brandComboBox.getValue().toString(), shovelQuantity, Shovel.ShovelMaterial.ALUMINIUM, Shovel.ShovelSize.NORMAL));
                }else if(materialComboBox.getValue().equals("aluminium") && sizeComboBox.getValue().equals("big")){
                    supermarket.addProducts(new Shovel(brandComboBox.getValue().toString(), shovelQuantity, Shovel.ShovelMaterial.ALUMINIUM, Shovel.ShovelSize.BIG));
                }else{
                    System.out.println("wrong material / size");
                }

                popupwindow.close();
            });

            VBox layout= new VBox(10);

            HBox quantityLayout = new HBox();
            quantityLayout.getChildren().addAll(quantityLabel, quantity);
            quantityLayout.setAlignment(Pos.CENTER);

            layout.getChildren().addAll(brandComboBox, quantityLayout, materialComboBox, sizeComboBox, enter);

            layout.setAlignment(Pos.CENTER);

            Scene scene1= new Scene(layout, 600, 250);

            popupwindow.setScene(scene1);

            popupwindow.showAndWait();
        });


        addMilk.setOnAction(add -> {
            Stage popupwindow =new Stage();
            popupwindow.initModality(Modality.APPLICATION_MODAL);
            popupwindow.setTitle("Add Milk");


            ObservableList<String> brandOption =
                    FXCollections.observableArrayList(
                            "Napolact",
                            "Covalact",
                            "Zuzu",
                            "La Dorna",
                            "Hochland",
                            "Delaco",
                            "Olympus",
                            "Fulga",
                            "Milli",
                            "Oke",
                            "Other"
                    );

            ObservableList<String> typeOption =
                    FXCollections.observableArrayList(
                            "Long Lasting",
                            "Regular"
                    );

            final ComboBox brandComboBox = new ComboBox(brandOption);
            brandComboBox.setPromptText("Choose brand");

            final ComboBox typeComboBox = new ComboBox(typeOption);
            typeComboBox.setPromptText("Choose Type of milk");

            Label quantityLabel = new Label("Quantity : ");
            TextField quantity = new TextField();
            quantity.setMaxWidth(200);

            Label expiryDateLabel = new Label("Expiry date :");
            TextField expiryDate = new TextField();
            expiryDate.setMaxWidth(200);


            AtomicInteger year = new AtomicInteger();
            AtomicInteger month = new AtomicInteger();
            AtomicInteger day = new AtomicInteger();


            DatePicker datePicker = new DatePicker();
            datePicker.setOnAction(event -> {
                LocalDate date = datePicker.getValue();
                year.set(date.getYear());
                month.set(date.getMonthValue());
                day.set(date.getDayOfMonth());

            });

            Button enter= new Button("Enter");

            enter.setOnAction(e -> {
                int milkQuantity = Integer.parseInt(quantity.getText());
                if(typeComboBox.getValue().equals("Long Lasting")){
                    supermarket.addProducts(new LongLastingMilk(brandComboBox.getValue().toString(), milkQuantity, new LongExpiry(year, month, day)));
                }else if(typeComboBox.getValue().equals("Regular")){
                    supermarket.addProducts(new RegularDairyMilk(brandComboBox.getValue().toString(), milkQuantity, new RegularExpiry(month, year)));
                }
                popupwindow.close();
            });

            VBox layout= new VBox(10);


            HBox quantityLayout = new HBox();
            quantityLayout.getChildren().addAll(quantityLabel, quantity);
            quantityLayout.setAlignment(Pos.CENTER);


            HBox expiryDateLayout = new HBox();
            expiryDateLayout.getChildren().addAll(expiryDateLabel, datePicker);
            expiryDateLayout.setAlignment(Pos.CENTER);

            layout.getChildren().addAll(brandComboBox, quantityLayout, typeComboBox, expiryDateLayout, enter);

            layout.setAlignment(Pos.CENTER);

            Scene scene1= new Scene(layout, 600, 250);

            popupwindow.setScene(scene1);


            popupwindow.showAndWait();
        });


        hBox.getChildren().addAll(menuButton, showAllProducts, showAllTrucks, showAllShovels, showAllDiaryMilk, checkExpiredMilk);
        hBox.setSpacing(15);

        var elements = box.getChildren();
        var scene = new Scene(box, 1000, 480);

        elements.addAll(hBox);


        changeToPrimaryScene.setOnAction(change -> {
            primaryStage.setScene(scene);
        });

        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public ObservableList<Product> getTrucksProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.addAll(supermarket.showAllTrucks());
        return products;
    }

    public ObservableList<Product> getShovelProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.addAll(supermarket.showAllShovels());
        return products;
    }

    public ObservableList<Product> getMilkProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.addAll(supermarket.showAllDiaryProducts());
        return products;
    }
}

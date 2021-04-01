package sample;

import com.mysql.cj.protocol.Resultset;
import com.sun.javafx.binding.SelectBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;




import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * This is the File where the most all of the decision happen with the exception of internationalization, that is done in the Main.java file. Variables are at the top and Methods can be found at the bottom
 */

/**
 *
 * @author Robert Bradbury
 */

/**
 *RUNTIME ERROR
 * Had difficulty setting up multiple scenes/windows. I Wanted to reuse many of the class members I had already created but when I did the window would not display recycled/re-used items. So in the interest of getting this
 * PA done, I went ahead and created a lot of redundant members. Clearly not optimal, but I was able to keep moving
 *
 * FUTURE ENHANCEMENT
 *
 * A lot of the SQL sessions are left to timeout on their own, forcing the local system to waste cpu and memory on connections that are no longer being used. Need to close them properly
 * @author Robert Bradbury
 */

public class Controller implements Initializable {


    /**
     * Controls such as buttons
     */

    MySQL_Connection Conn2MySQL = new MySQL_Connection();
    ObservableList<Customers> CustomerList = FXCollections.observableArrayList();
    ObservableList<Appointments> AppointmentList = FXCollections.observableArrayList();
    ObservableList<Appointments> ReportsList = FXCollections.observableArrayList();
    ObservableList<Appointments> ReportsList2 = FXCollections.observableArrayList();
    ObservableList<Appointments> ReportsLis3 = FXCollections.observableArrayList();
    ObservableList<Integer> CustomerIDList = FXCollections.observableArrayList();
    ObservableList<Integer> UserIDList = FXCollections.observableArrayList();
    ObservableList<String> ContactIDList = FXCollections.observableArrayList();
    ObservableList<String> ChoiceListCustomerState = FXCollections.observableArrayList();
    LocalDateTime localNowTimeDate = LocalDateTime.now();
    LocalDateTime updateAppointmentRecord = LocalDateTime.now(ZoneOffset.UTC);
    /**
     * FXML for Customers
     */
    @FXML
    Button TabCustomers, TabAppointments, TabExit, TabReports, btCustomerInsert, btCustomerUpdate, btCustomerDelete;
    @FXML
    TextField tfCustomerName, tfCustomerAddress, tfCustomerZIP, tfCustomerPhone, tfCustomerID;
    @FXML
    String Username = "test";
    @FXML
    String Password = "test";
    @FXML
    TableView<Customers> tableViewCustomer;
    @FXML
    TableColumn<Customers, Integer> tvCustomerID;
    @FXML
    TableColumn<Customers, String> tvCustomerName;
    @FXML
    TableColumn<Customers, String> tvCustomerAddress;
    @FXML
    TableColumn<Customers, String> tvCustomerZIP;
    @FXML
    TableColumn<Customers, String> tvCustomerPhone;
    @FXML
    TableColumn<Customers, String> tvCustomerCreate;
    @FXML
    TableColumn<Customers, String> tvCustomerCreateBy;
    @FXML
    TableColumn<Customers, String> tvCustomerUpdated;
    @FXML
    TableColumn<Customers, String> tvCustomerUpdatedBy;
    @FXML
    TableColumn<Customers, String> tvCustomerCreateDate;
    @FXML
    TableColumn<Customers, String> tvCustomerDivID;
    @FXML
    ChoiceBox<String> choiceBoxCountry;
    @FXML
    ChoiceBox<String> choiceBoxState;

    // FXML for Appointments-------------------------------------------------------------
    /**
     * FXML for Appointments
     */
    @FXML
    Button btAppointmentInsert, btAppointmentUpdate, btAppointmentDelete, btAppointmentSave;
    @FXML
    TableView<Appointments> tableViewAppointments;
    @FXML
    TableColumn<Appointments, Integer> tvAppointmentID;
    @FXML
    TableColumn<Appointments, String> tvAppointmentTitle;
    @FXML
    TableColumn<Appointments, Integer> tvAppointmentDescription;
    @FXML
    TableColumn<Appointments, String> tvAppointmentLocation;
    @FXML
    TableColumn<Appointments, String> tvAppointmentType;
    @FXML
    TableColumn<Appointments, String> tvAppointmentStart;
    @FXML
    TableColumn<Appointments, String> tvAppointmentEnd;
    @FXML
    TableColumn<Appointments, Integer> tvAppointmentCustomer_ID;
    @FXML
    TableColumn<Appointments, Integer> tvAppointmentUser;
    @FXML
    TableColumn<Appointments, Integer> tvAppointmentContact;
    @FXML
    TableColumn<Appointments, Integer> tvAppointmentUpdated;
    @FXML
    TextField txAppointmentID, txAppointmentTitle, txAppointmentDescription, txAppointmentLocation, txAppointmentType, txAppointmentStart, txAppointmentEnd;
    @FXML
    ChoiceBox<Integer> choiceFromAppointmentsGetCustID;
    @FXML
    ChoiceBox<Integer> choiceFromAppointmentsGetUserID;
    @FXML
    ChoiceBox<String> choiceFromAppointmentsGetContactID;
    @FXML
    RadioButton AptAllTableView, AptWeekTableView, AptMonthTableView;
    @FXML
    ToggleGroup AptViews;

    // FXML for Login-------------------------------------------------------------
    /**
     * FXML for Login
     */
    @FXML
    Label loginLbAppointment, loginLbUsername, loginLbPassword, lbLoginTimeZone, lbLoginUTCtimeZone;
    @FXML
    Button connectBnt;
    @FXML
    TextField tfUserName, tfPassWord;
    // FXML for Reports-------------------------------------------------------------
    /**
     * FXML for Reports
     */
    @FXML
    BarChart<String, Number> ReportsChart;
    @FXML
    TableView<Appointments> ReportsTVreport1, ReportsTVreport2, ReportsTVreport3;

    @FXML
    TableColumn<Appointments, Integer> tvReportsAptCount;
    @FXML
    TableColumn<Appointments, String> tvReportsAptType;
    @FXML
    TableColumn<Appointments, String> tvReportsAptMonth;

    @FXML
    TableColumn<Appointments, Integer> tvReportsAptID;
    @FXML
    TableColumn<Appointments, String> tvReportsTitle;
    @FXML
    TableColumn<Appointments, Integer> tvReportsDescription;
    @FXML
    TableColumn<Appointments, String> tvReportsType;
    @FXML
    TableColumn<Appointments, String> tvReportsStart;
    @FXML
    TableColumn<Appointments, String> tvReportsEnd;
    @FXML
    TableColumn<Appointments, Integer> tvReportsCustomerID;
    @FXML
    TableColumn<Appointments, Integer> tvReportsContactID;
    @FXML
    Label openHoursApt, closeHoursApt;

    /**
     * The initialize method that is ran as the application is fired up. Loads SQL into the proper tableviews
     */
    //------------------------------------------------------------------------------------------------------------------
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        //------------------------------We start Working on the Initialization part for Customers
        try {
            setTimeZoneInLogin();

        } catch (Exception e) {
            System.out.println("Zone detection is breaking the App");
        }

        try {



            PreparedStatement statement = Conn2MySQL.getConnection().prepareStatement("SELECT * from customers");
            ResultSet result = statement.executeQuery();
            while (result.next()) {


                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssS");
                ZoneId localZone = ZoneId.of(String.valueOf(ZoneId.systemDefault()));
                Timestamp updateTimestamp = result.getTimestamp("Last_Update");
                LocalDateTime sldt =  updateTimestamp.toLocalDateTime();
                ZonedDateTime startAptZoned =  sldt.atZone(ZoneId.of(String.valueOf(localZone)));
                ZonedDateTime finalUpdateCustZoned    = startAptZoned.withZoneSameInstant(ZoneId.of("UTC"));
                Timestamp updateBackToTimestamp  = Timestamp.valueOf(myFormatObj.format(finalUpdateCustZoned));

                PreparedStatement statementGetPresentState = Conn2MySQL.getConnection().prepareStatement("SELECT Division,Division_ID,COUNTRY_ID from first_level_divisions WHERE  Division_ID = " + result.getInt("Division_ID"));
                ResultSet rsState = statementGetPresentState.executeQuery();

                while (rsState.next()) {

                    String CountryName = "";
                    if (rsState.getInt("COUNTRY_ID") == 1) {
                        CountryName = "USA";
                    } else if (rsState.getInt("COUNTRY_ID") == 2) {
                        CountryName = "England";
                    } else if (rsState.getInt("COUNTRY_ID") == 3) {
                        CountryName = "Canada";
                    }

                    CustomerList.add(new Customers(
                            result.getInt("Customer_ID"),
                            result.getString("Customer_Name"),
                            result.getString("Address"),
                            rsState.getString("Division") + " /  " + CountryName,
                            result.getString("Postal_Code"),
                            result.getString("Phone"),
                            result.getDate("Create_Date"),
                            result.getString("Created_By"),
                            updateBackToTimestamp,
                            result.getString("Last_Updated_By"),
                            result.getInt("Division_ID")));

                    tvCustomerID.setCellValueFactory(new PropertyValueFactory<>("idCustomer"));
                    tvCustomerName.setCellValueFactory(new PropertyValueFactory<>("nameCustomer"));
                    tvCustomerAddress.setCellValueFactory(new PropertyValueFactory<>("addressCustomer"));
                    tvCustomerZIP.setCellValueFactory(new PropertyValueFactory<>("zipCustomer"));
                    tvCustomerPhone.setCellValueFactory(new PropertyValueFactory<>("phoneCustomer"));
                    tvCustomerCreate.setCellValueFactory(new PropertyValueFactory<>("createCustomer"));
                    tvCustomerCreateBy.setCellValueFactory(new PropertyValueFactory<>("createByCustomer"));
                    tvCustomerUpdated.setCellValueFactory(new PropertyValueFactory<>("updatedCustomer"));
                    tvCustomerUpdatedBy.setCellValueFactory(new PropertyValueFactory<>("updatedByCustomer"));
                    tvCustomerUpdated.setCellValueFactory(new PropertyValueFactory<>("updatedCustomer"));
                    tvCustomerDivID.setCellValueFactory(new PropertyValueFactory<>("stateCustomer"));
                    tableViewCustomer.setItems(CustomerList);

                }

            }

            PreparedStatement statementCountryChoice = Conn2MySQL.getConnection().prepareStatement("SELECT distinct COUNTRY_ID from first_level_divisions");
            ResultSet rsCountry = statementCountryChoice.executeQuery();
            while (rsCountry.next()) {
                String CountryVar = rsCountry.getString("COUNTRY_ID");
                if (CountryVar.equals("1")) CountryVar = "USA";
                if (CountryVar.equals("2")) CountryVar = "Canada";
                if (CountryVar.equals("3")) CountryVar = "England";
                choiceBoxCountry.getItems().add(CountryVar);

            }
        } catch (Exception e) {
        }

//---------------------------------------END of Customers Initialization---------------------

// ------------------------------We start Working on the Initialization part for Appointments

        try {
            AptTableViewDisplays();
            EST2Local();

        } catch (Exception e) {
            System.out.println("Error occurred during loading of Appointments!");
        }

//---------------------------------------END of Applications Initialization------------------
// ------------------------------We start Working on the Initialization part for Reports
        try {
            ReportsTableViewDisplays();
        } catch (Exception e) {
            System.out.println("Error occurred during loading of Reports!");
        }

//---------------------------------------END of Reports Initialization------------------
    }

    /**
     * This method is used to change scenes, applied to the Apt button on the navigation menu
     */

    public void handleAppointmentBnt() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Appointments.fxml"));
        Stage window = (Stage) TabAppointments.getScene().getWindow();
        window.setScene(new Scene(root, 1700, 850));
    }

    /**
     * This method is used to change scenes, applied to the Customer button on the navigation menu
     */
    //-----------------------------------------------------------------------------------------------------------
    public void handleCustomerBnt() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Customers.fxml"));
        Stage window = (Stage) TabCustomers.getScene().getWindow();
        window.setScene(new Scene(root, 1700, 850));
    }

    /**
     * This method is used to change scenes, applied to the Reports button on the navigation menu
     */
    //-----------------------------------------------------------------------------------------------------------
    public void handleReportBnt() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Reports.fxml"));
        Stage window = (Stage) TabReports.getScene().getWindow();
        window.setScene(new Scene(root, 1700, 850));
    }

    /**
     * This method is used to exit the application
     */
    //-----------------------------------------------------------------------------------------------------------
    public void handleExitBnt() throws Exception {
        confirmClose();
    }

    /**
     * This method is used to confirm with the user if they really want to exit
     */
    //-----------------------------------------------------------------------------------------------------------
    public void confirmClose() {
        Alert closeConfirm = new Alert();
        if (closeConfirm.display("Exit Warning", "Are you sure you want to exit?")) {
            Stage window = (Stage) TabExit.getScene().getWindow();
            window.close();
        }
    }

    /**
     * This method is used to Authenticate the user, load proper language for the login form and to log authentication attempts against the activity.txt file
     */
    //-----------------------------------------------------------------------------------------------------------
    public void connectApp() throws Exception {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("login_activity.txt", true)));
        if (tfUserName.getText().equals(Username) && tfPassWord.getText().equals(Password)) {
            Parent root = FXMLLoader.load(getClass().getResource("Customers.fxml"));
            Stage window = (Stage) connectBnt.getScene().getWindow();
            window.setScene(new Scene(root, 1700, 850));
            System.out.println("Correct Password" + "  " + tfUserName.getText());
            connectBnt.setText("Connected");
            AlertsOnLogin();

            try {
                out.println("User " + tfUserName.getText() + " With password " + tfPassWord.getText() + " successfully logged in at " + LocalDateTime.now());
                out.close();
            } catch (Exception e) {
                //exception handling left as an exercise for the reader
            }

        } else
            System.out.println("Wrong Password" + "  " + tfUserName.getText());

        try {
            out.println("User " + tfUserName.getText() + " With password " + tfPassWord.getText() + " failed to log in at " + LocalDateTime.now());
            out.close();
        } catch (Exception e) {
            //exception handling left as an exercise for the reader
        }
        Locale locale = Locale.getDefault();
        System.out.println(locale);
        if (locale.toString().contains("en")) {
            connectBnt.setText("Try Again");
        } else if (locale.toString().contains("fr")) {
            connectBnt.setText("Réessayer");
        }

    }

    /**
     * This method is used to set the proper state on the choice box
     */
    //-----------------------------------------------------------------------------------------------------------
    public void setStateChoice() {
        if (choiceBoxCountry.getValue().equals("USA")) {
            System.out.println("Equal to USA");
            try {
                ChoiceListCustomerState.clear();
                PreparedStatement statementStateChoice = Conn2MySQL.getConnection().prepareStatement("SELECT Division,Division_ID from first_level_divisions where COUNTRY_ID = 1");
                ResultSet rsState = statementStateChoice.executeQuery();
                while (rsState.next()) {
                    ChoiceListCustomerState.add(rsState.getString("Division"));
                    choiceBoxState.setItems(ChoiceListCustomerState);

                }
            } catch (Exception e) {
                System.out.println("Method setStateChoice() failed!");
            }
        }

        if (choiceBoxCountry.getValue().equals("Canada")) {
            System.out.println("Equal to Canada");
            try {
                ChoiceListCustomerState.clear();
                PreparedStatement statementStateChoice = Conn2MySQL.getConnection().prepareStatement("SELECT Division from first_level_divisions where COUNTRY_ID = 3");
                ResultSet rsState = statementStateChoice.executeQuery();
                while (rsState.next()) {
                    ChoiceListCustomerState.add(rsState.getString("Division"));
                    choiceBoxState.setItems(ChoiceListCustomerState);

                }
            } catch (Exception e) {
                System.out.println("Method setStateChoice() failed!");
            }
        }

        if (choiceBoxCountry.getValue().equals("England")) {
            System.out.println("Equal to England");
            try {
                ChoiceListCustomerState.clear();
                PreparedStatement statementStateChoice = Conn2MySQL.getConnection().prepareStatement("SELECT Division from first_level_divisions where COUNTRY_ID = 2");
                ResultSet rsState = statementStateChoice.executeQuery();
                while (rsState.next()) {
                    ChoiceListCustomerState.add(rsState.getString("Division"));
                    choiceBoxState.setItems(ChoiceListCustomerState);

                }
            } catch (Exception e) {
                System.out.println("Method setStateChoice() failed!");
            }
        }
    }

    /**
     * This method is used to set the proper customer ID on the choice box
     */
    //-----------------------------------------------------------------------------------------------------------
    public void setCustIdForAppointments() {
        System.out.println("Clicked the ChoiceBox!");
        try {
            CustomerIDList.clear();
            PreparedStatement statementStateChoice = Conn2MySQL.getConnection().prepareStatement("SELECT Customer_ID,Customer_Name from customers");
            ResultSet rsState = statementStateChoice.executeQuery();
            while (rsState.next()) {
                CustomerIDList.add(Integer.parseInt(rsState.getString("Customer_ID")));
                choiceFromAppointmentsGetCustID.setItems(CustomerIDList);

            }
        } catch (Exception e) {
            System.out.println("Method setCustIdForAppointments() failed!");
        }
    }

    /**
     * This method is used to set the proper User on the choice box
     */
    //-----------------------------------------------------------------------------------------------------------
    public void setUserIdForAppointments() {
        System.out.println("Clicked the ChoiceBox!");
        try {
            UserIDList.clear();
            PreparedStatement statementStateChoice = Conn2MySQL.getConnection().prepareStatement("SELECT User_ID,User_Name from users");
            ResultSet rsState = statementStateChoice.executeQuery();
            while (rsState.next()) {
                UserIDList.add(Integer.parseInt(rsState.getString("User_ID")));
                choiceFromAppointmentsGetUserID.setItems(UserIDList);
            }
        } catch (Exception e) {
            System.out.println("Method setUserIdForAppointments()failed!");
        }
    }

    /**
     * This method is used to set the proper contact ID on the choice box
     */
    //-----------------------------------------------------------------------------------------------------------
    public void setContactIdForAppointments() {
        System.out.println("Clicked the ChoiceBox!");
        try {
            ContactIDList.clear();
            PreparedStatement statementStateChoice = Conn2MySQL.getConnection().prepareStatement("SELECT Contact_ID,Contact_Name from contacts");
            ResultSet rsState = statementStateChoice.executeQuery();
            while (rsState.next()) {
                ContactIDList.add(rsState.getString("Contact_Name"));
                choiceFromAppointmentsGetContactID.setItems(ContactIDList);
            }
        } catch (Exception e) {
            System.out.println("Method setContactIdForAppointments() failed!");
        }
    }

    /**
     * This method is used to set to add new Customer records
     */
//---------------------------------------------Code Below Works time last worked 12:51 PM - March 14 2021
    public void insertCustomerInformation() throws Exception {

        PreparedStatement statementQueryCustomer = Conn2MySQL.getConnection().prepareStatement("SELECT Division_ID from first_level_divisions where Division = "
                + "'" + choiceBoxState.getValue() + "'");
        ResultSet rsQueryCustomer = statementQueryCustomer.executeQuery();
        while (rsQueryCustomer.next()) {
            System.out.println(rsQueryCustomer.getString("Division_ID"));

            PreparedStatement statementInsertCustomer = Conn2MySQL.getConnection().prepareStatement(
                    "INSERT INTO customers  (Customer_Name,Address,Postal_Code,Phone,Created_By,Last_Updated_By,Division_ID) " +
                            "  VALUES(" + "'"
                            + tfCustomerName.getText() + "'" + "," + "'"
                            + tfCustomerAddress.getText() + "'" + ","
                            + "'" + tfCustomerZIP.getText() + "'"
                            + "," + "'"
                            + tfCustomerPhone.getText() + "'" + ","
                            + "'test','test',"
                            + rsQueryCustomer.getString("Division_ID") + ")");
            statementInsertCustomer.executeUpdate();
            handleCustomerBnt();

        }
    }

    /**
     * This method is used to set the information of the selected customer in the form for modification
     */
    //-----------------------------------------------------------------------------------------------------------
    public void setCostumerInformationInForm2Update() throws Exception {

        tfCustomerID.setText(String.valueOf(tableViewCustomer.getSelectionModel().getSelectedItem().getIdCustomer()));
        tfCustomerName.setText(String.valueOf(tableViewCustomer.getSelectionModel().getSelectedItem().getNameCustomer()));
        tfCustomerAddress.setText(String.valueOf(tableViewCustomer.getSelectionModel().getSelectedItem().getAddressCustomer()));
        tfCustomerZIP.setText(String.valueOf(tableViewCustomer.getSelectionModel().getSelectedItem().getZipCustomer()));
        tfCustomerPhone.setText(String.valueOf(tableViewCustomer.getSelectionModel().getSelectedItem().getPhoneCustomer()));
        Integer DivToUpdate = tableViewCustomer.getSelectionModel().getSelectedItem().getDivIDCustomer();
        System.out.println(DivToUpdate);
        if (DivToUpdate >= 1 && DivToUpdate <= 54) {
            System.out.println("USA");
            choiceBoxCountry.setValue("USA");
        } else if (DivToUpdate >= 55 && DivToUpdate <= 72) {
            System.out.println("Canada");
            choiceBoxCountry.setValue("Canada");
        } else if (DivToUpdate >= 101 && DivToUpdate <= 104) {
            System.out.println("England");
            choiceBoxCountry.setValue("England");
        }
        PreparedStatement statementStateChoice = Conn2MySQL.getConnection().prepareStatement("SELECT Division from first_level_divisions where Division_ID = " + "'" + DivToUpdate + "'");
        ResultSet rsDiv = statementStateChoice.executeQuery();

        while (rsDiv.next()) {
            System.out.println(rsDiv.getString("Division"));
            choiceBoxState.setValue(rsDiv.getString("Division"));
            choiceBoxState.setVisible(true);
        }

    }

    /**
     * This method is used to set the information of the selected customer in the form and actually update the database
     */
    //-----------------------------------------------------------------------------------------------------------
    public void modifyCustomerInformation() throws Exception {

        PreparedStatement statementQueryCustomer = Conn2MySQL.getConnection().prepareStatement("SELECT Division_ID from first_level_divisions where Division = "
                + "'" + choiceBoxState.getValue() + "'");
        ResultSet rsQueryCustomer = statementQueryCustomer.executeQuery();
        while (rsQueryCustomer.next()) {
            System.out.println(rsQueryCustomer.getString("Division_ID"));
            String Created_ByFix = "test";

            PreparedStatement statementInsertCustomer = Conn2MySQL.getConnection().prepareStatement(
                    "UPDATE customers SET " +
                            "Customer_Name = " + "'" + tfCustomerName.getText() + "'," +
                            "Address = " + "'" + tfCustomerAddress.getText() + "'," +
                            "Postal_Code= " + "'" + tfCustomerZIP.getText() + "'," +
                            "Phone = " + "'" + tfCustomerPhone.getText() + "'," +
                            "Created_By = " + "'" + Created_ByFix + "'," +
                            "Last_Update= " + "'" + java.sql.Timestamp.valueOf(LocalDateTime.now()) + "'," +
                            "Last_Updated_By = " + "'" + Created_ByFix + "'," +
                            "Division_ID = " + "'" + rsQueryCustomer.getString("Division_ID") + "'" +
                            " WHERE  Customer_ID = " + "'" + tfCustomerID.getText() + "'");

            statementInsertCustomer.executeUpdate();
            handleCustomerBnt();

        }
    }

    /**
     * This method is used to set the information of the selected customer for deletion
     */
    //-----------------------------------------------------------------------------------------------------------
    public boolean deleteCustomerInformation() throws Exception {
        // boolean answer = true;
        Integer recordToDelete = tableViewCustomer.getSelectionModel().getSelectedItem().getIdCustomer();

        PreparedStatement statementDeleteCustomer = Conn2MySQL.getConnection().prepareStatement(
                "DELETE from customers WHERE Customer_ID = " + "'" + recordToDelete + "'");
        Alert deleteAlert = new Alert();

        if (deleteAlert.display("DELETE RECORD", "Are you sure you want to delete this record?")) {

            PreparedStatement statementDeleteCustomerAppointments = Conn2MySQL.getConnection().prepareStatement(
                    "DELETE from appointments WHERE Customer_ID = " + "'" + recordToDelete + "'");
            statementDeleteCustomerAppointments.executeUpdate();
            statementDeleteCustomer.executeUpdate();
            handleCustomerBnt();
        } else
            System.out.println("Answer was false");

        return true;
    }

    /**
     * This method is used to set the information populated in the form  and create a new Appointment record in the DB
     */
    //-----------------------------------------------------------------------------------------------------------
    public void insertAppointmentInformation() throws Exception {

        if (OverlappingAppointments(true) && BusinessHoursCheck(true)) {

            PreparedStatement statementQueryContact = Conn2MySQL.getConnection().prepareStatement("SELECT Contact_ID from contacts WHERE Contact_Name = " + "'" + choiceFromAppointmentsGetContactID.getValue() + "'");
            ResultSet rsState = statementQueryContact.executeQuery();
            while (rsState.next()) {
                String ContactVal = (rsState.getString("Contact_ID"));

                PreparedStatement statementInsertAppointment = Conn2MySQL.getConnection().prepareStatement(
                        "INSERT INTO appointments (Title,Description,Location,Type,Start,End,Create_Date,Created_By,Last_Update,Last_Updated_By,Customer_ID,User_ID,Contact_ID) VALUES( " +
                                "'" + txAppointmentTitle.getText() + "'" + "," +
                                "'" + txAppointmentDescription.getText() + "'" + "," +
                                "'" + txAppointmentLocation.getText() + "'" + "," +
                                "'" + txAppointmentType.getText() + "'" + "," +
                                "'" + txAppointmentStart.getText() + "'" + "," +
                                "'" + txAppointmentEnd.getText() + "'" + "," +
                                "NOW(), " +
                                choiceFromAppointmentsGetUserID.getValue() + "," +
                                "NOW(), " +
                                choiceFromAppointmentsGetUserID.getValue() + "," +
                                choiceFromAppointmentsGetCustID.getValue() + "," +
                                choiceFromAppointmentsGetUserID.getValue() + "," +
                                ContactVal + ") ");

                Timestamp ts1 = Timestamp.valueOf(txAppointmentStart.getText());
                Timestamp ts2 = Timestamp.valueOf(txAppointmentEnd.getText());
                Integer b3 = ts1.compareTo(ts2);

                if (b3 < 0) {
                    System.out.println("End Time is Greater than Start time. That's good");
                    statementInsertAppointment.executeUpdate();
                    handleAppointmentBnt();
                } else if (b3 > 0) {
                    System.out.println("Start Time is Greater than End time. That's  NO good");
                    Alert timeError = new Alert();
                    timeError.correctData("Time entry is Incorrect", "Please enter an end time after the start time");
                }

///Place above here
            }
        }//Method IF
        else
            System.out.println("FALSE, there is an overlapping APT or outside business hours");
    }

    /**
     * This method is used to set the selected appointment for deletion
     */
    //-----------------------------------------------------------------------------------------------------------
    public boolean deleteAppointmentInformation() throws Exception {
        // boolean answer = true;
        Integer appointmentToDelete = tableViewAppointments.getSelectionModel().getSelectedItem().getAppointment_ID();

        PreparedStatement statementDeleteAppointment = Conn2MySQL.getConnection().prepareStatement(
                "DELETE from appointments WHERE Appointment_ID = " + "'" + appointmentToDelete + "'");
        Alert deleteAlert = new Alert();

        if (deleteAlert.display("DELETE RECORD", "Are you sure you want to delete Appointment  ID " + tableViewAppointments.getSelectionModel().getSelectedItem().getAppointment_ID() + " of type " + tableViewAppointments.getSelectionModel().getSelectedItem().getType())) {
            statementDeleteAppointment.executeUpdate();
            handleAppointmentBnt();
        } else
            System.out.println("Answer was false");

        return true;
    }

    /**
     * This method is used to set the information of the selected appointment in the form for modification
     */
    //-----------------------------------------------------------------------------------------------------------
    public void setAppointmentInformationInForm2Update() throws Exception {

        System.out.println("This is the User value before the loop " + tableViewAppointments.getSelectionModel().getSelectedItem().getContact_ID());
        PreparedStatement statementSetContactName = Conn2MySQL.getConnection().prepareStatement("SELECT Contact_ID,Contact_Name from contacts WHERE Contact_ID = " + tableViewAppointments.getSelectionModel().getSelectedItem().getContact_ID());
        ResultSet rsState = statementSetContactName.executeQuery();
        while (rsState.next()) {
            txAppointmentID.setText(String.valueOf(tableViewAppointments.getSelectionModel().getSelectedItem().getAppointment_ID()));
            txAppointmentTitle.setText(String.valueOf(tableViewAppointments.getSelectionModel().getSelectedItem().getTitle()));
            txAppointmentDescription.setText(String.valueOf(tableViewAppointments.getSelectionModel().getSelectedItem().getDescription()));
            txAppointmentLocation.setText(String.valueOf(tableViewAppointments.getSelectionModel().getSelectedItem().getLocation()));
            txAppointmentType.setText(String.valueOf(tableViewAppointments.getSelectionModel().getSelectedItem().getType()));
            txAppointmentStart.setText(String.valueOf(tableViewAppointments.getSelectionModel().getSelectedItem().getStart()));
            txAppointmentEnd.setText(String.valueOf(tableViewAppointments.getSelectionModel().getSelectedItem().getEnd()));
            choiceFromAppointmentsGetCustID.setValue(tableViewAppointments.getSelectionModel().getSelectedItem().getCustomer_ID());
            choiceFromAppointmentsGetUserID.setValue(tableViewAppointments.getSelectionModel().getSelectedItem().getUser_ID());
            choiceFromAppointmentsGetContactID.setValue(rsState.getString("Contact_Name"));

        }

    }

    /**
     * This method is used to set the information of the selected customer in the form for modification and actually update the Database
     */
    //-----------------------------------------------------------------------------------------------------------
    public void insertSaveAppointmentInformation() throws Exception {

        if (OverlappingAppointments(true) && BusinessHoursCheck(true)) {

            PreparedStatement statementQueryContact = Conn2MySQL.getConnection().prepareStatement("SELECT Contact_ID from contacts WHERE Contact_Name = " + "'" + choiceFromAppointmentsGetContactID.getValue() + "'");
            ResultSet rsState = statementQueryContact.executeQuery();
            while (rsState.next()) {
                String ContactVal = (rsState.getString("Contact_ID"));

                String endTime = txAppointmentEnd.getText();
                String startTime = txAppointmentStart.getText();
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                DateFormat formatterTime = new SimpleDateFormat("HH:mm:ss.SSSXXX");
                DateFormat formatterNanos = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S");
                DateFormat formatterZoned = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                Date startDate = formatter.parse(startTime);
                Date endDate = formatter.parse(endTime);

                PreparedStatement statementInsertAppointment = Conn2MySQL.getConnection().prepareStatement(
                        "UPDATE  appointments SET " +
                                "Title = " + "'" + txAppointmentTitle.getText() + "'," +
                                "Description = " + "'" + txAppointmentDescription.getText() + "'," +
                                "Location= " + "'" + txAppointmentLocation.getText() + "'," +
                                "Type = " + "'" + txAppointmentType.getText() + "'," +
                                "Start = " + "'" + formatterZoned.format(startDate) + "'," +
                                "End = " + "'" + formatterZoned.format(endDate) + "'," +

                                "Created_By = " + "'" + choiceFromAppointmentsGetUserID.getValue() + "'," +
                                "Last_Update= " + "'" + updateAppointmentRecord + "'," +
                                "Last_Updated_By = " + "'" + choiceFromAppointmentsGetUserID.getValue() + "'," +
                                "Customer_ID = " + choiceFromAppointmentsGetCustID.getValue() + "," +
                                "User_ID = " + choiceFromAppointmentsGetUserID.getValue() + "," +
                                "Contact_ID = " + ContactVal +
                                " WHERE  Appointment_ID = " + "'" + txAppointmentID.getText() + "'");

                System.out.println(txAppointmentID.getText());

                Timestamp ts1 = Timestamp.valueOf(txAppointmentStart.getText());
                Timestamp ts2 = Timestamp.valueOf(txAppointmentEnd.getText());
                Integer b3 = ts1.compareTo(ts2);
                if (b3 < 0) {
                    System.out.println("End Time is Greater than Start time. That's good");
                    statementInsertAppointment.executeUpdate();
                    handleAppointmentBnt();
                } else if (b3 > 0) {
                    System.out.println("Start Time is Greater than End time. That's  NO good");
                    Alert timeError = new Alert();
                    timeError.correctData("Time entry is Incorrect", "Please enter an end time after the start time");
                }

            }

        }//Method IF
        else
            System.out.println("FALSE, there is an overlapping APT or outside business hours");
    }

    /**
     * This method is used to set the user's timezone at the login screen
     */
    //-----------------------------------------------------------------------------------------------------------
    public void setTimeZoneInLogin() {
        lbLoginTimeZone.setText(String.valueOf(ZoneId.systemDefault()));
        lbLoginUTCtimeZone.setText("UTC " + OffsetDateTime.now().getOffset());
        Locale locale = Locale.getDefault();

        if (locale.toString().contains("en")) {
            System.out.println("System is set to English Locale is :" + locale);
        } else if (locale.toString().contains("fr")) {
            System.out.println("System is set to French Locale is :" + locale);
        }
    }
    //-----------------------------------------------------------------------------------------------------------

    /**
     * This method is used to set appointment alerts at login
     */
    //-----------------------------------------------------------------------------------------------------------
    public void AlertsOnLogin() {
        try {

            Locale locale = Locale.getDefault();
            // PreparedStatement statementGetAppointmentStart = Conn2MySQL.getConnection().prepareStatement("SELECT CONVERT_TZ(Start,'+00:00', "+"'"+OffsetDateTime.now().getOffset()+"'"+") AS `Start`,Appointment_ID from appointments");
            PreparedStatement statementGetAppointmentStart = Conn2MySQL.getConnection().prepareStatement("SELECT Appointment_ID,CONVERT_TZ(Start,'+00:00','+00:00') AS `Start` FROM appointments");
            ResultSet rsStart = statementGetAppointmentStart.executeQuery();
            while (rsStart.next()) {
                String AppointmentStart = (rsStart.getString("Start"));
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                DateFormat formatterZoned = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                Date startDate = formatter.parse(AppointmentStart);
                long startDateMinus15 = startDate.getTime() - 900000;
                Date BeforeAptStart15 = new Date(startDateMinus15);
                String APT_ID = (rsStart.getString("Appointment_ID"));
                LocalDateTime localNow = LocalDateTime.now();
                //Co,me back here
                ZoneId localZone = ZoneId.of(String.valueOf(ZoneId.systemDefault()));
                ZonedDateTime ZonedLocalTime = Timestamp.valueOf(localNow).toInstant().atZone(ZoneId.of(String.valueOf(localZone)));
                String moneyString = String.valueOf(ZonedLocalTime.toLocalDateTime());

                if ((formatterZoned.parse(moneyString).after(BeforeAptStart15) || (formatterZoned.parse(moneyString).equals(BeforeAptStart15))) && (formatterZoned.parse(moneyString).before(startDate) || formatterZoned.parse(moneyString).equals(startDate)) )
                {
                    Alert Upcoming_Appointment = new Alert();
                    Upcoming_Appointment.correctData("The following are within the next 15 minutes", "Appointment # " + APT_ID + " Which starts at " + rsStart.getString("Start") + " EST");
                    System.out.println("Appointment is within range");
                    System.out.println("The values to compare: 15 minutes prior to Apt start |" + BeforeAptStart15 + "| The current time set to EST |" + formatterZoned.parse(moneyString) + "| And the Apt start time  |" + startDate);
                    System.out.println("------------------------------------------------------------------------------------------------");
                } else
                    System.out.println("Appointment is NOT within range");
                System.out.println("The values to compare: 15 minutes prior to Apt start |" + BeforeAptStart15 + "| The current time set to local |" + formatterZoned.parse(moneyString) + "| And the Apt start time  |" + startDate);

            }
        } catch (Exception e) {
            System.out.println("triggerAppointmentAlarm() method is not loading. Error at runtime");
        }

    }

    /**
     * This method is used to check for overlapping appointments and alert the user of such event
     */
    //-----------------------------------------------------------------------------------------------------------
    public boolean OverlappingAppointments(boolean answer) throws Exception {
        boolean Answer = true;
        String endTime = txAppointmentEnd.getText();
        String startTime = txAppointmentStart.getText();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat formatterZoned = new SimpleDateFormat("uuuu-MM-dd[ ]['T']HH:mm:ss[X]");
        Date startUserDate = formatter.parse(startTime);
        Date endUserDate = formatter.parse(endTime);
        ZoneOffset offset = ZoneOffset.UTC;

        PreparedStatement statementApt = Conn2MySQL.getConnection().prepareStatement("SELECT Appointment_ID,CONVERT_TZ(Start,'+00:00','+00:00') AS `Start`,CONVERT_TZ(End,'+00:00','+00:00') AS `End` FROM appointments");
        //PreparedStatement statementApt = Conn2MySQL.getConnection().prepareStatement("SELECT Appointment_ID,Start,End FROM appointments" );
        ResultSet rsAptStart = statementApt.executeQuery();
        while (rsAptStart.next()) {
            ZonedDateTime.now(ZoneId.of("UTC"));
            String idAPT = (rsAptStart.getString("Appointment_ID"));
            Timestamp startAPT = (rsAptStart.getTimestamp("Start"));
            Timestamp endAPT = (rsAptStart.getTimestamp("End"));

            Date startQueryDate = (rsAptStart.getTimestamp("Start"));
            Date endQueryDate = (rsAptStart.getTimestamp("End"));
            // ZoneOffset;
            ZonedDateTime startFromQueryDateZoned = Timestamp.valueOf(String.valueOf(formatter.format(startAPT))).toInstant().atZone(ZoneId.of("UTC"));
            ZonedDateTime endFromQueryDateZoned = Timestamp.valueOf(String.valueOf(formatter.format(endAPT))).toInstant().atZone(ZoneId.of("UTC"));

            ZonedDateTime startFromUserDateZoned = Timestamp.valueOf(String.valueOf(formatter.format(startUserDate))).toLocalDateTime().atZone(ZoneId.of("UTC"));
            ZonedDateTime endFromUserDateZoned = Timestamp.valueOf(String.valueOf(formatter.format(endUserDate))).toLocalDateTime().atZone(ZoneId.of("UTC"));

            if ((startFromUserDateZoned.isBefore(startFromQueryDateZoned) && endFromUserDateZoned.isBefore(startFromQueryDateZoned)) || (startFromUserDateZoned.isAfter(endFromQueryDateZoned) && endFromUserDateZoned.isAfter(endFromQueryDateZoned))) {

            } else {
                //System.out.println("At ELSE Clause There should be no overlap, user input: start date  " + startDateZoned + " existing Apt start date/time: " + startFromQueryDateZoned + "  existing Apt end date/time: " + endFromQueryDateZoned + " user input: end date " + endDateZoned);
                System.out.println("There is overlap with Apt ID  " + idAPT + " user input" + startFromUserDateZoned + " existing Apt start : " + startFromQueryDateZoned + "  existing Apt end: " + endFromQueryDateZoned + " user input: end " + endFromUserDateZoned + "         ");
                Alert timeError = new Alert();
                timeError.correctData("Time entry is Incorrect", "New Date Overlaps APT ID " + idAPT);

                return false;
            }

        }

        return answer;
    }

    /**
     * This method is used to check for business hours and restrict the ability to schedule outside that range
     */
    //-----------------------------------------------------------------------------------------------------------
    public boolean BusinessHoursCheck(boolean answer) throws Exception {
        boolean Answer = true;

        String endTime = txAppointmentEnd.getText();
        String startTime = txAppointmentStart.getText();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat formatterTime = new SimpleDateFormat("HH:mm:ss.SSSXXX");
        DateFormat formatterNanos = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S");
        DateFormat formatterZoned = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date startDate = formatter.parse(startTime);
        Date endDate = formatter.parse(endTime);

        ZoneId.of("US/Eastern");
        System.out.println(ZonedDateTime.now(ZoneId.of("UTC")));
        System.out.println(ZonedDateTime.now(ZoneId.of("America/New_York")));
        ZonedDateTime.now(ZoneId.of("America/New_York"));

        OffsetTime startAptTime = OffsetTime.parse(formatterTime.format(startDate));
        OffsetTime Open_EST_Hours = LocalTime.of(8, 00).atOffset(ZoneOffset.of("-04:00"));
        OffsetTime Close_EST_Hours = LocalTime.of(22, 00).atOffset(ZoneOffset.of("-04:00"));

        System.out.println("Opening   " + Open_EST_Hours + "      " + "Closing   " + Close_EST_Hours + " Start time : " + startAptTime);
        if (startAptTime.isAfter(Open_EST_Hours) && startAptTime.isBefore(Close_EST_Hours)) {
            System.out.println("This makes sense  " + startAptTime);


        }//////Cut from here
        else if (startAptTime.isBefore(Open_EST_Hours) || startAptTime.isAfter(Close_EST_Hours)) {
            System.out.println("Did not pass the time check  " + startAptTime);
            Alert Upcoming_Appointment = new Alert();
            Upcoming_Appointment.correctData("Appointment Times entered do not fall within " + Open_EST_Hours + " and " + Close_EST_Hours, " Please enter Appointment times within EST business hours");
            return false;
        }


        return answer;
    }
    //-----------------------------------------------------------------------------------------------------------

    /**
     * This method is used to set the Appointments tableview
     */
    //lbLoginTimeZone.setText(String.valueOf(ZoneId.systemDefault()));
    //lbLoginUTCtimeZone.setText("UTC " + OffsetDateTime.now().getOffset());

    public void AptTableViewDisplays() throws Exception {

        if (AptAllTableView.isSelected()) {
            tableViewAppointments.getItems().clear();
            //PreparedStatement statement = Conn2MySQL.getConnection().prepareStatement("SELECT * FROM appointments");
            PreparedStatement statement = Conn2MySQL.getConnection().prepareStatement("SELECT Appointment_ID,Title,Description,Location,Type,CONVERT_TZ(Start,'+00:00', '+00:00') AS `Start`,CONVERT_TZ(End,'+00:00', '+00:00') AS `End`,Create_Date,Created_By,Last_Update,Last_Updated_By,Customer_ID,User_ID,Contact_ID FROM appointments");
            ResultSet result = statement.executeQuery();
            while (result.next()) {

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssS");
                ZoneId localZone = ZoneId.of(String.valueOf(ZoneId.systemDefault()));
                Timestamp startAptTimestamp = result.getTimestamp("Start");
                Timestamp endAptTimestamp = result.getTimestamp("End");
                 LocalDateTime sldt =  startAptTimestamp.toLocalDateTime();
                 LocalDateTime eldt =  endAptTimestamp.toLocalDateTime();
                 ZonedDateTime startAptZoned =  sldt.atZone(ZoneId.of(String.valueOf(localZone)));
                 ZonedDateTime endAptZoned =    eldt.atZone(ZoneId.of(String.valueOf(localZone)));
                ZonedDateTime finalStartAptZoned    = startAptZoned.withZoneSameInstant(ZoneId.of("UTC"));
                ZonedDateTime finalEndAptZoned      = endAptZoned.withZoneSameInstant(ZoneId.of("UTC"));
                Timestamp startBackToTimestamp  = Timestamp.valueOf(myFormatObj.format(finalStartAptZoned));
                Timestamp endBackToTimestamp    = Timestamp.valueOf(myFormatObj.format(finalEndAptZoned));

                System.out.println(sldt + " Zoned i hope, well not yet " +startAptZoned +"     " + finalStartAptZoned + "     back to timestamp " + startBackToTimestamp  + " End " + endBackToTimestamp);

                //result.getTimestamp("Start")
                AppointmentList.add(new Appointments(
                        result.getInt("Appointment_ID"),
                        result.getString("Title"),
                        result.getString("Description"),
                        result.getString("Location"),
                        result.getString("Type"),
                        startBackToTimestamp,
                        endBackToTimestamp,
                        result.getDate("Create_Date"),
                        result.getString("Created_By"),
                        result.getTimestamp("Last_Update"),
                        result.getString("Last_Updated_By"),
                        result.getInt("Customer_ID"),
                        result.getInt("User_ID"),
                        result.getInt("Contact_ID")));

                tvAppointmentID.setCellValueFactory(new PropertyValueFactory<>("Appointment_ID"));
                tvAppointmentTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
                tvAppointmentDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
                tvAppointmentLocation.setCellValueFactory(new PropertyValueFactory<>("Location"));
                tvAppointmentType.setCellValueFactory(new PropertyValueFactory<>("Type"));
                tvAppointmentStart.setCellValueFactory(new PropertyValueFactory<>("Start"));
                tvAppointmentEnd.setCellValueFactory(new PropertyValueFactory<>("End"));
                tvAppointmentUser.setCellValueFactory(new PropertyValueFactory<>("User_ID"));
                tvAppointmentContact.setCellValueFactory(new PropertyValueFactory<>("Contact_ID"));
                tvAppointmentCustomer_ID.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));
                tvAppointmentUpdated.setCellValueFactory(new PropertyValueFactory<>("Last_Update"));
                tableViewAppointments.setItems(AppointmentList);

            }

        } else if (AptWeekTableView.isSelected()) {
            tableViewAppointments.getItems().clear();
            //PreparedStatement statement = Conn2MySQL.getConnection().prepareStatement("SELECT * FROM appointments");
            PreparedStatement statement = Conn2MySQL.getConnection().prepareStatement("SELECT Appointment_ID,Title,Description,Location,Type,CONVERT_TZ(Start,'+00:00', '+00:00') AS `Start`,CONVERT_TZ(End,'+00:00', '+00:00') AS `End`,Create_Date,Created_By,Last_Update,Last_Updated_By,Customer_ID,User_ID,Contact_ID FROM appointments WHERE YEARWEEK(Start) = YEARWEEK(NOW())");
            ResultSet result = statement.executeQuery();
            while (result.next()) {

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssS");
                ZoneId localZone = ZoneId.of(String.valueOf(ZoneId.systemDefault()));
                Timestamp startAptTimestamp = result.getTimestamp("Start");
                Timestamp endAptTimestamp = result.getTimestamp("End");
                LocalDateTime sldt =  startAptTimestamp.toLocalDateTime();
                LocalDateTime eldt =  endAptTimestamp.toLocalDateTime();
                ZonedDateTime startAptZoned =  sldt.atZone(ZoneId.of(String.valueOf(localZone)));
                ZonedDateTime endAptZoned =    eldt.atZone(ZoneId.of(String.valueOf(localZone)));
                ZonedDateTime finalStartAptZoned    = startAptZoned.withZoneSameInstant(ZoneId.of("UTC"));
                ZonedDateTime finalEndAptZoned      = endAptZoned.withZoneSameInstant(ZoneId.of("UTC"));
                Timestamp startBackToTimestamp  = Timestamp.valueOf(myFormatObj.format(finalStartAptZoned));
                Timestamp endBackToTimestamp    = Timestamp.valueOf(myFormatObj.format(finalEndAptZoned));

                AppointmentList.add(new Appointments(
                        result.getInt("Appointment_ID"),
                        result.getString("Title"),
                        result.getString("Description"),
                        result.getString("Location"),
                        result.getString("Type"),
                        startBackToTimestamp,
                        endBackToTimestamp,
                        result.getDate("Create_Date"),
                        result.getString("Created_By"),
                        result.getTimestamp("Last_Update"),
                        result.getString("Last_Updated_By"),
                        result.getInt("Customer_ID"),
                        result.getInt("User_ID"),
                        result.getInt("Contact_ID")));

                tvAppointmentID.setCellValueFactory(new PropertyValueFactory<>("Appointment_ID"));
                tvAppointmentTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
                tvAppointmentDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
                tvAppointmentLocation.setCellValueFactory(new PropertyValueFactory<>("Location"));
                tvAppointmentType.setCellValueFactory(new PropertyValueFactory<>("Type"));
                tvAppointmentStart.setCellValueFactory(new PropertyValueFactory<>("Start"));
                tvAppointmentEnd.setCellValueFactory(new PropertyValueFactory<>("End"));
                tvAppointmentUser.setCellValueFactory(new PropertyValueFactory<>("User_ID"));
                tvAppointmentContact.setCellValueFactory(new PropertyValueFactory<>("Contact_ID"));
                tvAppointmentCustomer_ID.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));
                tvAppointmentUpdated.setCellValueFactory(new PropertyValueFactory<>("Last_Update"));
                tableViewAppointments.setItems(AppointmentList);
System.out.println(result.getTimestamp("Start"));
            }

        } else if (AptMonthTableView.isSelected()) {
            tableViewAppointments.getItems().clear();
            //PreparedStatement statement = Conn2MySQL.getConnection().prepareStatement("SELECT * FROM appointments");
            PreparedStatement statement = Conn2MySQL.getConnection().prepareStatement("SELECT Appointment_ID,Title,Description,Location,Type,CONVERT_TZ(Start,'+00:00', '+00:00') AS `Start`,CONVERT_TZ(End,'+00:00', '+00:00') AS `End`,Create_Date,Created_By,Last_Update,Last_Updated_By,Customer_ID,User_ID,Contact_ID FROM appointments WHERE MONTH(Start) = MONTH(NOW());");
            ResultSet result = statement.executeQuery();
            while (result.next()) {

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssS");
                ZoneId localZone = ZoneId.of(String.valueOf(ZoneId.systemDefault()));
                Timestamp startAptTimestamp = result.getTimestamp("Start");
                Timestamp endAptTimestamp = result.getTimestamp("End");
                LocalDateTime sldt =  startAptTimestamp.toLocalDateTime();
                LocalDateTime eldt =  endAptTimestamp.toLocalDateTime();
                ZonedDateTime startAptZoned =  sldt.atZone(ZoneId.of(String.valueOf(localZone)));
                ZonedDateTime endAptZoned =    eldt.atZone(ZoneId.of(String.valueOf(localZone)));
                ZonedDateTime finalStartAptZoned    = startAptZoned.withZoneSameInstant(ZoneId.of("UTC"));
                ZonedDateTime finalEndAptZoned      = endAptZoned.withZoneSameInstant(ZoneId.of("UTC"));
                Timestamp startBackToTimestamp  = Timestamp.valueOf(myFormatObj.format(finalStartAptZoned));
                Timestamp endBackToTimestamp    = Timestamp.valueOf(myFormatObj.format(finalEndAptZoned));

                AppointmentList.add(new Appointments(
                        result.getInt("Appointment_ID"),
                        result.getString("Title"),
                        result.getString("Description"),
                        result.getString("Location"),
                        result.getString("Type"),
                        startBackToTimestamp,
                        endBackToTimestamp,
                        result.getDate("Create_Date"),
                        result.getString("Created_By"),
                        result.getTimestamp("Last_Update"),
                        result.getString("Last_Updated_By"),
                        result.getInt("Customer_ID"),
                        result.getInt("User_ID"),
                        result.getInt("Contact_ID")));

                tvAppointmentID.setCellValueFactory(new PropertyValueFactory<>("Appointment_ID"));
                tvAppointmentTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
                tvAppointmentDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
                tvAppointmentLocation.setCellValueFactory(new PropertyValueFactory<>("Location"));
                tvAppointmentType.setCellValueFactory(new PropertyValueFactory<>("Type"));
                tvAppointmentStart.setCellValueFactory(new PropertyValueFactory<>("Start"));
                tvAppointmentEnd.setCellValueFactory(new PropertyValueFactory<>("End"));
                tvAppointmentUser.setCellValueFactory(new PropertyValueFactory<>("User_ID"));
                tvAppointmentContact.setCellValueFactory(new PropertyValueFactory<>("Contact_ID"));
                tvAppointmentCustomer_ID.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));
                tvAppointmentUpdated.setCellValueFactory(new PropertyValueFactory<>("Last_Update"));
                tableViewAppointments.setItems(AppointmentList);

            }

        }


    }

    /**
     * This method is used to set the Reports tableviews
     */
    //-----------------------------------------------------------------------------------------------------------
    public void ReportsTableViewDisplays() throws Exception {

        PreparedStatement statement = Conn2MySQL.getConnection().prepareStatement("SELECT Type,count(Type) AS TypeCount,monthname(Start) AS APTS from appointments group by APTS, Type;");
        //PreparedStatement statement = Conn2MySQL.getConnection().prepareStatement("SELECT Appointment_ID,Title,Description,Location,Type,CONVERT_TZ(Start,@@session.time_zone, '+04:00') AS `Start`,CONVERT_TZ(End,@@session.time_zone, '+04:00') AS `End`,Create_Date,Created_By,Last_Update,Last_Updated_By,Customer_ID,User_ID,Contact_ID FROM appointments");
        ResultSet result = statement.executeQuery();
        while (result.next()) {

            ReportsList.add(new Appointments(
                    result.getInt("TypeCount"),
                    result.getString("Type"),
                    result.getString("APTS")));

            tvReportsAptCount.setCellValueFactory(new PropertyValueFactory<>("TypeCount"));
            tvReportsAptType.setCellValueFactory(new PropertyValueFactory<>("Type"));
            tvReportsAptMonth.setCellValueFactory(new PropertyValueFactory<>("APTS"));

            ReportsTVreport1.setItems(ReportsList);

        }

        //PreparedStatement statementRep2 = Conn2MySQL.getConnection().prepareStatement("SELECT Type,count(Type) AS TypeCount,monthname(Start) AS APTS from appointments group by APTS, Type;");
        PreparedStatement statementRep2 = Conn2MySQL.getConnection().prepareStatement("select * from appointments order by Contact_ID, Start;");
        ResultSet resultRep2 = statementRep2.executeQuery();
        while (resultRep2.next()) {

            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssS");
            ZoneId localZone = ZoneId.of(String.valueOf(ZoneId.systemDefault()));
            Timestamp startAptTimestamp = resultRep2.getTimestamp("Start");
            Timestamp endAptTimestamp = resultRep2.getTimestamp("End");
            LocalDateTime sldt =  startAptTimestamp.toLocalDateTime();
            LocalDateTime eldt =  endAptTimestamp.toLocalDateTime();
            ZonedDateTime startAptZoned =  sldt.atZone(ZoneId.of(String.valueOf(localZone)));
            ZonedDateTime endAptZoned =    eldt.atZone(ZoneId.of(String.valueOf(localZone)));
            ZonedDateTime finalStartAptZoned    = startAptZoned.withZoneSameInstant(ZoneId.of("UTC"));
            ZonedDateTime finalEndAptZoned      = endAptZoned.withZoneSameInstant(ZoneId.of("UTC"));
            Timestamp startBackToTimestamp  = Timestamp.valueOf(myFormatObj.format(finalStartAptZoned));
            Timestamp endBackToTimestamp    = Timestamp.valueOf(myFormatObj.format(finalEndAptZoned));

                    ReportsList2.add(new Appointments(
                    resultRep2.getInt("Appointment_ID"),
                    resultRep2.getString("Title"),
                    resultRep2.getString("Description"),
                    resultRep2.getString("Location"),
                    resultRep2.getString("Type"),
                    startBackToTimestamp ,
                    endBackToTimestamp,
                    resultRep2.getDate("Create_Date"),
                    resultRep2.getString("Created_By"),
                    resultRep2.getTimestamp("Last_Update"),
                    resultRep2.getString("Last_Updated_By"),
                    resultRep2.getInt("Customer_ID"),
                    resultRep2.getInt("User_ID"),
                    resultRep2.getInt("Contact_ID")));

            tvReportsContactID.setCellValueFactory(new PropertyValueFactory<>("Contact_ID"));
            tvReportsAptID.setCellValueFactory(new PropertyValueFactory<>("Appointment_ID"));
            tvReportsTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
            tvReportsType.setCellValueFactory(new PropertyValueFactory<>("Type"));
            tvReportsDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
            tvReportsStart.setCellValueFactory(new PropertyValueFactory<>("Start"));
            tvReportsEnd.setCellValueFactory(new PropertyValueFactory<>("End"));
            tvReportsCustomerID.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));

            ReportsTVreport2.setItems(ReportsList2);

        }

        PreparedStatement statementRep3 = Conn2MySQL.getConnection().prepareStatement("SELECT count(Appointment_ID) AS AptCount,monthname(Start) AS APTS from appointments group by APTS;");
        ResultSet resultRep3 = statementRep3.executeQuery();
        while (resultRep3.next()) {
            XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();

            series.getData().add(new XYChart.Data<String, Number>(resultRep3.getString("APTS"), resultRep3.getInt("AptCount")));

            ReportsChart.getData().add(series);
        }

    }

    //-----------------------------------------------------------------------------------------------------------
    /**
     * The sets the equivalent EST business hours to local for user assistance while scheduling
     */

    public void EST2Local() {

        ZonedDateTime openZonedUTC = ZonedDateTime.of(LocalDate.now().atTime(12, 00), ZoneOffset.UTC);
        ZonedDateTime closedZonedUTC = ZonedDateTime.of(LocalDate.now().atTime(2, 00), ZoneOffset.UTC);

        ZoneId localZone = ZoneId.of(String.valueOf(ZoneId.systemDefault()));

        ZonedDateTime localOpenZoned = openZonedUTC.withZoneSameInstant(localZone);
        ZonedDateTime localClosedZoned = closedZonedUTC.withZoneSameInstant(localZone);

        LocalDateTime openLocal = localOpenZoned.toLocalDateTime();
        LocalDateTime closeLocal = localClosedZoned.toLocalDateTime();

        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm a");
        //lbLoginTimeZone.setText(String.valueOf(ZoneId.systemDefault()));
        //lbLoginUTCtimeZone.setText("UTC " + OffsetDateTime.now().getOffset());

        Locale locale = Locale.getDefault();

        System.out.println("Lets see if this works" + "zoned " + localOpenZoned + " And now to local" +  myFormatObj.format(openLocal) + "  Closed " + closeLocal);
        openHoursApt.setText(myFormatObj.format(openLocal));
        closeHoursApt.setText(myFormatObj.format(closeLocal));
    }

    //-----------------------------------------------------------------------------------------------------------





}
















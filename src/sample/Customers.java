package sample;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 * The class is used to instantiate customer objects from
 */

/**
 * The sets the customer's constructor
 */
public class Customers {

    private Integer idCustomer;
    private String nameCustomer;
    private String addressCustomer;
    private String zipCustomer;
    private String phoneCustomer;
    private Date createCustomer;
    private String createByCustomer;
    private Timestamp updatedCustomer;
    private String updatedByCustomer;
    private Integer DivIDCustomer;
    private String countryCustomer;
    private String stateCustomer;

    /**
     * The sets the customer's constructor
     */


    public Customers(Integer idCustomer, String nameCustomer, String addressCustomer, String zipCustomer, String phoneCustomer, Date createCustomer, String createByCustomer, Timestamp updatedCustomer, String updatedByCustomer, Integer divIDCustomer) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.addressCustomer = addressCustomer;
        this.zipCustomer = zipCustomer;
        this.phoneCustomer = phoneCustomer;
        this.createCustomer = createCustomer;
        this.createByCustomer = createByCustomer;
        this.updatedCustomer = updatedCustomer;
        this.updatedByCustomer = updatedByCustomer;
        this.DivIDCustomer = divIDCustomer;
    }
    /**
     * The sets an overloaded  customer's constructor
     */

    public Customers(Integer idCustomer, String nameCustomer, String addressCustomer, String zipCustomer, String phoneCustomer) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.addressCustomer = addressCustomer;
        this.zipCustomer = zipCustomer;
        this.phoneCustomer = phoneCustomer;

    }
    /**
     * The sets an overloaded  customer's constructor
     */
    public Customers(Integer idCustomer, String nameCustomer, String addressCustomer, String zipCustomer, String phoneCustomer,String createByCustomer,  String updatedByCustomer, Integer divIDCustomer) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.addressCustomer = addressCustomer;
        this.zipCustomer = zipCustomer;
        this.phoneCustomer = phoneCustomer;
        this.createByCustomer = createByCustomer;
        this.updatedByCustomer = updatedByCustomer;
        this.DivIDCustomer = divIDCustomer;
    }
    /**
     * The sets an overloaded  customer's constructor
     */
    public Customers(Integer idCustomer, String nameCustomer, String addressCustomer, String zipCustomer, String phoneCustomer, Date createCustomer, String createByCustomer,  String updatedByCustomer, Integer divIDCustomer) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.addressCustomer = addressCustomer;
        this.zipCustomer = zipCustomer;
        this.phoneCustomer = phoneCustomer;
        this.createCustomer = createCustomer;
        this.createByCustomer = createByCustomer;
        this.updatedByCustomer = updatedByCustomer;
        this.DivIDCustomer = divIDCustomer;
    }



    /**
     * The sets an overloaded  customer's constructor
     */
    public Customers(Integer idCustomer, String nameCustomer, String addressCustomer, String stateCustomer, String zipCustomer, String phoneCustomer, Date createCustomer, String createByCustomer, Timestamp updatedCustomer, String updatedByCustomer, Integer divIDCustomer) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.addressCustomer = addressCustomer;
        this.zipCustomer = zipCustomer;
        this.phoneCustomer = phoneCustomer;
        this.createCustomer = createCustomer;
        this.createByCustomer = createByCustomer;
        this.updatedCustomer = updatedCustomer;
        this.updatedByCustomer = updatedByCustomer;
        this.DivIDCustomer = divIDCustomer;
        this.stateCustomer = stateCustomer;
    }
    /**
     * The sets an overloaded  customer's constructor
     */
    public Customers(Integer idCustomer, String nameCustomer, String addressCustomer, String stateCustomer,String countryCustomer, String zipCustomer, String phoneCustomer, Date createCustomer, String createByCustomer, Timestamp updatedCustomer, String updatedByCustomer, Integer divIDCustomer) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.addressCustomer = addressCustomer;
        this.zipCustomer = zipCustomer;
        this.phoneCustomer = phoneCustomer;
        this.createCustomer = createCustomer;
        this.createByCustomer = createByCustomer;
        this.updatedCustomer = updatedCustomer;
        this.updatedByCustomer = updatedByCustomer;
        this.DivIDCustomer = divIDCustomer;
        this.stateCustomer = stateCustomer;
        this.countryCustomer = countryCustomer;
    }

    /**
     * The sets an overloaded  customer's constructor
     */
    public Customers(){
    }

    /**
     * The sets the getIdCustomer from the customer's class
     */
    public int getIdCustomer() {
        return idCustomer;
    }
    /**
     * The sets the setIdCustomer from the customer's class
     */
    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }
    /**
     * The sets the getNameCustomer from the customer's class
     */
    public String getNameCustomer() {
        return nameCustomer;
    }
    /**
     * The sets the setNameCustomer from the customer's class
     */
    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }
    /**
     * The sets the getAddressCustomer from the customer's class
     */
    public String getAddressCustomer() {
        return addressCustomer;
    }
    /**
     * The sets the setAddressCustomer from the customer's class
     */
    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }
    /**
     * The sets the getZipCustomer from the customer's class
     */
    public String getZipCustomer() {
        return zipCustomer;
    }
    /**
     * The sets the setZipCustomer from the customer's class
     */
    public void setZipCustomer(String zipCustomer) {
        this.zipCustomer = zipCustomer;
    }
    /**
     * The sets the getPhoneCustomer from the customer's class
     */
    public String getPhoneCustomer() {
        return phoneCustomer;
    }
    /**
     * The sets the setPhoneCustomer from the customer's class
     */
    public void setPhoneCustomer(String phoneCustomer) {
        this.phoneCustomer = phoneCustomer;
    }
    /**
     * The sets the getCreateCustomer from the customer's class
     */
    public Date getCreateCustomer() {
        return createCustomer;
    }
    /**
     * The sets the setCreateCustomer from the customer's class
     */
    public void setCreateCustomer(Date createCustomer) {
        this.createCustomer = createCustomer;
    }
    /**
     * The sets the getCreateByCustomer from the customer's class
     */
    public String getCreateByCustomer() {
        return createByCustomer;
    }
    /**
     * The sets the getCreateByCustomer from the customer's class
     */
    public void setCreateByCustomer(String createByCustomer) {
        this.createByCustomer = createByCustomer;
    }
    /**
     * The sets the getUpdatedCustomer from the customer's class
     */
    public Timestamp getUpdatedCustomer() {
        return updatedCustomer;
    }
    /**
     * The sets the setUpdatedCustomer from the customer's class
     */
    public void setUpdatedCustomer(Timestamp updatedCustomer) {
        this.updatedCustomer = updatedCustomer;
    }
    /**
     * The sets the getUpdatedByCustomer from the customer's class
     */
    public String getUpdatedByCustomer() {
        return updatedByCustomer;
    }
    /**
     * The sets the setUpdatedByCustomer from the customer's class
     */
    public void setUpdatedByCustomer(String updatedByCustomer) {
        this.updatedByCustomer = updatedByCustomer;
    }
    /**
     * The sets the getDivIDCustomer from the customer's class
     */
    public Integer getDivIDCustomer() {
        return DivIDCustomer;
    }
    /**
     * The sets the setDivIDCustomer from the customer's class
     */
    public void setDivIDCustomer(Integer divIDCustomer) {
        DivIDCustomer = divIDCustomer;
    }
    /**
     * The sets the getCountry from the customer's class
     */
    public String getCountry() {
        return countryCustomer;
    }
    /**
     * The sets the setCountry from the customer's class
     */
    public String setCountry(String countryCustomer)throws Exception {
        MySQL_Connection Conn2MySQL = new MySQL_Connection();
        PreparedStatement statementGetPresentState = Conn2MySQL.getConnection().prepareStatement("SELECT Division,Division_ID from first_level_divisions WHERE  Division_ID = " + DivIDCustomer);
        ResultSet rsState = statementGetPresentState.executeQuery();
        while (rsState.next()) {

            System.out.println(rsState.getString("Division"));
            String countryValue = "";
            Integer DivToUpdate = rsState.getInt("Division_ID");
            System.out.println(DivToUpdate);
            if (DivToUpdate >= 1 && DivToUpdate <= 54) {
                countryValue = "USA";


            } else if (DivToUpdate >= 55 && DivToUpdate <= 72) {
                countryValue = "Canada";

            } else if (DivToUpdate >= 101 && DivToUpdate <= 104) {
                countryValue = "England";
            }

            this.countryCustomer = countryCustomer;
            return countryCustomer;
        }
        return countryCustomer;
    }
//-------------------------------------------------------------------------------------------------------------
    /**
     * The sets the setStateCustomer from the customer's class
     */
    public String getStateCustomer() {
        return stateCustomer;
    }

    public String setStateCustomer(String stateCustomer) throws  Exception{

        MySQL_Connection Conn2MySQL = new MySQL_Connection();
        PreparedStatement statementQueryCustomer = Conn2MySQL.getConnection().prepareStatement("SELECT Division from first_level_divisions where Division_ID = "
                +DivIDCustomer);
        ResultSet rsQueryCustomer = statementQueryCustomer.executeQuery();
        while (rsQueryCustomer.next()) {
            System.out.println(rsQueryCustomer.getString("Division_ID"));
            stateCustomer =rsQueryCustomer.getString("Division_ID");
            return stateCustomer;
        }

        this.stateCustomer = stateCustomer;
        return stateCustomer;
    }




}


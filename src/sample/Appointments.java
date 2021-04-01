package sample;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 * The sets is used to instantiate Appointment objects from from
 */


public class Appointments {

    private Integer Appointment_ID;
    private String Title;
    private String Description;
    private String Location;
    private Timestamp Start;
    private Timestamp End;
    private Date Create_Date;
    private String Created_By;
    private Timestamp Last_Update;
    private String Last_Updated_By_By;
    private Integer Customer_ID;
    private Integer User_ID;
    private Integer Contact_ID;

    private Integer TypeCount;
    private String Type;
    private String APTS;

    /**
     * The sets the Appointment's constructor
     */

    public Appointments(Integer typeCount, String type, String APTS) {
        TypeCount = typeCount;
        Type = type;
        this.APTS = APTS;
    }

    /**
     * The sets an overloaded Appointment's constructor
     */

    public Appointments(Integer appointment_ID, String title, String description, String location, String type, Timestamp start, Timestamp end, Date create_Date, String created_By, Timestamp last_Update, String last_Updated_By_By, Integer customer_ID, Integer user_ID, Integer contact_ID) {
        Appointment_ID = appointment_ID;
        Title = title;
        Description = description;
        Location = location;
        Type = type;
        Start = start;
        End = end;
        Create_Date = create_Date;
        Created_By = created_By;
        Last_Update = last_Update;
        Last_Updated_By_By = last_Updated_By_By;
        Customer_ID = customer_ID;
        User_ID = user_ID;
        Contact_ID = contact_ID;
    }
    /**
     * The sets an overloaded Appointment's constructor
     */
    public Appointments(Integer appointment_ID, String title, String description, String location, String type, Timestamp start, Timestamp end, Date create_Date, String created_By, Timestamp last_Update, Integer customer_ID, Integer user_ID, Integer contact_ID) {
        Appointment_ID = appointment_ID;
        Title = title;
        Description = description;
        Location = location;
        Type = type;
        Start = start;
        End = end;
        Create_Date = create_Date;
        Created_By = created_By;
        Last_Update = last_Update;
        Customer_ID = customer_ID;
        User_ID = user_ID;
        Contact_ID = contact_ID;
    }
    /**
     * The sets an overloaded Appointment's constructor
     */
    public Appointments(int appointment_ID, String title, String description, String location,Integer contact_id, String type, Timestamp start, Timestamp end, Integer customer_id) {
        Appointment_ID = appointment_ID;
        Title = title;
        Description = description;
        Location = location;
        Contact_ID = contact_id;
        Type = type;
        Start = start;
        End = end;
        Customer_ID = customer_id;

    }
    /**
     * The sets the getAppointment_ID in the  Appointment's class
     */
    public Integer getAppointment_ID() {
        return Appointment_ID;
    }
    /**
     * The sets the setAppointment_ID in the  Appointment's class
     */
    public void setAppointment_ID(Integer appointment_ID) {
        Appointment_ID = appointment_ID;
    }
    /**
     * The sets the getTitle in the  Appointment's class
     */
    public String getTitle() {
        return Title;
    }
    /**
     * The sets the setTitle in the  Appointment's class - Getters & Setters
     */
    public void setTitle(String title) {
        Title = title;
    }
    /**
     * The sets the getDescription in the  Appointment's class - Getters & Setters
     */
    public String getDescription() {
        return Description;
    }
    /**
     * The sets the setDescription in the  Appointment's class - Getters & Setters
     */
    public void setDescription(String description) {
        Description = description;
    }
    /**
     * The sets the getLocation in the  Appointment's class - Getters & Setters
     */
    public String getLocation() {
        return Location;
    }
    /**
     * The sets the setLocation in the  Appointment's class - Getters & Setters
     */
    public void setLocation(String location) {
        Location = location;
    }
    /**
     * The sets the getType in the  Appointment's class - Getters & Setters
     */
    public String getType() {
        return Type;
    }
    /**
     * The sets the setType in the  Appointment's class - Getters & Setters
     */
    public void setType(String type) {
        Type = type;
    }
    /**
     * The sets the getStart in the  Appointment's class - Getters & Setters
     */
    public Timestamp getStart() {
        return Start;
    }
    /**
     * The sets Getters & Setters in the  Appointment's class - Getters & Setters
     */
    public void setStart(Timestamp start)
    {
        //lbLoginTimeZone.setText(String.valueOf(ZoneId.systemDefault()));
        //lbLoginUTCtimeZone.setText("UTC " + OffsetDateTime.now().getOffset());


       // ZonedDateTime zdt = ZonedDateTime.from(Start.toInstant().atOffset(ZoneOffset.of(String.valueOf(ZoneId.of("America/Los_Angeles")))));
       // start = Timestamp.valueOf(String.valueOf(zdt));
        this.Start = start;
    }
    /**
     * The sets Getters & Setters in the  Appointment's class - Getters & Setters
     */
    public Timestamp getEnd() {
        return End;
    }
    /**
     * The sets Getters & Setters in the  Appointment's class - Getters & Setters
     */
    public void setEnd(Timestamp end) {
        End = end;
    }
    /**
     * The sets Getters & Setters in the  Appointment's class - Getters & Setters
     */
    public Date getCreate_Date() {
        return Create_Date;
    }
    /**
     * The sets Getters & Setters in the  Appointment's class - Getters & Setters
     */
    public void setCreate_Date(Date create_Date) {
        Create_Date = create_Date;
    }
    /**
     * The sets Getters & Setters in the  Appointment's class - Getters & Setters
     */
    public String getCreated_By() {
        return Created_By;
    }

    public void setCreated_By(String created_By) {
        Created_By = created_By;
    }
    /**
     * The sets Getters & Setters in the  Appointment's class - Getters & Setters
     */
    public Timestamp getLast_Update() {
        return Last_Update;
    }
    /**
     * The sets Getters & Setters in the  Appointment's class - Getters & Setters
     */
    public void setLast_Update(Timestamp last_Update) {
        Last_Update = last_Update;
    }
    /**
     * The sets Getters & Setters in the  Appointment's class - Getters & Setters
     */
    public String getLast_Updated_By_By() {
        return Last_Updated_By_By;
    }
    /**
     * The sets Getters & Setters in the  Appointment's class - Getters & Setters
     */
    public void setLast_Updated_By_By(String last_Updated_By_By) {
        Last_Updated_By_By = last_Updated_By_By;
    }
    /**
     * The sets Getters & Setters in the  Appointment's class - Getters & Setters
     */
    public Integer getCustomer_ID() {
        return Customer_ID;
    }
    /**
     * The sets Getters & Setters in the  Appointment's class - Getters & Setters
     */
    public void setCustomer_ID(Integer customer_ID) {
        Customer_ID = customer_ID;
    }
    /**
     * The sets Getters & Setters in the  Appointment's class - Getters & Setters
     */
    public Integer getUser_ID() {
        return User_ID;
    }
    /**
     * The sets Getters & Setters in the  Appointment's class - Getters & Setters
     */
    public void setUser_ID(Integer user_ID) {
        User_ID = user_ID;
    }
    /**
     * The sets Getters & Setters in the  Appointment's class - Getters & Setters
     */
    public Integer getContact_ID() {
        return Contact_ID;
    }
    /**
     * The sets Getters & Setters in the  Appointment's class - Getters & Setters
     */
    public void setContact_ID(Integer contact_ID) {
        Contact_ID = contact_ID;
    }
    /**
     * The sets Getters & Setters in the  Appointment's class - Getters & Setters
     */
    public Integer getTypeCount() {
        return TypeCount;
    }
    /**
     * The sets Getters & Setters in the  Appointment's class - Getters & Setters
     */
    public void setTypeCount(Integer typeCount) {
        TypeCount = typeCount;
    }
    /**
     * The sets Getters & Setters in the  Appointment's class - Getters & Setters
     */
    public String getAPTS() {
        return APTS;
    }
    /**
     * The sets Getters & Setters in the  Appointment's class - Getters & Setters
     */
    public void setAPTS(String APTS) {
        this.APTS = APTS;
    }
















































}

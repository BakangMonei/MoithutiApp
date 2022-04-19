package com.research.schoolingapp.databaseHelper;

import java.util.*;
import com.research.schoolingapp.*;
import com.research.schoolingapp.financingOfStudendets.studentsApplications;

import android.content.*; // Context, ContentValues
import android.database.*; // Cursors
import android.database.sqlite.*; // SQLiteOpenHelper, SQLiteDatabase

/*
* 1. Add new Student
* 2. View Students
* 3. Update student
* 4. Delete Student*/

public class DBHelper extends SQLiteOpenHelper{
    // Creating a constant variables for our database.
    private static final String DB_NAME = "StudentsDB"; // Variable is for our database name.
    private static final int DB_VERSION = 1; // Our database version
    private static final String TABLE_NAME = "Users"; // Variable is for our table name.

    private static final String EMAIL_COL = "email"; // Variable is for our email column.
    private static final String FIRSTNAME_COL = "firstName"; // Variable is for our firstName column
    private static final String LASTNAME_COL = "lastName"; // Variable is for our lastName column.
    private static final String GENDER_COL = "Gender"; // Variable is for our gender column.
    private static final String ADDRESS_COL = "PhysicalAddress"; // Variable is for our address column.
    private static final String COUNTRY_COL = "Country"; // Variable is for our Country column.
    private static final String IDPASSPORT_COL = "ID/Passport"; // Variable is for our ID/Passport numbers column.
    private static final String DOB_COL = "DateOfBirth"; // Variable is for our DOB column.
    private static final String PHONENUMBER_COL = "PhoneNumber"; // Variable is for our phoneNumber column.
    private static final String PASS_COL = "Password"; // Variable is for our phoneNumber column.
    private static final String REPASS_COL = "RePassWord"; // Variable is for our phoneNumber column.

    // Creating a constructor for our database handler.
    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // The table + columns
    public void onCreate(SQLiteDatabase db){
        String query = "Create Table " + TABLE_NAME + "(" +
                EMAIL_COL + " TEXT," +
                FIRSTNAME_COL + " TEXT," +
                LASTNAME_COL + " TEXT," +
                GENDER_COL + " TEXT," +
                ADDRESS_COL + " TEXT," +
                COUNTRY_COL + " TEXT," +
                IDPASSPORT_COL + " TEXT," +
                DOB_COL + " TEXT," +
                PHONENUMBER_COL + " TEXT," +
                PASS_COL + " TEXT," +
                REPASS_COL + " TEXT)";
        db.execSQL(query); // At last we are calling a exec sql method to execute above sql query
    }

    // Method for adding new Student to our sqlite database.
    public void addNewStudent(String email, String firstName, String lastName, String gender, String address, String country, String IDPassport, String DOB, String phoneNumber, String pass, String rePass){
        SQLiteDatabase db = this.getWritableDatabase(); // This line we are creating a variable for our sqlite database and calling writable method as we are writing data in our database.
        ContentValues values = new ContentValues();// This line we are creating a variable for content values.

        // Below lines we are passing all values along with its key and value pair.
        values.put(EMAIL_COL, email);
        values.put(FIRSTNAME_COL, firstName);
        values.put(LASTNAME_COL, lastName);
        values.put(GENDER_COL, gender);
        values.put(ADDRESS_COL, address);
        values.put(COUNTRY_COL, country);
        values.put(IDPASSPORT_COL, IDPassport);
        values.put(DOB_COL, DOB);
        values.put(PHONENUMBER_COL, phoneNumber);
        values.put(PASS_COL, pass);
        values.put(REPASS_COL, rePass);

        // After adding all values we are passing content values to our table.
        db.insert(TABLE_NAME, null,values);
        // At last we are closing our database after adding database.
        db.close();
    }

    // Method for reading all Students
    public ArrayList<Students> readStudents(){
        SQLiteDatabase db = this.getReadableDatabase(); // On this line we are creating a database for reading our database.
        Cursor cursorStudents = db.rawQuery("SELECT * FROM " + TABLE_NAME, null); // This line we are creating a cursor with query to read data from database.

        ArrayList<Students> studentsArrayList= new ArrayList<>(); // This line we are creating a new array list.
        // Moving our cursor to first position.
        if (cursorStudents.moveToFirst()){
            do{
                studentsArrayList.add(new Students(
                        cursorStudents.getString(0),
                        cursorStudents.getString(1),
                        cursorStudents.getString(2),
                        cursorStudents.getString(3),
                        cursorStudents.getString(4),
                        cursorStudents.getString(5),
                        cursorStudents.getString(6),
                        cursorStudents.getString(7),
                        cursorStudents.getString(8),
                        cursorStudents.getString(9),
                        cursorStudents.getString(10)));
            }
            while (cursorStudents.moveToNext()); // moving our cursor to next
        }
        // Lastly closing our cursor and returning our array list.
        cursorStudents.close();
        return studentsArrayList;
    }

    // Method to update student info
    public void updateStudent(Students students){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(EMAIL_COL, students.email);
        values.put(FIRSTNAME_COL, students.firstName);
        values.put(LASTNAME_COL, students.lastName);
        values.put(GENDER_COL, students.Gender);
        values.put(ADDRESS_COL, students.Address);
        values.put(COUNTRY_COL, students.Country);
        values.put(IDPASSPORT_COL, students.IDPassport);
        values.put(DOB_COL, students.DOB);
        values.put(PHONENUMBER_COL, students.phoneNumber);
        values.put(PASS_COL, students.pass);
        values.put(REPASS_COL, students.rePass);

        // Updating row
        db.update(TABLE_NAME, values, EMAIL_COL + " = ?", new String[] {String.valueOf(students.getEmail())});
        db.close();

    }

    // Method for deleting student
    public void deleteStudent(studentsApplications delStu){
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete user by email
        db.delete(TABLE_NAME, EMAIL_COL + " = ?", new String[] {String.valueOf(delStu.getEmail())});
        db.close();
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
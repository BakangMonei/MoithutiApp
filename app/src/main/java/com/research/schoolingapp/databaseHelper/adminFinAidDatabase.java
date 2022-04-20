package com.research.schoolingapp.databaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.research.schoolingapp.administrators.admin;
import com.research.schoolingapp.financingOfStudendets.studentsApplications;

import java.util.ArrayList;

public class adminFinAidDatabase extends SQLiteOpenHelper {
    // Creating a constant variables for our database.
    private static final String DB_NAME = "StudentsApplicationsFinAidDB"; // Variable is for our database name.
    private static final int DB_VERSION = 1; // Our database version
    private static final String TABLE_NAME = "ApplicationsForFinAid"; // Variable is for our table name.

    private static final String FIRSTNAME_COL = "firstName"; // Variable is for our firstName column
    private static final String LASTNAME_COL = "lastName"; // Variable is for our lastName column.
    private static final String EMAIL_COL = "email"; // Variable is for our email column.
    private static final String PHONENUMBER_COL = "PhoneNumber"; // Variable is for our phoneNumber column.
    private static final String ADDRESS_COL = "PhysicalAddress"; // Variable is for our address column.
    private static final String INSTITUTE1_COL = "INSTITUTE1"; // Variable is for our address column.
    private static final String PROGRAMME1_COL = "PROGRAMME1"; // Variable is for our address column.
    private static final String INSTITUTE2_COL = "INSTITUTE2"; // Variable is for our address column.
    private static final String PROGRAMME2_COL = "PROGRAMME2"; // Variable is for our address column.

    // Creating a constructor for our database handler.
    public adminFinAidDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // The table + columns
    public void onCreate(SQLiteDatabase db){
        // On below line we are creating an sqlite query and we are setting our column names along with their data types.
        String query = "Create Table " + TABLE_NAME + "(" +
                EMAIL_COL + " TEXT," +
                FIRSTNAME_COL + " TEXT," +
                LASTNAME_COL + " TEXT," +
                ADDRESS_COL + " TEXT," +
                PHONENUMBER_COL + " TEXT," +
                INSTITUTE1_COL + " TEXT," +
                PROGRAMME1_COL + " TEXT," +
                INSTITUTE2_COL + " TEXT," +
                PROGRAMME2_COL + " TEXT)";
        db.execSQL(query); // At last we are calling a exec sql method to execute above sql query
    }

    // Method for adding new Student applications to our sqlite database.
    public void newStudentAdminFinAid(String email, String firstName, String lastName, String Address, String phoneNumber, String institute1, String course1, String institute2, String course2){
        SQLiteDatabase db = this.getWritableDatabase(); // This line we are creating a variable for our sqlite database and calling writable method as we are writing data in our database.
        ContentValues values = new ContentValues();// This line we are creating a variable for content values.

        // Below lines we are passing all values along with its key and value pair.
        values.put(EMAIL_COL, email);
        values.put(FIRSTNAME_COL, firstName);
        values.put(LASTNAME_COL, lastName);
        values.put(ADDRESS_COL, Address);
        values.put(PHONENUMBER_COL, phoneNumber);
        values.put(INSTITUTE1_COL, institute1);
        values.put(PROGRAMME1_COL, course1);
        values.put(INSTITUTE2_COL, institute2);
        values.put(PROGRAMME2_COL, course2);
        // After adding all values we are passing content values to our table.
        db.insert(TABLE_NAME, null,values);
        // At last we are closing our database after adding database.
        db.close();
    }

    // Method for reading all student applications
    public ArrayList<admin> readStudentApplicationsAdminFinAid(){
        SQLiteDatabase db = this.getReadableDatabase(); // On this line we are creating a database for reading our database.
        Cursor cursorStudentsApplicationsAdminFinAid = db.rawQuery("SELECT * FROM " + TABLE_NAME, null); // This line we are creating a cursor with query to read data from database.

        ArrayList<admin> studentsApplicationsAdminFinAidArrayList = new ArrayList<>(); // This line we are creating a new array list.
        // Moving our cursor to first position.
        if (cursorStudentsApplicationsAdminFinAid.moveToFirst()){
            do{
                studentsApplicationsAdminFinAidArrayList.add(new admin(
                        cursorStudentsApplicationsAdminFinAid.getString(0),
                        cursorStudentsApplicationsAdminFinAid.getString(1),
                        cursorStudentsApplicationsAdminFinAid.getString(2),
                        cursorStudentsApplicationsAdminFinAid.getString(3),
                        cursorStudentsApplicationsAdminFinAid.getString(4),
                        cursorStudentsApplicationsAdminFinAid.getString(5),
                        cursorStudentsApplicationsAdminFinAid.getString(6),
                        cursorStudentsApplicationsAdminFinAid.getString(7),
                        cursorStudentsApplicationsAdminFinAid.getString(8)));
            }
            while (cursorStudentsApplicationsAdminFinAid.moveToNext()); // moving our cursor to next
        }
        // Lastly closing our cursor and returning our array list.
        cursorStudentsApplicationsAdminFinAid.close();
        return studentsApplicationsAdminFinAidArrayList;
    }

    // Method to update studentApplications
    public void updateStudentAdminFinAidApplication(admin ADMIN){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EMAIL_COL, ADMIN.email);
        values.put(FIRSTNAME_COL, ADMIN.firstName);
        values.put(LASTNAME_COL, ADMIN.lastName);
        values.put(ADDRESS_COL, ADMIN.address);
        values.put(PHONENUMBER_COL, ADMIN.phoneNumber);
        values.put(INSTITUTE1_COL, ADMIN.institute1);
        values.put(PROGRAMME1_COL, ADMIN.course1);
        values.put(INSTITUTE2_COL, ADMIN.institute2);
        values.put(PROGRAMME2_COL, ADMIN.course2);
        // Updating row
        db.update(TABLE_NAME, values, EMAIL_COL + " = ?", new String[] {String.valueOf(ADMIN.getEmail())});
        db.close();
    }

    // Method for deleting student Application
    public void deleteStudentAdminFinAidApplication(admin delAdminStuApp){
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete user by email
        db.delete(TABLE_NAME, EMAIL_COL + " = ?", new String[] {String.valueOf(delAdminStuApp.getEmail())});
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

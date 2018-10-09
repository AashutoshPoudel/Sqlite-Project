package com.planetearthsolution.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;


public class PersonDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "usersDb.pes";
    private static final int DATABASE_VERSION = 3;
    public static final String TABLE_NAME = "users_information";

    //tables
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_PERSON_FN = "first_name";
    public static final String COLUMN_PERSON_MN = "middle_name";
    public static final String COLUMN_PERSON_LN = "last_name";
    public static final String COLUMN_PERSON_GENDER = "gender";
    public static final String COLUMN_PERSON_DOB = "date_of_birth";
    public static final String COLUMN_PERSON_CITIZENSHIP_NUMBER = "citizenship_number";
    public static final String COLUMN_PERSON_DRIVING_LICENSE_NUMBER = "driving_license_number";
    public static final String COLUMN_PERSON_PHONE_NUMBER = "phone_number";
    public static final String COLUMN_PERSON_PERMANENT_ADDRESS = "permanent_address";
    public static final String COLUMN_PERSON_OCCUPATION = "occupation";
    public static final String COLUMN_PERSON_SPOUSE_NAME = "spouse_name";
    public static final String COLUMN_PERSON_FATHER_NAME = "father_name";
    public static final String COLUMN_PERSON_FATHER_CONTACT = "father_contact";
    public static final String COLUMN_PERSON_MOTHER_NAME = "mother_name";
    public static final String COLUMN_PERSON_MOTHER_CONTACT = "mother_CONTACT";
    public static final String COLUMN_PERSON_GRANDFATHER_NAME = "grandfather_name";


    public PersonDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PERSON_FN + " TEXT NOT NULL, " +
                COLUMN_PERSON_MN + " TEXT, " +
                COLUMN_PERSON_LN + " TEXT, " +
                COLUMN_PERSON_GENDER + " TEXT, " +
                COLUMN_PERSON_DOB + " TEXT, " +
                COLUMN_PERSON_CITIZENSHIP_NUMBER + " TEXT NOT NULL, " +
                COLUMN_PERSON_DRIVING_LICENSE_NUMBER + " TEXT, " +
                COLUMN_PERSON_PHONE_NUMBER + " TEXT, " +
                COLUMN_PERSON_PERMANENT_ADDRESS + " TEXT, " +
                COLUMN_PERSON_OCCUPATION + " TEXT, " +
                COLUMN_PERSON_SPOUSE_NAME + " TEXT, " +
                COLUMN_PERSON_FATHER_NAME + " TEXT, " +
                COLUMN_PERSON_FATHER_CONTACT + " TEXT, " +
                COLUMN_PERSON_MOTHER_NAME + " TEXT, " +
                COLUMN_PERSON_MOTHER_CONTACT + " TEXT, " +
                COLUMN_PERSON_GRANDFATHER_NAME + " TEXT );"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // you can implement here migration process
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }

    /**
     * create record
     **/
    public void saveNewPerson(Person person) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PERSON_FN, person.getFirst_name());
        values.put(COLUMN_PERSON_MN, person.getMiddle_name());
        values.put(COLUMN_PERSON_LN, person.getLast_name());
        values.put(COLUMN_PERSON_GENDER, person.getGender());
        values.put(COLUMN_PERSON_DOB, person.getDate_of_birth());
        values.put(COLUMN_PERSON_CITIZENSHIP_NUMBER, person.getCitizenship_no());
        values.put(COLUMN_PERSON_DRIVING_LICENSE_NUMBER, person.getDriving_license_no());
        values.put(COLUMN_PERSON_PHONE_NUMBER, person.getPh_no());
        values.put(COLUMN_PERSON_PERMANENT_ADDRESS, person.getPermanent_address());
        values.put(COLUMN_PERSON_OCCUPATION, person.getOccupation());
        values.put(COLUMN_PERSON_SPOUSE_NAME, person.getSpouse_name());
        values.put(COLUMN_PERSON_FATHER_NAME, person.getFather_name());
        values.put(COLUMN_PERSON_FATHER_CONTACT, person.getFather_contact());
        values.put(COLUMN_PERSON_MOTHER_NAME, person.getMother_name());
        values.put(COLUMN_PERSON_MOTHER_CONTACT, person.getMother_contact());
        values.put(COLUMN_PERSON_GRANDFATHER_NAME, person.getGrandfather_name());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    /**
     * Query records, give options to filter results
     **/
    public List<Person> peopleList(String filter) {
        String query;
        if (filter.equals("")) {
            //regular query
            query = "SELECT  * FROM " + TABLE_NAME;
        } else {
            //filter results by filter option provided
            query = "SELECT  * FROM " + TABLE_NAME + " ORDER BY " + filter;
        }

        List<Person> personLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Person person;

        if (cursor.moveToFirst()) {
            do {
                person = new Person();

                person.setId(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));

                person.setFirst_name(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_FN)));
                person.setMiddle_name(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_MN)));
                person.setLast_name(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_LN)));
                person.setGender(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_GENDER)));
                person.setDate_of_birth(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_DOB)));
                person.setCitizenship_no(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_CITIZENSHIP_NUMBER)));
                person.setDriving_license_no(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_DRIVING_LICENSE_NUMBER)));
                person.setPh_no(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_PHONE_NUMBER)));
                person.setPermanent_address(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_PERMANENT_ADDRESS)));
                person.setOccupation(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_OCCUPATION)));
                person.setSpouse_name(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_SPOUSE_NAME)));
                person.setFather_name(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_FATHER_NAME)));
                person.setFather_contact(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_FATHER_CONTACT)));
                person.setMother_name(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_MOTHER_NAME)));
                person.setMother_contact(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_MOTHER_CONTACT)));
                person.setGrandfather_name(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_GRANDFATHER_NAME)));

                personLinkedList.add(person);

            } while (cursor.moveToNext());
        }


        return personLinkedList;
    }

    /**
     * Query only 1 record
     **/
    public Person getPerson(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT  * FROM " + TABLE_NAME + " WHERE _id=" + id;
        Cursor cursor = db.rawQuery(query, null);

        Person receivedPerson = new Person();
        if (cursor.getCount() > 0) {

            cursor.moveToFirst();

            receivedPerson.setFirst_name(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_FN)));
            receivedPerson.setMiddle_name(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_MN)));
            receivedPerson.setLast_name(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_LN)));
            receivedPerson.setGender(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_GENDER)));
            receivedPerson.setDate_of_birth(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_DOB)));
            receivedPerson.setCitizenship_no(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_CITIZENSHIP_NUMBER)));
            receivedPerson.setDriving_license_no(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_DRIVING_LICENSE_NUMBER)));
            receivedPerson.setPh_no(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_PHONE_NUMBER)));
            receivedPerson.setPermanent_address(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_PERMANENT_ADDRESS)));
            receivedPerson.setOccupation(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_OCCUPATION)));
            receivedPerson.setSpouse_name(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_SPOUSE_NAME)));
            receivedPerson.setFather_name(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_FATHER_NAME)));
            receivedPerson.setFather_contact(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_FATHER_CONTACT)));
            receivedPerson.setMother_name(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_MOTHER_CONTACT)));
            receivedPerson.setMother_contact(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_MOTHER_CONTACT)));
            receivedPerson.setGrandfather_name(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_GRANDFATHER_NAME)));
        }


        return receivedPerson;


    }


    /**
     * delete record
     **/
    public void deletePersonRecord(long id, Context context) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE id='" + id + "'");
        Toast.makeText(context, "Deleted successfully.", Toast.LENGTH_SHORT).show();

    }

    /**
     * update record
     **/
    public void updatePersonRecord(long personId, Context context, Person updatedperson) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        //you can use the constants above instead of typing the column names
//        db.execSQL(
//     "UPDATE  "+TABLE_NAME+" SET name ='"+ updatedperson.getName()+ "', age ='" + updatedperson.getAge()+ "', occupation ='"+ updatedperson.getOccupation() + "'  WHERE _id='" + personId + "'");
//        Toast.makeText(context, "Updated successfully.", Toast.LENGTH_SHORT).show();
//
//
//    }


    }

}

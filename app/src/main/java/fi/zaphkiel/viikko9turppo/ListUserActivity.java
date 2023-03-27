package fi.zaphkiel.viikko9turppo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class ListUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
    }
    public void listUsers(View view) {
        ArrayList<User> userList = UserStorage.getInstance().getUserList();
        String firstName, lastName, eMail, degreeProgram;

        System.out.println("Listaan on tallennettu seuraavat käyttäjät:");
        for (User user : userList) {
            System.out.println(user.firstName + " " + user.lastName);
            System.out.println(user.eMail);
            System.out.println(user.degreeProgram + "\n");
        }
    }
}
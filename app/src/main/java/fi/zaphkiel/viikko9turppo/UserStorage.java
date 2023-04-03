package fi.zaphkiel.viikko9turppo;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class UserStorage {
    final String FILENAME = "userList.data";
    private ArrayList<User> userList = new ArrayList<>();

    private static UserStorage userStorage = null;
    private UserStorage(){
    }

    public static UserStorage getInstance() {
        if (userStorage == null) {
            userStorage = new UserStorage();
        }
        return userStorage;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void removeUser(int id) {
        userList.remove(id);
    }

    public void saveUserList(Context context) {
        try {
            ObjectOutputStream saveUsers = new ObjectOutputStream(context.openFileOutput(FILENAME, Context.MODE_PRIVATE));
            saveUsers.writeObject(userList);
            System.out.println("Käyttäjälista tallennettu");
            saveUsers.close();
        } catch (IOException e) {
            System.out.println("Käyttäjien tallentaminen epäonnistui.");
            e.printStackTrace();
        }
    }

    public void loadUsers(Context context) {
        try {
            ObjectInputStream loadUsers = new ObjectInputStream(context.openFileInput(FILENAME));
            userList = (ArrayList<User>) loadUsers.readObject();
            System.out.println("Käyttäjälista ladattu.");
            loadUsers.close();
        } catch (FileNotFoundException e) {
            System.out.println("Käyttäjälistaa ei löytynyt.");
        } catch (IOException e) {
            System.out.println("Käyttäjien lataaminen epäonnistui.");
        } catch (ClassNotFoundException e) {
            System.out.println("Käyttäjien lataaminen epäonnistui.");
        }
    }
}

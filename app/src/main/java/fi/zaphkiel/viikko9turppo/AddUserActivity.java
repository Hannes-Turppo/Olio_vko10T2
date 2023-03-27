package fi.zaphkiel.viikko9turppo;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class AddUserActivity extends AppCompatActivity {

    private EditText txtInput1;
    private EditText txtInput2;
    private EditText txtInput3;
    String firstName, lastName, eMail, degreeProgram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser1);
        txtInput1 = findViewById(R.id.txtGivenName);
        txtInput2 = findViewById(R.id.txtFamilyName);
        txtInput3 = findViewById(R.id.txtEmailAddress);
    }

    public void addUser(View view) {
        RadioGroup rgDegreeProgram = findViewById(R.id.rgDegreeProgram);

        firstName = txtInput1.getText().toString();
        lastName = txtInput2.getText().toString();
        eMail = txtInput3.getText().toString();

        switch(rgDegreeProgram.getCheckedRadioButtonId()) {
            case R.id.rbTITE:
                degreeProgram = "Tietotekniikka";
                break;
            case R.id.rbTUTA:
                degreeProgram = "Tuotantotalous";
                break;
            case R.id.rbLATE:
                degreeProgram = "Laskennallinen tekniikka";
                break;
            case R.id.rbSahko:
                degreeProgram = "Sähkötekniikka";
                break;
        }
        User user = new User(firstName, lastName, eMail, degreeProgram);
        UserStorage.getInstance().addUser(user);
    }
}

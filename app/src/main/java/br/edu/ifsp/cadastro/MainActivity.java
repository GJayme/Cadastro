package br.edu.ifsp.cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.ifsp.cadastro.model.Formulario;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText nameEt;
    private EditText phoneEt;
    private EditText emailEt;
    private EditText cityEt;
    private CheckBox checkedList;
    private RadioButton maleRb;
    private Spinner stateS;
    private Button clearBt;
    private Button saveBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEt = findViewById(R.id.nameEt);
        phoneEt = findViewById(R.id.phoneEt);
        emailEt = findViewById(R.id.emailEt);
        cityEt = findViewById(R.id.cityEt);
        checkedList = findViewById(R.id.checkedList);
        maleRb = findViewById(R.id.maleRb);
        stateS = findViewById(R.id.stateS);
        clearBt = findViewById(R.id.clearBt);
        saveBt = findViewById(R.id.saveBt);

        clearBt.setOnClickListener(this);
        saveBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Formulario formulario = setFormulario();
        String message = formulario.toString();
        if (view.getId() == R.id.saveBt && isAllFieldsFiled()) {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        } else if(view.getId() == R.id.clearBt) {
            clearAllFields();
        }
    }

    private boolean isAllFieldsFiled() {
        return !nameEt.getText().toString().equals("") &&
                !phoneEt.getText().toString().equals("") &&
                !emailEt.getText().toString().equals("") &&
                !cityEt.getText().toString().equals("");
    }

    private void clearAllFields() {
        nameEt.setText("");
        phoneEt.setText("");
        emailEt.setText("");
        cityEt.setText("");
        checkedList.setChecked(false);
        maleRb.setChecked(true);
        stateS.setSelection(0);
    }

    private Formulario setFormulario() {
        String name = nameEt.getText().toString();
        String phone = phoneEt.getText().toString();
        String email = emailEt.getText().toString();
        String gender = maleRb.isChecked()?"Masculino":"Feminino";
        boolean isList = checkedList.isChecked();
        String city = cityEt.getText().toString();
        String state = ((TextView)stateS.getSelectedView()).getText().toString();

        return new Formulario(name, phone, email, gender, isList, city, state);
    }
}
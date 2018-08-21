package janine.gomes.projetofinal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import janine.gomes.projetofinal.model.Usuario;

public class Cadastro extends AppCompatActivity {

    //Widgets
    //private EditText etNome;
    private EditText etEmail;
    private EditText etSenha;
    private Button btCadastrar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //Refes
        //etNome = findViewById(R.id.cd_et_nome);
        etSenha = findViewById(R.id.cd_et_senha);
        etEmail = findViewById(R.id.cd_et_email);
        btCadastrar =findViewById(R.id.cd_bt_cadastrar);


        mAuth = FirebaseAuth.getInstance();


        //Inicialização do Firebase
        /*FirebaseApp.initializeApp(Cadastro.this);
        final FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference banco = db.getReference("users");*/

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((etSenha.getText().toString().isEmpty())&&(etEmail.getText().toString().isEmpty())){
                    toast("Preencha os dados!");
                }else{ //fecha if abre else

                    Usuario user = new Usuario();
                    //user.setNome(etNome.getText().toString());
                    user.setEmail(etEmail.getText().toString());
                    user.setSenha(etSenha.getText().toString());
                    //Enviando para nuvem!
                    //banco.push().setValue(user);

                    mAuth.createUserWithEmailAndPassword(user.getEmail(), user.getSenha())
                            .addOnCompleteListener(Cadastro.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if ( task.isSuccessful() ){//Sucesso ao cadastrar usuario
                                        Log.i("CreateUser", "Sucesso ao cadastrar usuário!");
                                    }else{
                                        Log.i("CreateUser", "Erro ao cadastrar usuário!");
                                    }
                                }
                            });

                    toast("Cadastro realizado com sucesso!");

                    limpar();
                    Intent it = new Intent(Cadastro.this, Login.class);
                    startActivity(it);
                    finish();
                }//fecha else
            }//fecha OnClick

        });//fim btCadastrar
    }//fecha oncreate

    private void toast(String msg){
        Toast.makeText(getBaseContext(),msg, Toast.LENGTH_LONG).show();
    }
    private void limpar(){
        //etNome.setText("");
        etEmail.setText("");
        etSenha.setText("");
    }
}//fecha Classe

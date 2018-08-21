package janine.gomes.projetofinal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import janine.gomes.projetofinal.model.Usuario;

public class Login extends AppCompatActivity {

    //Widgets
    private EditText etEmail;
    private EditText etSenha;
    private Button btEntrar;
    private Button btCadastro;
    private ProgressBar progress;

    //Firebase Auth
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //refes
        etEmail = findViewById(R.id.lg_et_email);
        etSenha =findViewById(R.id.lg_et_senha);
        btEntrar = findViewById(R.id.lg_bt_logar);
        btCadastro = findViewById(R.id.lg_bt_cadastro);
        progress = findViewById(R.id.lg_progress);

        progress.setVisibility(View.INVISIBLE);
        //Buscando ref. firebase
        mAuth = FirebaseAuth.getInstance();

        //Verificando se o usuário já logou anteriormente
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();

                if(user != null){
                    //Usuário está logado
                    Toast.makeText(
                            getBaseContext(),
                            "Você já está logado!",
                            Toast.LENGTH_LONG).show();

                    //redirecionar para tela de abertura
                    Intent it = new Intent(Login.this,MainActivity.class);
                    startActivity(it);
                    finish();

                }else{

                    //Usuário NÃO está logado
                    Toast.makeText(
                            getBaseContext(),
                            "Você não está logado ainda!",
                            Toast.LENGTH_LONG).show();
                }
            }
        };

        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!etEmail.getText().toString().isEmpty() &&
                        !etSenha.getText().toString().isEmpty()){

                    //Iniciando progress
                    progress.setVisibility(View.VISIBLE);

                    final Usuario u = new Usuario();
                    u.setEmail(etEmail.getText().toString());
                    u.setSenha(etSenha.getText().toString());

                    //Verificar e autenticar usuário no Firebase
                    mAuth.signInWithEmailAndPassword(u.getEmail(), u.getSenha())
                            .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if(!task.isSuccessful()){
                                        Toast.makeText(
                                                getBaseContext(),
                                                "Usuário NÃO autenticado!",
                                                Toast.LENGTH_LONG).show();
                                    }else{
                                        Toast.makeText(
                                                getBaseContext(),
                                                "Usuário autenticado com sucesso!",
                                                Toast.LENGTH_LONG).show();

                                        //redirecionar para tela de abertura
                                        Intent it = new Intent(Login.this,MainActivity.class);
                                        it.putExtra("user",u);
                                        startActivity(it);
                                        finish();
                                    }
                                    //Removendo progress
                                    progress.setVisibility(View.INVISIBLE);
                                }
                            });
                }else{
                    Toast.makeText(
                            getBaseContext(),
                            "Digite os dados para entrar no App",
                            Toast.LENGTH_LONG).show();
                }
            }//fecha onclick
        });//fim btEntrar

        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Login.this,Cadastro.class);
                startActivity(it);
            }
        });

    }
}

package janine.gomes.exeventobotao;

import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    //GLOBAL
    private MediaPlayer mp;
    private Button btSubzero;
    private Button btBaraka;
    private Button btJax;
    private Button btJonnyCage;
    private Button btKitana;
    private Button btKunglao;
    private Button btLiukang;
    private Button btMilena;
    private Button btRaiden;
    private Button btReptile;
    private Button btScorpion;
    private Button btShangtsung;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencias

        //SUBZERO------------------------------------
        btSubzero = findViewById(R.id.ma_bt_subzero);
        btSubzero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(R.raw.subzero);
                toast(R.string.ma_subzero);
            }
        });

        btSubzero.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                play(R.raw.bell);
                alert(R.string.ma_alert_mensagem_subzero);
                return true;
            }
        });

        //BARAKA----------------------------------
        btBaraka=findViewById(R.id.ma_bt_baraka);
        btBaraka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(R.raw.baraka);
               toast(R.string.ma_baraka);
            }
        });

        btBaraka.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                play(R.raw.bell);
                alert(R.string.ma_alert_mensagem_baraka);
                return true;
            }
        });

        //JAX-----------------------------------
        btJax = findViewById(R.id.ma_bt_jax);
        btJax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(R.raw.jax);
               toast(R.string.ma_jax);
            }
        });
        btJax.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                play(R.raw.bell);
                alert(R.string.ma_alert_mensagem_jax);
                return true;
            }
        });

        //JOHNNYCAGE-------------------------------------
        btJonnyCage = findViewById(R.id.ma_bt_johnnycage);
        btJonnyCage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(R.raw.cage);
                toast(R.string.ma_cage);
            }
        });
        btJonnyCage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                play(R.raw.bell);
                alert(R.string.ma_alert_mensagem_cage);
                return true;
            }
        });

        //KITANA-----------------------------------------
        btKitana = findViewById(R.id.ma_bt_kitana);
        btKitana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play((R.raw.kitana));
               toast(R.string.ma_kitana);
            }
        });
        btKitana.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                play(R.raw.bell);
                alert(R.string.ma_alert_mensagem_kitana);
                return true;
            }
        });

        //KUNGLAO----------------------------------------------
        btKunglao = findViewById(R.id.ma_bt_kunglao);
        btKunglao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(R.raw.kunglao);
               toast(R.string.ma_kunglao);
            }
        });
        btKunglao.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                play(R.raw.bell);
                alert(R.string.ma_alert_mensagem_kunglao);
                return true;
            }
        });

        //LIUKANG----------------------------------------------
        btLiukang= findViewById(R.id.ma_bt_liukang);
        btLiukang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(R.raw.liukang);
               toast(R.string.ma_liukang);
            }
        });
        btLiukang.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                play(R.raw.bell);
                alert(R.string.ma_alert_mensagem_liukang);
                return true;
            }
        });

        //MILEENA---------------------------------------------------
        btMilena = findViewById(R.id.ma_bt_milena);
        btMilena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(R.raw.mileena);
                toast(R.string.ma_mileena);
            }
        });
        btMilena.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                play(R.raw.bell);
                alert(R.string.ma_alert_mensagem_mileena);
                return true;
            }
        });

        //RAIDEN----------------------------------------------------
        btRaiden = findViewById(R.id.ma_bt_raiden);
        btRaiden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(R.raw.raiden);
               toast(R.string.ma_raiden);
            }
        });
        btRaiden.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                play(R.raw.bell);
                alert(R.string.ma_alert_mensagem_raiden);
                return true;
            }
        });

        //REPTILE---------------------------------------------------
        btReptile = findViewById(R.id.ma_bt_reptile);
        btReptile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(R.raw.reptile);
                toast(R.string.ma_reptile);
            }
        });
        btReptile.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                play(R.raw.bell);
                alert(R.string.ma_alert_mensagem_reptile);
                return true;
            }
        });

        //SCORPION------------------------------------------------------
        btScorpion = findViewById(R.id.ma_bt_scorpion);
        btScorpion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(R.raw.scorp);
               toast(R.string.ma_scorp);
            }
        });
        btScorpion.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                play(R.raw.bell);
                alert(R.string.ma_alert_mensagem_scorp);
                return true;
            }
        });

        //SHANGTSUNG----------------------------------------------------
        btShangtsung = findViewById(R.id.ma_bt_shan);
        btShangtsung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(R.raw.shang);
               toast(R.string.ma_shang);
            }
        });
        btShangtsung.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                play(R.raw.bell);
                alert(R.string.ma_alert_mensagem_shang);
                return true;
            }
        });
        

    }//Fecha oncreate

    public void play(int som){
        mp = MediaPlayer.create(MainActivity.this, som);
        mp.start();
    }

    public void stop(){
        if(mp.isPlaying()){
            mp.stop();
        }
    }

    public void toast(int msg){
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public void alert(int mensagem){
        AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
        msg.setTitle(getResources().getText(R.string.ma_alert_titulo));
        msg.setMessage(getResources().getText(mensagem));

        msg.setIcon(ContextCompat.getDrawable(MainActivity.this,R.mipmap.ic_launcher));

        msg.setNeutralButton(getResources().getText(R.string.ma_alert_ok),null);
        msg.show();
    }


}//Fecha Classe

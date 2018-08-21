package janine.gomes.projetofinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import janine.gomes.projetofinal.model.Usuario;

public class MainActivity extends AppCompatActivity {

    //Widgets
    Toolbar toolbar;
    private Drawer result = null;
    private String nomeUser;
    private String emailUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pegando objeto
        if(getIntent().getSerializableExtra("user") != null) {

            Usuario u = (Usuario) getIntent().getSerializableExtra("user");
            emailUser = u.getEmail();
        }
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Inicio AccountHeader
        //####################### SÓ O CABEÇALHO #######################
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.fundo_drawer)
                .addProfiles(
                        new ProfileDrawerItem().withName("Olá, Bem Vindo").withEmail(emailUser).withIcon(getResources().getDrawable(R.mipmap.ic_launcher))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener(){
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

        //Inicio Menu
        result = new DrawerBuilder()
                .withActivity(this)
                .withTranslucentStatusBar(false)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .withSavedInstance(savedInstanceState)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Home")
                                .withIdentifier(0)
                                .withIcon(GoogleMaterial.Icon.gmd_home),

                        new DividerDrawerItem(),

                        new SecondaryDrawerItem()
                                .withName("Buscar por CEP")
                                .withIdentifier(1).withIcon(GoogleMaterial.Icon.gmd_location_on),


                        new SecondaryDrawerItem()
                                .withName("Buscar por Endereço")
                                .withIdentifier(2)
                                .withIcon(GoogleMaterial.Icon.gmd_location_on)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        switch ((int)drawerItem.getIdentifier()){
                            case 0:

                                break;

                            case 1:
                                Intent itcep = new Intent(MainActivity.this,BuscaCEP.class);
                                startActivity(itcep);
                                break;
                            case 2:
                                Intent itbuscaend = new Intent(MainActivity.this,BuscaEnderecoCEP.class);
                                startActivity(itbuscaend);
                                break;
                        }
                        return false;
                    }
                }).build();

    }//fecha oncreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_sobre:
                alert(R.string.ma_alert_mensagem);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void toast(String msg){
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
    }
    public void alert(int mensagem) {
        AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
        msg.setTitle(getResources().getText(R.string.ma_alert_titulo));
        msg.setMessage(getResources().getText(mensagem));

        msg.setIcon(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_action_info_outline));

        msg.setNeutralButton(getResources().getText(R.string.ma_alert_ok), null);
        msg.show();
    }

}//fecha classe

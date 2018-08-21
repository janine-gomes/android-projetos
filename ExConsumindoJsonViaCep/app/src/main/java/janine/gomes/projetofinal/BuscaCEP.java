package janine.gomes.projetofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import janine.gomes.projetofinal.adapter.CEPAdapter;
import janine.gomes.projetofinal.model.CEP;
import janine.gomes.projetofinal.services.APIRetrofitService;
import janine.gomes.projetofinal.services.CEPDeserializer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BuscaCEP extends AppCompatActivity {

    //Widgets
    private EditText etCep;
    private Button btBuscar;
    private ProgressBar progress;
    private RecyclerView rvCep;
    private ArrayList<CEP> ceps;
    private CEPAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_cep);
        //Refes
        etCep = findViewById(R.id.cep_et_cep);
        btBuscar = findViewById(R.id.cep_bt_buscar);
        rvCep = findViewById(R.id.cep_rv_cep);
        progress = findViewById(R.id.cep_progress);

        ceps = new ArrayList<>();
        adapter = new CEPAdapter(BuscaCEP.this,ceps);
        rvCep.setAdapter(adapter);
        rvCep.setHasFixedSize(true);
        rvCep.setLayoutManager(new LinearLayoutManager(this));

        progress.setVisibility(View.GONE);

        //Inicializando o GSON e RETROFIT
        Gson g = new GsonBuilder()
                .registerTypeAdapter(CEP.class, new CEPDeserializer()).create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://viacep.com.br/ws/")
                .addConverterFactory(GsonConverterFactory.create(g))
                .build();
        final APIRetrofitService service = retrofit.create(APIRetrofitService.class);
        btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etCep.getText().toString().isEmpty()){
                    toast("Informe o CEP");
                }else{
                    btBuscar.setVisibility(View.GONE);
                    progress.setVisibility(View.VISIBLE);
                    Call<CEP> call = service.getEnderecoByCEP(etCep.getText().toString());

                    call.enqueue(new Callback<CEP>() {
                        @Override
                        public void onResponse(Call<CEP> call, Response<CEP> response) {
                            if(response.isSuccessful()){
                                CEP cep = response.body();
                                ceps.add(cep);
                                adapter.notifyDataSetChanged();


                                toast("Endereço Encontrado!");
                            }else{
                                toast("ERRO! "+response.message());
                            }//fecha else
                            btBuscar.setVisibility(View.VISIBLE);
                            progress.setVisibility(View.GONE);
                        }

                        @Override
                        public void onFailure(Call<CEP> call, Throwable t) {
                            toast("ERRO ONFAILURE: "+t.getMessage());
                            progress.setVisibility(View.GONE);
                        }
                    });

                }//fecha else
            }//fecha clique
        });//fecha clique

    }//fecha oncreate
    public void toast(String msg){
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
    }
}//fecha classe

package janine.gomes.projetofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import janine.gomes.projetofinal.adapter.CEPAdapter;
import janine.gomes.projetofinal.model.CEP;
import janine.gomes.projetofinal.services.APIRetrofitService;
import janine.gomes.projetofinal.services.CEPDeserializer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BuscaEnderecoCEP extends AppCompatActivity {

    //Widgets
    private Spinner spEstado;
    private EditText etMunicipio;
    private EditText etRua;
    private Button btBuscar;
    private RecyclerView rvCeps;
    private ArrayList<CEP> ceps;
    private CEPAdapter adapter;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_endereco_cep);
        //Refes
       spEstado = findViewById(R.id.be_sp_estado);
        etMunicipio = findViewById(R.id.be_et_municipio);
        etRua = findViewById(R.id.be_et_rua);
        btBuscar = findViewById(R.id.be_bt_buscar);
        rvCeps = findViewById(R.id.be_rv_ceps);
        progress = findViewById(R.id.be_progress);

        ceps = new ArrayList<>();
        adapter = new CEPAdapter(BuscaEnderecoCEP.this,ceps);
        rvCeps.setAdapter(adapter);
        rvCeps.setHasFixedSize(true);
        rvCeps.setLayoutManager(new LinearLayoutManager(this));

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

                if((etMunicipio.getText().toString().isEmpty())&&(etRua.getText().toString().isEmpty())){
                    toast("Informe os dados");
                }else{
                    progress.setVisibility(View.VISIBLE);
                    btBuscar.setVisibility(View.GONE);
                    Call<List<CEP>> call = service.getEnderecoByCEP(spEstado.getSelectedItem().toString(), etMunicipio.getText().toString(),etRua.getText().toString());

                    call.enqueue(new Callback<List<CEP>>() {
                        @Override
                        public void onResponse(Call<List<CEP>> call, Response<List<CEP>> response) {
                            if(response.isSuccessful()){

                                List<CEP> cepsAux = response.body();

                                for (CEP c : cepsAux) {
                                    //Setando no ArrayList
                                    ceps.add(c);

                                }
                                adapter.notifyDataSetChanged();

                                toast("CEP Encontrado");
                            }else{
                                toast("ERRO! "+response.message());
                            }//fecha else
                            progress.setVisibility(View.GONE);
                            btBuscar.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onFailure(Call<List<CEP>> call, Throwable t) {
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

package janine.gomes.projetofinal.services;

import java.util.List;

import janine.gomes.projetofinal.model.CEP;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface APIRetrofitService {


    /* Retorna apenas um objeto CEP */
    @GET("{CEP}/json/")
    Call<CEP> getEnderecoByCEP(@Path("CEP") String CEP);

    @GET("{UF}/{LOCALIDADE}/{LOGRADOURO}/json/")
    Call<List<CEP>> getEnderecoByCEP(@Path("UF")String UF,@Path("LOCALIDADE") String LOCALIDADE, @Path("LOGRADOURO") String LOGRADOURO);




}//fecha classe
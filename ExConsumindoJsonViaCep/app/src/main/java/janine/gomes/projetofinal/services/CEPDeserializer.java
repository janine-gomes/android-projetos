package janine.gomes.projetofinal.services;

import com.google.gson.JsonElement;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;

import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import janine.gomes.projetofinal.model.CEP;

public class CEPDeserializer implements JsonDeserializer {

    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        if(json.getAsJsonObject() != null) {

            JsonElement element = json.getAsJsonObject();
            return (new Gson().fromJson(element, CEP.class));

        }else{

            return null;

        }
    }
}//fecha classe
package janine.gomes.projetofinal.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import janine.gomes.projetofinal.R;
import janine.gomes.projetofinal.model.CEP;

public class CEPAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<CEP> ceps;

    public CEPAdapter(Context context, ArrayList<CEP> ceps) {

        this.context = context;
        this.ceps = ceps;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.linha_cep,
                parent,
                false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        //getView()
        ViewHolder h = (ViewHolder) holder;

        //Buscando obj cep do arraylist
        CEP c = ceps.get(position);

        h.tvCep.setText(c.getCep());
        h.tvRua.setText(c.getLogradouro());
        h.tvBairro.setText(c.getBairro());
        h.tvMunicipio.setText(c.getLocalidade());
        h.tvEstado.setText(c.getUf());


    }

    @Override
    public int getItemCount() {
        return ceps.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView tvCep;
        private final TextView tvRua;
        private final TextView tvBairro;
        private final TextView tvMunicipio;
        private final TextView tvEstado;

        public ViewHolder(View itemView) {
            super(itemView);

            tvCep =  itemView.findViewById(R.id.lc_cep);
            tvRua =  itemView.findViewById(R.id.lc_tv_rua);
            tvBairro =  itemView.findViewById(R.id.lc_tv_bairro);
            tvMunicipio =  itemView.findViewById(R.id.lc_tv_municipio);
            tvEstado =  itemView.findViewById(R.id.lc_tv_estado);
        }
    }


}

package com.example.listaciclos;

import java.util.ArrayList;

import com.example.tarealog.R;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CicloAdapter extends ArrayAdapter<Ciclo> {
	
	private Context context;
	private ArrayList<Ciclo> listaEscuelas;

	public CicloAdapter(Context context, int viewResourceId,
			ArrayList<Ciclo> escuelas) {
		super(context, viewResourceId, escuelas);
		this.context = context;
		this.listaEscuelas = escuelas;
	}
	static class ViewHolder {
		public TextView namesc;
		public TextView cantesc;
		public TextView alumnosmatriculadosvirtualesc;
		public TextView alumnosmatriculadospresencialesc;
//		public TextView alumnosnomatriculadosesc;
		}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.row_ciclos, parent, false);

			ViewHolder viewHolder = new ViewHolder();
			viewHolder.namesc = (TextView) convertView
					.findViewById(R.id.nombre);
			viewHolder.cantesc = (TextView) convertView
					.findViewById(R.id.cantidad);
			viewHolder.alumnosmatriculadospresencialesc = (TextView) convertView
					.findViewById(R.id.alpre);
			viewHolder.alumnosmatriculadosvirtualesc = (TextView) convertView
					.findViewById(R.id.alvir);
//			viewHolder.alumnosnomatriculadosesc = (TextView) convertView
//					.findViewById(R.id.alnomat);
			convertView.setTag(viewHolder);
		}

		ViewHolder holder = (ViewHolder) convertView.getTag();
		holder.namesc.setText("Ciclo: "
				+ listaEscuelas.get(position).getNamesc());
		holder.cantesc.setText("Cantidad: "
				+ listaEscuelas.get(position).getCantesc());
		holder.alumnosmatriculadospresencialesc.setText("matriculas presenciales: "
				+ listaEscuelas.get(position).getAlumnosmatriculadospresencialesc());
		holder.alumnosmatriculadosvirtualesc.setText("matriculas virutuales: "
				+ listaEscuelas.get(position).getAlumnosmatriculadosvirtualesc());
//		holder.alumnosnomatriculadosesc.setText("No Matriculados: "
//				+ listaEscuelas.get(position).getAlumnosnomatriculadosesc());
		return convertView;
	}
}
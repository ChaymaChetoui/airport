package presentation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entities.Admin;
import entities.Passenger;




public class TableModeleAdmin extends AbstractTableModel {
  private List<Admin> liste=new ArrayList<>();
  private String[]titres= {"id","Email","First Name","LastName"};
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return titres.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return liste.size();
	}

	@Override
	public Object getValueAt(int l, int c) {
		// TODO Auto-generated method stub
		switch (c) {
		case 0:return liste.get(l).getId();
		case 1:return liste.get(l).getEmail();
		case 2:return liste.get(l).getFirstName();
		case 3:return liste.get(l).getLastName();
	
			
		}
		return null;
	}
	
	@Override
		public String getColumnName(int arg0) {
			// TODO Auto-generated method stub
			return titres[arg0];
		}
	
	public void charger(List<Admin> list)
	{
		this.liste=list;
		fireTableDataChanged();
	}
	
}




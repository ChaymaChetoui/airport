package presentation;

	import java.util.ArrayList;
	import java.util.List;

	import javax.swing.table.AbstractTableModel;

	import entities.Admin;
import entities.Passenger;




	public class TableModelePassenger extends AbstractTableModel {
	  private List<Passenger>liste=new ArrayList<>();
	  private String[]titres= {"id","Email","First Name","LastName","Nationality","Passeport Number","gender"};
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
			case 4:return liste.get(l).getNationality();
			case 5:return liste.get(l).getPasseportNumber();
			case 6:return liste.get(l).getGender();
		
				
			}
			return null;
		}
		
		@Override
			public String getColumnName(int arg0) {
				// TODO Auto-generated method stub
				return titres[arg0];
			}
		
		public void charger(List<Passenger> liste)
		{
			this.liste=liste;
			fireTableDataChanged();
		}
		
	}


package tuan.child;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import tuan.Adapter.Chaohoi_adapter;
import tuan.Adapter.So_adapter;
import tuan.Database.SqlLiteDbHelper;
import tuan.Obj.ItemsList;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.tiengnhat.R;

public class So_child extends Activity {
	ListView lv;
	So_adapter adapter;
	SqlLiteDbHelper dbHeplper;
	List<ItemsList> arrList = new ArrayList<ItemsList>();

	// @SuppressLint("NewApi") @Override
	@SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {

		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_child);
		 getActionBar().setHomeButtonEnabled(true);
		 getActionBar().setDisplayHomeAsUpEnabled(true);
		lv = (ListView) findViewById(R.id.listView1);
		dbHeplper = new SqlLiteDbHelper(getApplicationContext());
		dbHeplper.openDataBase();
		arrList = dbHeplper.getAll(3);
		adapter = new So_adapter(getApplicationContext(), arrList);
		lv.setAdapter(adapter);
		dbHeplper.close();
	}
	 public boolean onMenuItemSelected(int featureId, MenuItem item) {
	 onBackPressed();
	 return super.onOptionsItemSelected(item);
	
	 }
}

package tuan.child;

import java.util.*;

import tuan.Adapter.Chaohoi_adapter;
import tuan.Database.SqlLiteDbHelper;
import tuan.Obj.ItemsList;
import com.example.tiengnhat.R;

import android.view.MenuItem;
import android.widget.*;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

public class ChaoHoi_child extends Activity {
	ListView lv;
	Chaohoi_adapter adapter;
    SqlLiteDbHelper dbHeplper;
	List<ItemsList> arrList = new ArrayList<ItemsList>();

	@SuppressLint("NewApi") protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_child);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		lv = (ListView) findViewById(R.id.listView1);
		dbHeplper = new SqlLiteDbHelper(getApplicationContext());
		dbHeplper.openDataBase();
		arrList = dbHeplper.getAll(1);
		adapter = new Chaohoi_adapter(getApplicationContext(), arrList);
		lv.setAdapter(adapter);
		dbHeplper.close();
	}
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		onBackPressed();
		return super.onOptionsItemSelected(item);

	}
}

package tuan.child;

import java.util.ArrayList;
import java.util.List;

import tuan.Adapter.Chaohoi_adapter;
import tuan.Adapter.Dauom_adapter;
import tuan.Database.SqlLiteDbHelper;
import tuan.Obj.ItemsList;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.tiengnhat.R;

public class DauOm_child extends Activity {
	ListView lv;
	Dauom_adapter adapter;
    SqlLiteDbHelper dbHeplper;
	List<ItemsList> arrList = new ArrayList<ItemsList>();

	@SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {

		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_child);
		lv = (ListView) findViewById(R.id.listView1);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		dbHeplper = new SqlLiteDbHelper(getApplicationContext());
		dbHeplper.openDataBase();
		arrList = dbHeplper.getAll(17);
		adapter = new Dauom_adapter(getApplicationContext(), arrList);
		lv.setAdapter(adapter);
		dbHeplper.close();
	}
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		onBackPressed();
		return super.onOptionsItemSelected(item);

	}
}


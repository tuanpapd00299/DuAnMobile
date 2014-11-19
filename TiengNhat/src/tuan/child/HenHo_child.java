package tuan.child;

import java.util.ArrayList;
import java.util.List;

import tuan.Adapter.Chaohoi_adapter;
import tuan.Adapter.Henho_adapter;
import tuan.Database.SqlLiteDbHelper;
import tuan.Obj.ItemsList;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.tiengnhat.R;

public class HenHo_child extends Activity {
	ListView lv;
	Henho_adapter adapter;
    SqlLiteDbHelper dbHeplper;
	List<ItemsList> arrList = new ArrayList<ItemsList>();

	@SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {

		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_child);
		setContentView(R.layout.activity_child);
		lv = (ListView) findViewById(R.id.listView1);
		dbHeplper = new SqlLiteDbHelper(getApplicationContext());
		dbHeplper.openDataBase();
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		// lấy dữ liệu đổ vào listView
		arrList = dbHeplper.getAll(15);
		adapter = new Henho_adapter(getApplicationContext(), arrList);
		lv.setAdapter(adapter);
		dbHeplper.close();
	}
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		onBackPressed();
		return super.onOptionsItemSelected(item);

	}
}


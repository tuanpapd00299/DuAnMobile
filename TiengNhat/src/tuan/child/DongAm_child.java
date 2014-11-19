package tuan.child;

import java.util.ArrayList;
import java.util.List;

import tuan.Adapter.Chaohoi_adapter;
import tuan.Adapter.Dongam_adapter;
import tuan.Database.SqlLiteDbHelper;
import tuan.Obj.ItemsList;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;

import com.example.tiengnhat.R;

public class DongAm_child extends Activity {
	ListView lv;
	Dongam_adapter adapter;
    SqlLiteDbHelper dbHeplper;
	List<ItemsList> arrList = new ArrayList<ItemsList>();

	@SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {

		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_child);
		lv = (ListView) findViewById(R.id.listView1);
		dbHeplper = new SqlLiteDbHelper(getApplicationContext());
		dbHeplper.openDataBase();
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		// lấy dữ liệu đổ vào listView
		arrList = dbHeplper.getAll(18);
		adapter = new Dongam_adapter(getApplicationContext(), arrList);
		lv.setAdapter(adapter);
		dbHeplper.close();
	}
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		onBackPressed();
		return super.onOptionsItemSelected(item);

	}
}


package tuan.child;

import java.util.ArrayList;
import java.util.List;

import tuan.Adapter.Timkiem_adapter;
import tuan.Database.SqlLiteDbHelper;
import tuan.Obj.ItemsList;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

import com.example.tiengnhat.R;

public class TimKiem_child extends Activity {
	ListView lv;
	int textlength = 0;
	EditText edtsearch;
	Timkiem_adapter adapter;
	ArrayList<ItemsList> arrayCaiDats = new ArrayList<ItemsList>();
	private ArrayList<ItemsList> arr_sort = new ArrayList<ItemsList>();
	Context mContext;
	SqlLiteDbHelper db;
	MediaPlayer mp;
	List<ItemsList> arrList = new ArrayList<ItemsList>();

	@SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {

		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timkiem);
		edtsearch = (EditText) findViewById(R.id.edtsearch);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		// lấy dữ liệu đổ vào listView
		mContext = this;
		lv = (ListView) findViewById(R.id.listView1);
		db = new SqlLiteDbHelper(mContext);
		db.openDataBase();
		arrList = db.getTimkiem();
		db.close();
		search();
		db.close();
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		onBackPressed();
		return super.onOptionsItemSelected(item);

	}

	public void search() {
		edtsearch.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			    textlength = edtsearch.getText().length();
			    arr_sort.clear();
			    for (int i = 0; i < arrList.size(); i++) {
			     String _text = (String) arrList.get(i)
			       .getVietnamese();
			     if (textlength <= _text.length()) {
			      if (edtsearch
			        .getText()
			        .toString()
			        .equalsIgnoreCase(
			          (String) _text.subSequence(0,
			            textlength))) {
			       Log.e("===========>", ""+_text);
			       arr_sort.add(arrList.get(i));
			      }
			     }
			    }
			    adapter = new Timkiem_adapter(mContext, arr_sort);
			    lv.setAdapter(adapter);
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});

	}

}

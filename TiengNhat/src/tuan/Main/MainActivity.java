package tuan.Main;

import java.io.IOException;

import tuan.Database.SqlLiteDbHelper;
import tuan.child.AnUong_child;
import tuan.child.ChaoHoi_child;
import tuan.child.DanhLam_child;
import tuan.child.DauOm_child;
import tuan.child.DiaDiem_child;
import tuan.child.DongAm_child;
import tuan.child.GiaDinh_child;
import tuan.child.HenHo_child;
import tuan.child.HoiThoai_child;
import tuan.child.KhanCap_child;
import tuan.child.MauSac_child;
import tuan.child.MuaSam_child;
import tuan.child.NgayGio_child;
import tuan.child.PhuongHuong_child;
import tuan.child.PhuongTien_child;
import tuan.child.QuocGia_child;
import tuan.child.So_child;
import tuan.child.ThanhPho_child;
import tuan.child.TimKiem_child;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.example.tiengnhat.R;

public class MainActivity extends Activity {
	android.widget.LinearLayout chao, so, anuong, hoithoai, thoigian, muasam, direc, acco,
	trans, color, citi, coun, touris, family, dating, eme, feel,
	tongue, timkiem;
	  SqlLiteDbHelper dbHeplper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    	dbHeplper = new SqlLiteDbHelper(getApplicationContext());
		try {
			dbHeplper.createDataBase();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbHeplper.openDataBase();
		dbHeplper.close();
        chao = (android.widget.LinearLayout) findViewById(R.id.layoutGreeting);
        so = (LinearLayout) findViewById(R.id.layoutNumber);
		anuong = (LinearLayout) findViewById(R.id.layoutEatingOut);
		hoithoai = (LinearLayout) findViewById(R.id.layoutGeneralConversation);
		thoigian = (LinearLayout) findViewById(R.id.layoutTimeandDate);
		muasam = (LinearLayout) findViewById(R.id.layoutShopping);
		direc = (LinearLayout) findViewById(R.id.layoutDirectationsPlaces);
		acco = (LinearLayout) findViewById(R.id.layoutAccommodation);
		trans = (LinearLayout) findViewById(R.id.layoutTransportation);
		color = (LinearLayout) findViewById(R.id.layoutColours);
		citi = (LinearLayout) findViewById(R.id.layoutCitiesandPrefecture);
		coun = (LinearLayout) findViewById(R.id.layoutCountries);
		touris = (LinearLayout) findViewById(R.id.layoutTouristAttractions);
		family = (LinearLayout) findViewById(R.id.layoutFamily);
		dating = (LinearLayout) findViewById(R.id.layoutDating);
		eme = (LinearLayout) findViewById(R.id.layoutEmergency);
		feel = (LinearLayout) findViewById(R.id.layoutFeelingSick);
		tongue = (LinearLayout) findViewById(R.id.layoutTongueTwisters);
		timkiem = (LinearLayout) findViewById(R.id.layoutSearch);
        chao.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent(MainActivity.this , ChaoHoi_child.class);
				startActivity(it);
			}
		});
        so.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						So_child.class);
				startActivity(intent);
			}
		});
		anuong.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						AnUong_child.class);

				startActivity(intent);
			}
		});
		hoithoai.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						HoiThoai_child.class);
				startActivity(intent);
			}
		});
		thoigian.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						NgayGio_child.class);
				startActivity(intent);
			}
		});
		muasam.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						MuaSam_child.class);
				startActivity(intent);
			}
		});

		muasam.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						MuaSam_child.class);
				startActivity(intent);
			}
		});

		direc.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						PhuongHuong_child.class);
				startActivity(intent);
			}
		});
		eme.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						KhanCap_child.class);
				startActivity(intent);
			}
		});
		color.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						MauSac_child.class);
				startActivity(intent);
			}
		});
		citi.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						ThanhPho_child.class);
				startActivity(intent);
			}
		});
		coun.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						QuocGia_child.class);
				startActivity(intent);
			}
		});
		dating.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						HenHo_child.class);
				startActivity(intent);
			}
		});
		feel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						DauOm_child.class);
				startActivity(intent);
			}
		});

		tongue.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						DongAm_child.class);
				startActivity(intent);
			}
		});

		touris.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						DanhLam_child.class);
				startActivity(intent);
			}
		});

		trans.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						PhuongTien_child.class);
				startActivity(intent);
			}
		});
		acco.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						DiaDiem_child.class);
				startActivity(intent);
			}
		});
		family.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						GiaDinh_child.class);
				startActivity(intent);
			}
		});
		timkiem.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),
						TimKiem_child.class);
				startActivity(intent);
			}
		});

	}
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return super.onCreateOptionsMenu(menu);

	}
	private void dialog() {
		AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
		dialog.setTitle("Thoát");
		dialog.setMessage("Bạn có muốn thoát ứng dụng ?");
		dialog.setIcon(R.drawable.ic_exit1);
		dialog.setPositiveButton("Không",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
		dialog.setNegativeButton("Có", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

				finish();
				System.exit(0);
			}
		});
		dialog.show();

	}
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		switch (item.getItemId()) {
		case R.id.menu_exit:
			dialog();
			break;
		default:
		}
		return super.onOptionsItemSelected(item);

    }
    }

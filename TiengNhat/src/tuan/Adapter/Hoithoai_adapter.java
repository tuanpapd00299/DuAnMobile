package tuan.Adapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import tuan.Database.SqlLiteDbHelper;
import tuan.Obj.ItemsList;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.tiengnhat.R;

public class Hoithoai_adapter extends BaseAdapter {
	private Context mContext;
	private LayoutInflater mInflater;
	MediaPlayer mediaPlayer;
	SqlLiteDbHelper db;
	MediaPlayer mp;
	private List<ItemsList> list = new ArrayList<ItemsList>();

	public Hoithoai_adapter(Context mContext, List<ItemsList> listDanhSach) {
		this.mContext = mContext;
		mInflater = LayoutInflater.from(this.mContext);
		list = listDanhSach;
	}

	public Hoithoai_adapter() {

	}

	public class ViewHolder {
		TextView txtPhrase, txtJpan, txtPinyin;
		ImageButton btnFavo, Play;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.custom_list, null);
			holder.txtPhrase = (TextView) convertView
					.findViewById(R.id.txtPhrase);
			holder.txtJpan = (TextView) convertView.findViewById(R.id.txtJapan);
			holder.txtPinyin = (TextView) convertView
					.findViewById(R.id.txtPinyin);
			holder.Play = (ImageButton) convertView.findViewById(R.id.btnPlay);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.txtPhrase.setText(list.get(position).getVietnamese());
		holder.txtJpan.setText(list.get(position).getJapanese());
		holder.txtPinyin.setText(list.get(position).getPinyin());

		holder.txtPhrase.setTag(position);
		holder.txtJpan.setTag(position);
		holder.txtPinyin.setTag(position);
		holder.Play.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				db = new SqlLiteDbHelper(mContext);
				Uri audio = Uri.parse(""+db.getVoice(2).get(position));
				try {
					playSound(audio);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			}
			
		});
		return convertView;
	}
	public void playSound(Uri audio) throws IOException {
		AssetFileDescriptor afd = mContext.getAssets().openFd(audio + ".ogg");
		  mp = new MediaPlayer();
		  mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(),
		    afd.getLength());
		  mp.prepare();
		  mp.start();
		 }
}

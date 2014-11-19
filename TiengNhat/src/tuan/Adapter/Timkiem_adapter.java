package tuan.Adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import tuan.Database.SqlLiteDbHelper;
import tuan.Obj.ItemsList;
import android.content.Context;
import android.media.MediaPlayer;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.tiengnhat.R;

public class Timkiem_adapter extends BaseAdapter implements
		TextToSpeech.OnInitListener {
	private Context mContext;
	private TextToSpeech tts;
	private LayoutInflater mInflater;
	MediaPlayer mediaPlayer;
	SqlLiteDbHelper db;
	MediaPlayer mp;
	
	private List<ItemsList> list = new ArrayList<ItemsList>();
	public Timkiem_adapter(Context mContext, List<ItemsList> listDanhSach) {
		this.mContext = mContext;
		mInflater = LayoutInflater.from(this.mContext);
		list = listDanhSach;
	}

	public Timkiem_adapter() {

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
	public void onInit(int status) {
		// TODO Auto-generated method stub
	
		if (status == TextToSpeech.SUCCESS) {

			int result = tts.setLanguage(Locale.JAPANESE);}

}
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		
		final ViewHolder holder;
		tts = new TextToSpeech(mContext, this);
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
			
				String text = holder.txtJpan.getText().toString();
				Log.d ("---->",""+text);
				tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
				

			}
		});
		return convertView;
		
	}

	
}

// db = new SqlLiteDbHelper(mContext);
// Uri audio = Uri.parse(""+db.getVoiceAll().get(position));
// try {
// playSound(audio);
// } catch (IOException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }
//
// }

// public void playSound(Uri audio) throws IOException {
// AssetFileDescriptor afd = mContext.getAssets().openFd(audio + ".ogg");
// mp = new MediaPlayer();
// mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(),
// afd.getLength());
// mp.prepare();
// mp.start();
// }

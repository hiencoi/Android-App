package com.learnenglishforkids.kidbox.learnenglishforkids;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.learnenglishforkids.kidbox.learnenglishforkids.control.CustomGridAdapter;
import com.learnenglishforkids.kidbox.learnenglishforkids.control.VocabularyControl;
import com.learnenglishforkids.kidbox.learnenglishforkids.model.CommonAct;
import com.learnenglishforkids.kidbox.learnenglishforkids.model.Item;

import java.util.ArrayList;

public class vocabularyActivity extends Activity implements CommonAct {
    private GridView gridView;
    private ArrayList<Item> data = new ArrayList<Item>();
    private CustomGridAdapter customGridAdapter;

    private int[] soundPoolLoadedArr;

    private SoundPool soundPool;
    private AudioManager audioManager;
    private static final int MAX_STREAMS = 5;
    private float volume;
    private static final int streamType = AudioManager.STREAM_MUSIC;
    private boolean loaded;
    private String[] vocabularyTextArr;
    private String imgFilePrefix;
    private String sndFilePrefix;
    private VocabularyControl vocabularyControl;
    private Bitmap image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);
        data.clear();
        Intent intent = this.getIntent();
        //khoi tao cac thanh phan Sound Pool can thiet
        intSoundPool();
        //Lay du lieu tu lop Vocabulary Control
        vocabularyControl = new VocabularyControl(intent);
        vocabularyControl.intListData();
        vocabularyTextArr = VocabularyControl.vocabularyTextArr;
        imgFilePrefix = VocabularyControl.imgFilePrefix;
        sndFilePrefix = VocabularyControl.sndFilePrefix;
        intListData();
        gridView = (GridView) findViewById(R.id.vocabulary);
        customGridAdapter = new CustomGridAdapter(vocabularyActivity.this, R.layout.item, data);
        gridView.setAdapter(customGridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (loaded) {
                    soundPool.play(soundPoolLoadedArr[position], volume, volume, 1, 0, 1.0f);
                } else {
                    Log.d("SOUND_PLAY", "SOUND IS NOT LOAD");
                }
            }
        });
    }

    protected void intSoundPool() {
        // Đối tượng AudioManager sử dụng để điều chỉnh âm lượng.
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        // Chỉ số âm lượng hiện tại của loại luồng nhạc cụ thể (streamType).
        float currentVolumeIndex = (float) audioManager.getStreamVolume(streamType);


        // Chỉ số âm lượng tối đa của loại luồng nhạc cụ thể (streamType).
        float maxVolumeIndex  = (float) audioManager.getStreamMaxVolume(streamType);

        // Âm lượng  (0 --> 1)
        volume = currentVolumeIndex / maxVolumeIndex;

        // Cho phép thay đổi âm lượng các luồng kiểu 'streamType' bằng các nút
        // điều khiển của phần cứng.
        setVolumeControlStream(streamType);

        // Với phiên bản Android SDK >= 21
        if (Build.VERSION.SDK_INT >= 21 ) {

            AudioAttributes audioAttrib = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            SoundPool.Builder builder= new SoundPool.Builder();
            builder.setAudioAttributes(audioAttrib).setMaxStreams(MAX_STREAMS);

            soundPool = builder.build();
        }
        // Với phiên bản Android SDK < 21
        else {
            // SoundPool(int maxStreams, int streamType, int srcQuality)
            soundPool = new SoundPool(MAX_STREAMS, streamType, 100);
        }

        // Sự kiện SoundPool đã tải lên bộ nhớ thành công.
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                loaded = true;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (soundPool != null) {
            soundPool.release();
        }
        soundPoolLoadedArr = null;
        vocabularyTextArr = null;
        soundPoolLoadedArr = null;
        if (image != null) {
            image.recycle();
            image = null;
        }
        data.clear();

    }

    public void intListData() {
        //Xu ly du lieu va gan vao cac Array can thiet
        soundPoolLoadedArr = new int[vocabularyTextArr.length];
        for(int i=0;i<vocabularyTextArr.length;i++) {
            int imageID = this.getResources().getIdentifier(imgFilePrefix+(i+1), "drawable", this.getPackageName());
            int soundItemID = this.getResources().getIdentifier(sndFilePrefix+(i+1), "raw", this.getPackageName());
            int soundLoadedItem = soundPool.load(this, soundItemID, 1);
            soundPoolLoadedArr[i] = soundLoadedItem;
            image = BitmapFactory.decodeResource(this.getResources(), imageID);
            data.add(new Item(image, vocabularyTextArr[i]));
        }
    }
}

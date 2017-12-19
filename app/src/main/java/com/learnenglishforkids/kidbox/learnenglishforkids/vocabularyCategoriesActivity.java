package com.learnenglishforkids.kidbox.learnenglishforkids;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.learnenglishforkids.kidbox.learnenglishforkids.control.CustomGridAdapter;
import com.learnenglishforkids.kidbox.learnenglishforkids.model.CommonAct;
import com.learnenglishforkids.kidbox.learnenglishforkids.model.Item;

import java.util.ArrayList;

public class vocabularyCategoriesActivity extends Activity implements CommonAct {
    private GridView gridView;
    private ArrayList<Item> vocabularyCatArr = new ArrayList<Item>();
    private CustomGridAdapter customGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary_categories);

        //khoi tao du lieu
        intListData();
        //dua du lieu len Grid View
        gridView = (GridView) findViewById(R.id.vocabularyMenu);
        customGridAdapter = new CustomGridAdapter(this, R.layout.item, vocabularyCatArr);
        gridView.setAdapter(customGridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(getApplicationContext(), vocabularyActivity.class);
            intent.putExtra("vCategory", position);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

            }
        });
    }

    public void intListData() {
        Bitmap letter = BitmapFactory.decodeResource(this.getResources(), R.drawable.icon_letter);
        Bitmap number = BitmapFactory.decodeResource(this.getResources(), R.drawable.icon_number);
        Bitmap color = BitmapFactory.decodeResource(this.getResources(), R.drawable.icon_color);
        Bitmap shape = BitmapFactory.decodeResource(this.getResources(), R.drawable.icon_shape);
        Bitmap month = BitmapFactory.decodeResource(this.getResources(), R.drawable.icon_month);
        Bitmap day = BitmapFactory.decodeResource(this.getResources(), R.drawable.icon_day);
        Bitmap Fruit = BitmapFactory.decodeResource(this.getResources(), R.drawable.icon_fruit);
        Bitmap animal = BitmapFactory.decodeResource(this.getResources(), R.drawable.icon_animal);
        Bitmap bodyPart = BitmapFactory.decodeResource(this.getResources(), R.drawable.icon_body_part);
        Bitmap weather = BitmapFactory.decodeResource(this.getResources(), R.drawable.icon_weather);
        Bitmap transport = BitmapFactory.decodeResource(this.getResources(), R.drawable.icon_transport);
        Bitmap clothe = BitmapFactory.decodeResource(this.getResources(), R.drawable.icon_clothe);
        Bitmap verb = BitmapFactory.decodeResource(this.getResources(), R.drawable.icon_verb);
        Bitmap classRoom = BitmapFactory.decodeResource(this.getResources(), R.drawable.icon_classroom);
        Bitmap nature = BitmapFactory.decodeResource(this.getResources(), R.drawable.icon_nature);
        Bitmap job = BitmapFactory.decodeResource(this.getResources(), R.drawable.icon_job);
        Bitmap object = BitmapFactory.decodeResource(this.getResources(), R.drawable.icon_object);
        Bitmap adjective = BitmapFactory.decodeResource(this.getResources(), R.drawable.icon_adjective);
        Bitmap country = BitmapFactory.decodeResource(this.getResources(), R.drawable.icon_country);
        Bitmap food = BitmapFactory.decodeResource(this.getResources(), R.drawable.icon_food);
        Bitmap flower = BitmapFactory.decodeResource(this.getResources(), R.drawable.icon_flower);
        Bitmap christmas = BitmapFactory.decodeResource(this.getResources(), R.drawable.icon_christmas);

        vocabularyCatArr.add(new Item(letter, "Alphabet"));
        vocabularyCatArr.add(new Item(number, "Number"));
        vocabularyCatArr.add(new Item(color, "Color"));
        vocabularyCatArr.add(new Item(shape, "Shape"));
        vocabularyCatArr.add(new Item(month, "Month"));
        vocabularyCatArr.add(new Item(day, "Day"));
        vocabularyCatArr.add(new Item(Fruit, "Fruit"));
        vocabularyCatArr.add(new Item(animal, "Animal"));
        vocabularyCatArr.add(new Item(bodyPart, "Body Part"));
        vocabularyCatArr.add(new Item(weather, "Weather"));
        vocabularyCatArr.add(new Item(transport, "Transport"));
        vocabularyCatArr.add(new Item(clothe, "Clothe"));
        vocabularyCatArr.add(new Item(verb, "Verb"));
        vocabularyCatArr.add(new Item(classRoom, "Class Room"));
        vocabularyCatArr.add(new Item(nature, "Nature"));
        vocabularyCatArr.add(new Item(job, "Job"));
        vocabularyCatArr.add(new Item(object, "Object"));
        vocabularyCatArr.add(new Item(adjective, "Adjective"));
        vocabularyCatArr.add(new Item(country, "Country"));
        vocabularyCatArr.add(new Item(food, "Food"));
        vocabularyCatArr.add(new Item(flower, "Flower"));
        vocabularyCatArr.add(new Item(christmas, "Christmas"));
    }
}

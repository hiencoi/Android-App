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

public class MainActivity extends Activity implements CommonAct {
    private GridView gridView;
    private ArrayList<Item> mainMenuArr = new ArrayList<Item>();
    private CustomGridAdapter customGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //khoi tao du lieu cho menu
        intListData();

        //dua du lieu len Grid View
        gridView = (GridView) findViewById(R.id.mainMenu);
        customGridAdapter = new CustomGridAdapter(this, R.layout.item, mainMenuArr);

        // bat su kien cho tung menu
        gridView.setAdapter(customGridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(getApplicationContext(), vocabularyCategoriesActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    //khoi tao menu
    public void intListData() {
        Bitmap menuVocabulary = BitmapFactory.decodeResource(this.getResources(), R.drawable.menu_vocabulary);
        Bitmap menuQuiz = BitmapFactory.decodeResource(this.getResources(), R.drawable.menu_quiz);
        Bitmap menuGuessGame = BitmapFactory.decodeResource(this.getResources(), R.drawable.menu_guess_picture);
        Bitmap menuDraw = BitmapFactory.decodeResource(this.getResources(), R.drawable.menu_draw_alphabet);
        Bitmap menuMiniGame = BitmapFactory.decodeResource(this.getResources(), R.drawable.menu_mini_game);
        Bitmap menuDotGame = BitmapFactory.decodeResource(this.getResources(), R.drawable.menu_learn_via_dot);
        Bitmap menuHardQuiz = BitmapFactory.decodeResource(this.getResources(), R.drawable.menu_hard_quiz);
        mainMenuArr.add(new Item(menuVocabulary, "Vocabulary"));
        mainMenuArr.add(new Item(menuQuiz, "Quiz"));
        mainMenuArr.add(new Item(menuDraw, "Draw AlphaBet"));
        mainMenuArr.add(new Item(menuGuessGame, "Guess Picture"));
        mainMenuArr.add(new Item(menuMiniGame, "Mini Game"));
        mainMenuArr.add(new Item(menuDotGame, "Dot Game"));
        mainMenuArr.add(new Item(menuHardQuiz, "Hard Quiz"));
    }

}

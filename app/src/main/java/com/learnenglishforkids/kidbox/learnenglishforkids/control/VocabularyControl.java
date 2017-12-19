package com.learnenglishforkids.kidbox.learnenglishforkids.control;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.SoundPool;

import com.learnenglishforkids.kidbox.learnenglishforkids.model.CommonAct;
import com.learnenglishforkids.kidbox.learnenglishforkids.model.Item;
import com.learnenglishforkids.kidbox.learnenglishforkids.vocabularyActivity;

import java.util.ArrayList;

import static android.R.attr.data;

/**
 * Created by trand on 10/15/2017.
 */

public class VocabularyControl implements CommonAct {
    public static String[] vocabularyTextArr;
    public static String imgFilePrefix;
    public static String sndFilePrefix;
    Intent intent;
    public VocabularyControl(Intent intent) {
        this.intent = intent;

    }

    public void intListData() {
        int categoty = intent.getIntExtra("vCategory", 0);
        switch (categoty) {
            case 0:// Alphabet
                imgFilePrefix = "pack1d";
                sndFilePrefix = "pack1s";
                vocabularyTextArr = new String[]{
                        "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
                        "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
                };
                break;
            case 1:// Number
                imgFilePrefix = "pack2d";
                sndFilePrefix = "pack2s";
                vocabularyTextArr = new String[]{
                        "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"
                };
                break;
            case 7:
                imgFilePrefix = "pack8d";
                sndFilePrefix = "pack8s";
                vocabularyTextArr = new String[]{
                        "Bear","Cow","Dog","Frog","Horse","Jaguar","Lion","Mouse","Pig","Rabbit","Tiger","Zebra","Cat","Monkey","Duck","Elephant","Lamb",
                        "Sheep","Wolf","Bull","Chicken","Cobra","Crocodile","Crow","Deer","Dolphin","Donkey","Giraffe",
                        "Goat","Hamster","Hippo","Hyena","Rat","Seal","Pigeon","Panda","Parrot","Whale","camel","kangaroo","spider","turkey"
                };

        }

    }
}

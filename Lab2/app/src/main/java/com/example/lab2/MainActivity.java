package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.transition.Visibility;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ViewGroup m_my_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout layout = findViewById(R.id.vertical_layout);
        layout.setOnClickListener(v -> {
            TextView textView = MainActivity.this.findViewById(R.id.textView);
            CheckBox checkBox = MainActivity.this.findViewById(R.id.checkBox);
            RadioButton button = MainActivity.this.findViewById(R.id.my_specific_identifier);
            if (textView.getVisibility() == View.GONE) {
                textView.setVisibility(View.VISIBLE);
                checkBox.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);
            } else {
                textView.setVisibility(View.GONE);
                checkBox.setVisibility(View.GONE);
                button.setVisibility(View.GONE);
            }
            textView.animate().rotationY(100).translationY(100).setDuration(500).start();
        });
        m_my_list = findViewById(R.id.list);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        for (int i = 0; i < 10; i++) {
            assert inflater != null;
            View view = inflater.inflate(R.layout.list_item, null);
            ((TextView) view.findViewById(R.id.itemtext)).setText("Зліва обрати елемент, справа заблокувати вибір");
            view.findViewById(R.id.morebutton).setOnClickListener(this);
            m_my_list.addView(view);
        }

    }

    @Override
    public void onClick(View v) {
        v.animate().rotationY(100).alpha((float) 0.2).setDuration(300).scaleXBy(100).start();
    }
}

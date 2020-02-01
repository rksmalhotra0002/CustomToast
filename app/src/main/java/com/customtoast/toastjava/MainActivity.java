package com.customtoast.toastjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.customtoast.R;
import com.customtoast.toastkotlin.CustomToast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_toast, R.id.btn_customtoast})

    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.btn_toast:

                Toast toasts = Toast.makeText(MainActivity.this,R.string.simple_toast, Toast.LENGTH_LONG);
                toasts.setGravity(Gravity.CENTER, 890, 89);
                toasts.setText(R.string.app_name);   //simple toast
                toasts.show();
                Intent intent=new Intent(MainActivity.this, CustomToast.class);
                startActivity(intent);

                break;

            case R.id.btn_customtoast:

                LayoutInflater inflater = getLayoutInflater();
                View views = inflater.inflate(R.layout.toast_layout,findViewById(R.id.toast_root));
                ImageView iv_image = views.findViewById(R.id.iv_image);
                TextView tv_simpletext = views.findViewById(R.id.tv_simpletext);
                iv_image.setImageResource(R.drawable.ic_toastimage);
                tv_simpletext.setText(R.string.this_is_custom_toast);     //custom Toast
                Toast toast = new Toast(MainActivity.this);
                toast.setGravity(Gravity.CENTER, 200, 310);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(views);
                toast.show();
                break;
        }
    }
}


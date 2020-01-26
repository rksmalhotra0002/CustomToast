package com.customtoast.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.customtoast.R;

public class MainActivity extends AppCompatActivity {
private Button btn_customtoast,btn_simpletoast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

            getids();

    }

    private void getids()
    {
        btn_customtoast = findViewById(R.id.btn_customtoast);
        btn_simpletoast=findViewById(R.id.btn_simpletoast);

        setlistener();
    }

    private void setlistener()
    {
        btn_simpletoast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,"Simple Toast",Toast.LENGTH_LONG).show();

            }
        });

        btn_customtoast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showToast();

            }
        });
    }

    private void showToast() {
        LayoutInflater inflater=getLayoutInflater();
        View view=inflater.inflate(R.layout.toast_layout,(ViewGroup)findViewById(R.id.toast_root));
        ImageView iv_image=view.findViewById(R.id.iv_image);
        TextView tv_desc=view.findViewById(R.id.tv_desc);
        iv_image.setImageResource(R.drawable.ic_toastimage);
        tv_desc.setText(R.string.this_is_custom_toast);
        Toast toast=new Toast(MainActivity.this);
        toast.setGravity(Gravity.CENTER,0,330);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();

    }

}

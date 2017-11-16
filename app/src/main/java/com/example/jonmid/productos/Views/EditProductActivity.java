package com.example.jonmid.productos.Views;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.jonmid.productos.R;

public class EditProductActivity extends AppCompatActivity {

    TextView textViewId;
    TextInputEditText textInputEditTextName;
    TextInputEditText textInputEditTextDescription;
    TextInputEditText textInputEditTextPrice;
    TextInputEditText textInputEditTextImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);

        textViewId = (TextView) findViewById(R.id.id_tv_edit_idproduc);
        textInputEditTextName = (TextInputEditText) findViewById(R.id.id_tiet_edit_name);
        textInputEditTextDescription = (TextInputEditText) findViewById(R.id.id_tiet_edit_description);
        textInputEditTextPrice = (TextInputEditText) findViewById(R.id.id_tiet_edit_price);
        textInputEditTextImage = (TextInputEditText) findViewById(R.id.id_tiet_edit_image);

        sqliteHelper = new   SqliteHelper (context this , fun "bd_productos", factory null, )
        id= Integer.parseint(getInteger().getExtras().getString (Key "id"));

        textInputEditTextName.setText(getIntent().getExtras().getString(Key"name"));
        textInputEditTextDescription.setText(getIntent().getExtras().getString(Key"description"));
        textInputEditTextPrice.setText(getIntent().getExtras().getString(Key"price"));
        textInputEditTextImage.setText(getIntent().getExtras().getString(Key"image"));
        textViewId.setText(getIntent().getExtras().getString(Key"id"));

    }

    public void editProduct(View view){

        SQLiteDatabase  db = sqliteHelper.getWritableDatabase();
        db.execSQL("update products set name = '"+ textInputEditTextName.getText().toString + "'" +
                ","+" description = '"textInputEditTextDescription.getText().toString + "'" +
                ","+" price = '"textInputEditTextPrice.getText().toString + "'" +
                ","+" image = '" textInputEditTextImage.getText().toString + "' where id = "+id);

        Toast.makeText(context this , text "contacto actualizado", Toast.LENGTH_SHORT).show();
        Intent instent = new Intent(packageContext this , IndexActivity.class);
        startActivity(intent);

    }
}

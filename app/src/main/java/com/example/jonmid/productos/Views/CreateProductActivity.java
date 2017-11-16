package com.example.jonmid.productos.Views;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.jonmid.productos.R;

public class CreateProductActivity extends AppCompatActivity {

    TextInputEditText textInputEditTextName;
    TextInputEditText textInputEditTextDescription;
    TextInputEditText textInputEditTextPrice;
    TextInputEditText textInputEditTextImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product);

        textInputEditTextName = (TextInputEditText) findViewById(R.id.id_tiet_new_name);
        textInputEditTextDescription = (TextInputEditText) findViewById(R.id.id_tiet_new_description);
        textInputEditTextPrice = (TextInputEditText) findViewById(R.id.id_tiet_new_price);
        textInputEditTextImage = (TextInputEditText) findViewById(R.id.id_tiet_new_image);
    }



    public void createProduct(View view){

        SQLiteDatabase  db = sqliteHelper.getWritableDatabase ;
        ContentValues values = new  ContentValues;

        values.put(ConstantsUtilities.TABLE_FIELD_PRODUCTS_NAME, textInputEditTextName.getText().toString());
        values.put(ConstantsUtilities.TABLE_FIELD_PRODUCTS_DESCRIPTION, textInputEditTextDescription.getText().toString());
        values.put(ConstantsUtilities.TABLE_FIELD_PRODUCTS_PRICE, textInputEditTextPrice.getText().toString());
        values.put(ConstantsUtilities.TABLE_FIELD_PRODUCTS_IMAGE, textInputEditTextImage.getText().toString());
        Long  idResult = db.insert(ConstantsUtilities.TABLE_NAME_PRODUCTS, ConstantsUtilities.TABLE_FIELD_PRODUCTS_ID, values);

        textInputEditTextName.setText("");
        textInputEditTextDescription.setText("");
        textInputEditTextPrice.setText("");
        textInputEditTextImage.setText("");
        Toast.makeText(content this,text"producto asignado", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent (packageContext this , IndexActivity.class);

        startActivity(intent);

        //
    }
}

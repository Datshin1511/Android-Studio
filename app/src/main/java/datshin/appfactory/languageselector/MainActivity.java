package datshin.appfactory.languageselector;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView introText;
    SharedPreferences sharedPreferences = null;
    MenuInflater menuInflater=null;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menuInflater = (MenuInflater) getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        introText.setVisibility(View.VISIBLE);
        Log.i("View this Info", String.valueOf(item.getItemId()));
        switch(item.getItemId()){
            case R.id.english: introText.setText("Hello, How are you ?");
                sharedPreferences.edit().putString("Default_language", "english").apply();
                introText.setVisibility(View.VISIBLE);
                return true;
            case R.id.arabic: introText.setText("مرحبا، كيف حالك ؟");
                sharedPreferences.edit().putString("Default_language", "arabic").apply();
                introText.setVisibility(View.VISIBLE);
                return true;
            case R.id.chinese: introText.setText("你好，请问你还好吗？");
                sharedPreferences.edit().putString("Default_language", "chinese").apply();
                introText.setVisibility(View.VISIBLE);
                return true;
            case R.id.russian: introText.setText("Здравствуйте, как поживаете?");
                sharedPreferences.edit().putString("Default_language", "russian").apply();
                introText.setVisibility(View.VISIBLE);
                return true;
            case R.id.spanish: introText.setText("Hola, cómo estás?");
                sharedPreferences.edit().putString("Default_language", "spanish").apply();
                introText.setVisibility(View.VISIBLE);
                return true;
            case R.id.french: introText.setText("Bonjour, comment allez-vous ?");
                sharedPreferences.edit().putString("Default_language", "french").apply();
                introText.setVisibility(View.VISIBLE);
                return true;
            default: return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = (SharedPreferences) this.getSharedPreferences("datshin.appfactory.languageselector", Context.MODE_PRIVATE);
        introText = (TextView) findViewById(R.id.introText);
        introText.setVisibility(View.INVISIBLE);
        boolean var = false;

        String language = sharedPreferences.getString("Default_language", "");

        switch (language) {
            case "english":
                introText.setText("Hello, How are you ?");
                var = true;
                break;
            case "arabic":
                introText.setText("مرحبا، كيف حالك ؟");
                var = true;
                break;
            case "chinese":
                introText.setText("你好，请问你还好吗？");
                var = true;
                break;
            case "russian":
                introText.setText("Здравствуйте, как поживаете?");
                var = true;
                break;
            case "spanish":
                introText.setText("Hola, cómo estás?");
                var = true;
                break;
            case "french":
                introText.setText("Bonjour, comment allez-vous ?");
                var = true;
                break;
            default:
                introText.setText("");
        }

        introText.setVisibility(View.VISIBLE);
        if (!(var)) {
                new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_btn_speak_now)
                        .setTitle("Set your language !")
                        .setMessage("You have to choose any one of the given languages to proceed thereby.")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), "Select the menu option at the top right-end", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), "You were supposed to give yes !", Toast.LENGTH_LONG).show();
                            }
                        }).show();
            }

        }
    }

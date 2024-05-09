package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;





class info{
    int units;
    String genre_name;

}


class Genre {
    private HashMap<String, Integer> mystery;
    private HashMap<String, Integer> fantasy;
    private HashMap<String, Integer> thriller;

    public Genre() {
        mystery = new HashMap<>();
        fantasy = new HashMap<>();
        thriller = new HashMap<>();
    }

    public void addBook(String title, String author, String genre, int units) {
        switch (genre.toLowerCase()) {
            case "mystery":
                mystery.put(title + " by " + author, units);
                break;
            case "fantasy":
                fantasy.put(title + " by " + author, units);
                break;
            case "thriller":
                thriller.put(title + " by " + author, units);
                break;
            default:
                break;
        }
    }

    public void borrowBook(String title, int units) {
        switch (title.toLowerCase()){


        }
    }

    public ArrayList<String> getBooksByGenre(String genre) {
        switch (genre.toLowerCase()) {
            case "mystery":
                return new ArrayList<>(mystery.keySet());
            case "fantasy":
                return new ArrayList<>(fantasy.keySet());
            case "thriller":
                return new ArrayList<>(thriller.keySet());
            default:
                return new ArrayList<>();
        }
    }
}

public class MainActivity extends AppCompatActivity {

    EditText titleEditText;
    EditText authorEditText;
    EditText genreEditText;
    EditText unitsEditText;
    Button addButton;
    Button borrowButton;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Genre  bookManager;
            titleEditText = findViewById(R.id.titleEditText);
            authorEditText = findViewById(R.id.authorEditText);
            genreEditText = findViewById(R.id.genreEditText);
            unitsEditText = findViewById(R.id.unitsEditText);
            addButton = findViewById(R.id.addButton);
            borrowButton = findViewById(R.id.borrowButton);
            textView=findViewById(R.id.textView);

            bookManager = new Genre();

            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String title = titleEditText.getText().toString();
                    String author = authorEditText.getText().toString();
                    String genre = genreEditText.getText().toString();
                    int units = Integer.parseInt(unitsEditText.getText().toString());

                    bookManager.addBook(title, author, genre, units);
                    textView.setText("added"+title+"book");


                }
            });

            borrowButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String title = titleEditText.getText().toString();
                    int units = Integer.parseInt(unitsEditText.getText().toString());

                    bookManager.borrowBook(title, units);
                    textView.setText("borrow book");
                }
            });
    }
}
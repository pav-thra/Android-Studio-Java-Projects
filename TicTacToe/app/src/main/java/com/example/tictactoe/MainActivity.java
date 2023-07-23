package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tictactoe.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private final List<int[]> cl = new ArrayList<>();
    int[] bp = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    int p_turn = 1; //player turn
    int tsb = 1; //total selected boxes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);

        cl.add(new int[]{0, 1, 2});
        cl.add(new int[]{3, 4, 5});
        cl.add(new int[]{6, 7, 8});
        cl.add(new int[]{0, 3, 6});
        cl.add(new int[]{1, 4, 7});
        cl.add(new int[]{2, 5, 8});
        cl.add(new int[]{2, 4, 6});
        cl.add(new int[]{0, 4, 8});

        String n1 = getIntent().getStringExtra("Player 1");
        String n2 = getIntent().getStringExtra("Player 2");
        binding.playerOneName.setText(n1);
        binding.playerTwoName.setText(n2);

        binding.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(0)) {
                    performAction((ImageView) view, 0);
                }
            }
        });

        binding.image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(1)) {
                    performAction((ImageView) view, 1);
                }
            }
        });
        binding.image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(2)) {
                    performAction((ImageView) view, 2);
                }
            }
        });
        binding.image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(3)) {
                    performAction((ImageView) view, 3);
                }
            }
        });
        binding.image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(4)) {
                    performAction((ImageView) view, 4);
                }
            }
        });
        binding.image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(5)) {
                    performAction((ImageView) view, 5);
                }
            }
        });
        binding.image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(6)) {
                    performAction((ImageView) view, 6);
                }
            }
        });
        binding.image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(7)) {
                    performAction((ImageView) view, 7);
                }
            }
        });
        binding.image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(8)) {
                    performAction((ImageView) view, 8);
                }
            }
        });
    }

    private boolean isBoxSelectable(int i) {
        boolean response = false;
        if (bp[i] == 0) {
            response = true;
        }
        return response;
    }


    private void performAction(ImageView imageView, int selectedBoxPosition) {
        bp[selectedBoxPosition] = p_turn;

        if (p_turn == 1) {
            imageView.setImageResource(R.drawable.x);
            if (checkResults()) {
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, binding.playerOneName.getText().toString()
                        + " is a Winner!", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else if (tsb == 9) {
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, "Match Draw", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else {
                changePlayerTurn(2);
                tsb++;
            }
        } else {
            imageView.setImageResource(R.drawable.o);
            if (checkResults()) {
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, binding.playerTwoName.getText().toString()
                        + " is a Winner!", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else if (tsb == 9) {
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, "Match Draw", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else {
                changePlayerTurn(1);
                tsb++;
            }
        }
    }

    private void changePlayerTurn(int currentPlayerTurn) {
        p_turn = currentPlayerTurn;
        if (p_turn == 1) {
            binding.playerOneLayout.setBackgroundResource(R.drawable.black_border);
            binding.playerTwoLayout.setBackgroundResource(R.drawable.black_box);
        } else {
            binding.playerTwoLayout.setBackgroundResource(R.drawable.black_border);
            binding.playerOneLayout.setBackgroundResource(R.drawable.black_box);
        }
    }

    public void restartMatch() {
        bp = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}; //9 zero
        p_turn = 1;
        tsb = 1;

        binding.image1.setImageResource(R.drawable.black_box);
        binding.image2.setImageResource(R.drawable.black_box);
        binding.image3.setImageResource(R.drawable.black_box);
        binding.image4.setImageResource(R.drawable.black_box);
        binding.image5.setImageResource(R.drawable.black_box);
        binding.image6.setImageResource(R.drawable.black_box);
        binding.image7.setImageResource(R.drawable.black_box);
        binding.image8.setImageResource(R.drawable.black_box);
        binding.image9.setImageResource(R.drawable.black_box);
    }


    private boolean checkResults() {
        boolean response = false;
        for (int i = 0; i < cl.size(); i++) {
            final int[] combination = cl.get(i);

            if (bp[combination[0]] == p_turn && bp[combination[1]] == p_turn &&
                    bp[combination[2]] == p_turn) {
                response = true;
            }
        }
        return response;
    }
}

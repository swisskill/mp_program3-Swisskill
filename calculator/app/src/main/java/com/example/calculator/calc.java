package com.example.calculator;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class calc extends Fragment {

    String pri = "";
    String sec = "";
    boolean hasOp = false;
    boolean fdec = false;
    boolean fadd = false;
    boolean fsub = false;
    boolean fmul = false;
    boolean fdiv = false;
    boolean fpow = false;

    public static calc newInstance(){
        return new calc();
    }
    public String priOr(int buttonNum){
        String butStr = Integer.toString(buttonNum);
        if (!hasOp){
            pri = pri + butStr;
            return pri;
        }
        else{
            sec = sec + butStr;
            return sec;
        }
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_calc, container, false);
        Button num1 = myView.findViewById(R.id.button3);
        Button num2 = myView.findViewById(R.id.button6);
        Button num3 = myView.findViewById(R.id.button8);
        Button num4 = myView.findViewById(R.id.button9);
        Button num5 = myView.findViewById(R.id.button11);
        Button num6 = myView.findViewById(R.id.button12);
        Button num7 = myView.findViewById(R.id.button14);
        Button num8 = myView.findViewById(R.id.button15);
        Button num9 = myView.findViewById(R.id.button17);
        Button num0 = myView.findViewById(R.id.button18);
        Button mulO = myView.findViewById(R.id.button20);
        Button addO = myView.findViewById(R.id.button13);
        Button divO = myView.findViewById(R.id.button21);
        Button subO = myView.findViewById(R.id.button16);
        Button clrO = myView.findViewById(R.id.button7);
        Button negO = myView.findViewById(R.id.button10);
        Button powO = myView.findViewById(R.id.button19);
        Button decO = myView.findViewById(R.id.button22);
        Button eqlO = myView.findViewById(R.id.button23);
        TextView cal = myView.findViewById(R.id.textView);
        //---------------------------------------------------------------

        //-----------------------------------------------------------------
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String display = priOr(1);
                cal.setText(display);
                //Toast.makeText(requireContext(),pri, Toast.LENGTH_SHORT).show();
            }
        });
        addO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasOp = true;
                fadd = true;
            }
        });

        eqlO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fadd){
                    double fdis = Double.parseDouble(pri) + Double.parseDouble(sec);
                    cal.setText(Double.toString(fdis));
                }
            }
        });
        clrO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ATTN: reset all values to original
                pri = "";
                sec = "";
                hasOp = false;
                fdec = false;
                fadd = false;
                fsub = false;
                fmul = false;
                fdiv = false;
                fpow = false;
                cal.setText("");
            }
        });



        return myView;
    }
}
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

        eqlO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double fdis = 0;
                if(fadd) {
                    fdis = Double.parseDouble(pri) + Double.parseDouble(sec);
                }else if(fsub){fdis = Double.parseDouble(pri) - Double.parseDouble(sec);}
                else if(fmul){fdis = Double.parseDouble(pri) * Double.parseDouble(sec);}
                else if(fdiv){fdis = Double.parseDouble(pri) / Double.parseDouble(sec);}
                else if(fpow){fdis = Math.pow(Double.parseDouble(pri),Double.parseDouble(sec));}
                cal.setText(Double.toString(fdis));
                pri = Double.toString(fdis);
                sec = "";
                hasOp = false;
                fdec = false;
                fadd = false;
                fsub = false;
                fmul = false;
                fdiv = false;
                fpow = false;
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
        //-------------------------------------------------------------------
        //----------------------OPERATORS------------------------------------
        //need tempOp flag to make sure they can't do ++
        //init set to true, hitting numbers sets to false. equals sets to false too
        //make sure that the op is the previous not the next
        addO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hasOp){
                    double dis = Double.parseDouble(pri) + Double.parseDouble(sec);
                    cal.setText(Double.toString(dis));
                    pri = Double.toString(dis);
                    sec = "";
                }
                hasOp = true;
                fadd = true;
                fdec = false;
                fsub = false;
                fmul = false;
                fdiv = false;
                fpow = false;
            }
        });
        subO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hasOp){
                    double dis = Double.parseDouble(pri) - Double.parseDouble(sec);
                    cal.setText(Double.toString(dis));
                    pri = Double.toString(dis);
                    sec = "";
                }
                hasOp = true;
                fsub = true;
                fdec = false;
                fadd = false;
                fmul = false;
                fdiv = false;
                fpow = false;
            }
        });
        mulO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hasOp){
                    double dis = Double.parseDouble(pri) * Double.parseDouble(sec);
                    cal.setText(Double.toString(dis));
                    pri = Double.toString(dis);
                    sec = "";
                }
                hasOp = true;
                fmul = true;
                fdec = false;
                fadd = false;
                fsub = false;
                fdiv = false;
                fpow = false;
            }
        });
        divO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hasOp){
                    double dis = Double.parseDouble(pri) / Double.parseDouble(sec);
                    cal.setText(Double.toString(dis));
                    pri = Double.toString(dis);
                    sec = "";
                }
                hasOp = true;
                fdiv = true;
                fdec = false;
                fadd = false;
                fsub = false;
                fmul = false;
                fpow = false;
            }
        });
        powO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hasOp){
                    double dis = Math.pow(Double.parseDouble(pri),Double.parseDouble(sec));
                    cal.setText(Double.toString(dis));
                    pri = Double.toString(dis);
                    sec = "";
                }
                hasOp = true;
                fpow = true;
                fdec = false;
                fadd = false;
                fsub = false;
                fmul = false;
                fdiv = false;
            }
        });

        //-------------------------------------------------------------------
        //----------------------NUMBERS--------------------------------------

        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String display = priOr(1);
                cal.setText(display);
                //Toast.makeText(requireContext(),pri, Toast.LENGTH_SHORT).show();
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String display = priOr(2);
                cal.setText(display);
                //Toast.makeText(requireContext(),pri, Toast.LENGTH_SHORT).show();
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String display = priOr(3);
                cal.setText(display);
                //Toast.makeText(requireContext(),pri, Toast.LENGTH_SHORT).show();
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String display = priOr(4);
                cal.setText(display);
                //Toast.makeText(requireContext(),pri, Toast.LENGTH_SHORT).show();
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String display = priOr(5);
                cal.setText(display);
                //Toast.makeText(requireContext(),pri, Toast.LENGTH_SHORT).show();
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String display = priOr(6);
                cal.setText(display);
                //Toast.makeText(requireContext(),pri, Toast.LENGTH_SHORT).show();
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String display = priOr(7);
                cal.setText(display);
                //Toast.makeText(requireContext(),pri, Toast.LENGTH_SHORT).show();
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String display = priOr(8);
                cal.setText(display);
                //Toast.makeText(requireContext(),pri, Toast.LENGTH_SHORT).show();
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String display = priOr(9);
                cal.setText(display);
                //Toast.makeText(requireContext(),pri, Toast.LENGTH_SHORT).show();
            }
        });
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String display = priOr(0);
                cal.setText(display);
                //Toast.makeText(requireContext(),pri, Toast.LENGTH_SHORT).show();
            }
        });



        return myView;
    }
}
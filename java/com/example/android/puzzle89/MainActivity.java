package com.example.android.puzzle89;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int freeplace=9;
    String[] pict={"and1","and2","and3","and4","and5","and6","and7","and8","and9"};


    public void changePosition(int numberOfButton)
    {
        if (allowChangePosition(numberOfButton,freeplace)){
            setNewPosition(numberOfButton,freeplace);
        }
    }
    public void changePosition(View V)
    {
        //ImageView imgView=(ImageView)V;
        //String name=imgView.getId
        int numberOfButton=V.getId();
        String a=V.toString();
        a=a.substring(a.length()-2,a.length()-1);
        numberOfButton=Integer.parseInt(a);

        if (numberOfButton!=freeplace) //not blank click
            {
            if (allowChangePosition(numberOfButton, freeplace)) {
                setNewPosition(numberOfButton, freeplace);
                freeplace=numberOfButton;
            }

        }

    }


    public boolean allowChangePosition(int currentPosition,int newPosition)
    {

        if (currentPosition==1&&(newPosition==2||newPosition==4)) {
            return true; }
        if (currentPosition==2&&(newPosition==1||newPosition==3||newPosition==5)){
            return true; }
        if (currentPosition==3&&(newPosition==2||newPosition==6)){
            return true; }
        if (currentPosition==4&&(newPosition==1||newPosition==5||newPosition==7)){
            return true; }
        if (currentPosition==5&&(newPosition==2||newPosition==4||newPosition==6||newPosition==8)){
            return true; }
        if (currentPosition==6&&(newPosition==5||newPosition==3||newPosition==9)){
            return true; }
        if (currentPosition==7&&(newPosition==4||newPosition==8)){
            return true; }
        if (currentPosition==8&&(newPosition==7||newPosition==5||newPosition==9)){
            return true; }
        if (currentPosition==9&&(newPosition==8||newPosition==6)){
            return true; }


        return false;
    }

    public void setNewPosition(int orygPosition,int newposition)
    {

        //orygPosition - click button
        //newposition - blank place
        //
        //get name of button where is in dest place (newButton)
        String nameOfButton="imageButton"+ Integer.toString(newposition);
        int resID = getResources().getIdentifier(nameOfButton, "id", getPackageName());
        ImageButton newButton = (ImageButton) findViewById(resID);
        //get name of image, which I move (nameOfPict)
        String nameOfPict=pict[orygPosition-1];//"and"+Integer.toString(orygPosition);
        int imgID=getResources().getIdentifier(nameOfPict,"drawable",getPackageName());
        newButton.setImageResource(imgID);
        pict[newposition-1]=pict[orygPosition-1];
        pict[orygPosition-1]="and9";


        //get name of button where from block is move end set blank (oldButton)
        nameOfButton="imageButton"+ Integer.toString(orygPosition);
        //imgID=getResources().getIdentifier("and9","drawable",getPackageName());
        //set empty block
        resID = getResources().getIdentifier(nameOfButton, "id", getPackageName());
        ImageButton oldButton = (ImageButton) findViewById(resID);
        oldButton.setImageResource(R.drawable.and9);









    }
}

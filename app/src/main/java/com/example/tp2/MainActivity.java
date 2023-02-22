package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tp2.R;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {

    private TextView operation;
    private EditText display;

    boolean isPortrait = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operation = findViewById(R.id.Cal);
        display = findViewById(R.id.display);
        display.setShowSoftInputOnFocus(false);
    }

    private void update(String str) {

        String oldStr = display.getText().toString();
        int cursorPosition = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPosition);
        String rightStr = oldStr.substring(cursorPosition);
        display.setText(String.format("%s%s%s", leftStr, str, rightStr));
        display.setSelection(cursorPosition + str.length());
    }

    public void zeroBtn(View v) {
        update(getResources().getString(R.string.zeroText));
    }

    public void oneBtn(View v) {
        update(getResources().getString(R.string.oneText));
    }

    public void twoBtn(View v) {
        update(getResources().getString(R.string.twoText));
    }

    public void threeBtn(View v) {
        update(getResources().getString(R.string.threeText));
    }

    public void foureBtn(View v) {
        update(getResources().getString(R.string.fourText));
    }

    public void fiveBtn(View v) {
        update(getResources().getString(R.string.fiveText));
    }

    public void sixBtn(View v) {
        update(getResources().getString(R.string.sixText));
    }

    public void sevenBtn(View v) {
        update(getResources().getString(R.string.sevenText));
    }

    public void eightBtn(View v) {
        update(getResources().getString(R.string.eightText));
    }

    public void nineBtn(View v) {
        update(getResources().getString(R.string.nineText));
    }

    public void parenthesisOpenBtn(View v) {
        update(getResources().getString(R.string.parenthesesOpenText));
    }

    public void parenthesiscloseBtn(View v) {
        update(getResources().getString(R.string.parenthesesCloseText));
    }

    public void divideBtn(View v) {
        update(getResources().getString(R.string.divideText));
    }

    public void multiplyBtn(View v) {
        update(getResources().getString(R.string.multiplyText));
    }

    public void subtractBtn(View v) {
        update(getResources().getString(R.string.subtractText));
    }

    public void decimalBtn(View v) {
        update(getResources().getString(R.string.decimalText));
    }

    public void addBtn(View v) {
        update(getResources().getString(R.string.addText));
    }

    public void equalsBtn(View v) {

        String userExpression = display.getText().toString();
        operation.setText(userExpression);
        userExpression = userExpression.replaceAll(getResources().getString(R.string.divideText), "/");
        userExpression = userExpression.replaceAll(getResources().getString(R.string.multiplyText), "*");
        Expression exp = new Expression(userExpression);
        String result = Double.toString(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());

    }

    public void clearBtn(View v) {
        display.setText("");
        operation.setText("");
    }

    public void trigSinBtn(View v) {
        update("sin(");
    }

    public void trigCosBtn(View v) {
        update("cos(");
    }

    public void trigtanBtn(View v) {
        update("tan(");
    }

    public void trigArcSinBtn(View v) {
        update("arcsin(");
    }

    public void trigArcCosBtn(View v) {
        update("arccos(");
    }

    public void trigArcTanBtn(View v) {
        update("arctan(");
    }

    public void logBtn(View v) {
        update("log(");
    }

    public void naturalLogBtn(View v) {
        update("ln(");
    }

    public void absBtn(View v) {
        update("abs(");
    }

    public void piBtn(View v) {
        update("pi");
    }

    public void eBtn(View v) {
        update("e");
    }

    public void sqrtBtn(View v) {
        update("sqrt(");
    }

    public void xSquaredBtn(View v) {
        update("^(2)");
    }

    public void xPowerYBtn(View v) {
        update("^(");
    }

    public void primeBtn(View v) {
        update("isprc(");
    }

    public void backSpaceBtn(View v) {
        int cursorPosition = display.getSelectionStart();
        int textLen = display.getText().length();
        if (cursorPosition!= 0 && textLen != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPosition - 1, cursorPosition, "");
            display.setText(selection);
            display.setSelection(cursorPosition - 1);
        }
    }

    public void rotateBtn(View v) {
        if (isPortrait) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
        }
        isPortrait = !isPortrait;
    }
}

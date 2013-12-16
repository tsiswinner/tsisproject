package com.example.calcu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity implements OnClickListener{
	
	EditText edtSu1, edtSu2, edtResult;
	RadioGroup rdoGroup;
	RadioButton rdoSign;
	Button btnCalc, btnClear, btnExit;
	double num1, num2, result;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		edtSu1 = (EditText)findViewById(R.id.edtSu1);
		edtSu2 = (EditText)findViewById(R.id.edtSu2);
		edtResult = (EditText)findViewById(R.id.edtResult);
		
		btnCalc = (Button)findViewById(R.id.btnCalc);
		btnClear = (Button)findViewById(R.id.btnClear);
		btnExit = (Button)findViewById(R.id.btnExit);
		
		btnCalc.setOnClickListener(this);
		btnClear.setOnClickListener(this);
		btnExit.setOnClickListener(this);	
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnCalc:
			rdoGroup = (RadioGroup)findViewById(R.id.rdoGroup);
			rdoSign = (RadioButton)findViewById(rdoGroup.getCheckedRadioButtonId());
			
			if(edtSu1.getText().toString().equals(""))
				num1 = 0.0;
			else{
				num1 = Double.parseDouble(edtSu1.getText().toString());
			}
			
			if(edtSu2.getText().toString().equals("")){
				
				num2 = 0.0;
			}
			else{
				num2 = Double.parseDouble(edtSu2.getText().toString());
			}
			

			if(rdoSign.getId()==R.id.rdoPlus){
				result = num1 + num2;
				//edtResult.setText(result);
			}
			else if(rdoSign.getId()==R.id.rdoMinus){
				result = num1 - num2;			
			}
			else if(rdoSign.getId()==R.id.rdoMul){
				result = num1 * num2;	
			}
			else if(rdoSign.getId()==R.id.rdoDiv){
				result = num1 / num2;	
			}
			
			edtResult.setText(Double.toString(result));
			break;
			
			
		case R.id.btnClear:
			edtSu1.setText(null);
			edtSu2.setText(null);
			edtResult.setText(null);
			
			RadioButton plus = (RadioButton)findViewById(R.id.rdoPlus);
			plus.setChecked(true);
			break;
			
		case R.id.btnExit:
			finish();
			break;
		default:
			break;
			
		}
		
		
	}
	
	

}

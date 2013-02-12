package com.example.heealterdialog;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends FragmentActivity implements OnClickListener {
	ToggleButton objTGButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		objTGButton = (ToggleButton)findViewById(R.id.tgbtnSwitch);
		objTGButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// ������� deprecated �� ��
		//showDialog(0);
		
		// Fragment�� �̿��ϴ� ���
		DialogFragment newFragment = AlertDialogFragment.newInstance(0);
	    newFragment.show(getSupportFragmentManager(), "dialog");
	}

	// ���� ��
	/*
	@Override
	protected Dialog onCreateDialog(int id) {
		super.onCreateDialog(id);
		AlertDialog dlgAlert;
		
		dlgAlert = new AlertDialog.Builder(this)
			.setIcon(R.drawable.question)
			.setTitle("�˸�!")
			.setMessage("��ȭ�ð� 3�� �ʰ�!")
			.setView(createCustomView())
			.setPositiveButton("Ȯ��(ok)", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			}).create();
		
		return dlgAlert;
	}
	
	
	private View createCustomView() {
		LinearLayout objLayoutView;
		ListView lstViewCalling;
		ArrayList<String> lstItems;
		ArrayAdapter<String> aryADTItems;
		
		objLayoutView = new LinearLayout(this);
		lstViewCalling = new ListView(this);
		lstItems = new ArrayList<String>();
		lstItems.add("��ȭ ���");
		lstItems.add("��ȭ ����");
		
		aryADTItems = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, lstItems);
		
		lstViewCalling.setAdapter(aryADTItems);
		lstViewCalling.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		lstViewCalling.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int index,
					long id) {
				String strData = null;
				if (index == 0) {
					strData = "��ȭ��.....";
				} else {
					strData = "��ȭ�� �����մϴ�.";
				}
				Toast.makeText(MainActivity.this, strData, Toast.LENGTH_SHORT).show();
			}
		});
		objLayoutView.setOrientation(LinearLayout.VERTICAL);
		objLayoutView.addView(lstViewCalling);
		
		return objLayoutView;
	}
	*/
	
	@Override
	public void onPrepareDialog(int id, Dialog dlg) {
		super.onPrepareDialog(id, dlg);
	}
}

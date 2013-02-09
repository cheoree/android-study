package com.example.heealterdialog;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class AlertDialogFragment extends DialogFragment {
	public static AlertDialogFragment newInstance(int title) {
		AlertDialogFragment frag = new AlertDialogFragment();
		
        Bundle args = new Bundle();
        args.putInt("title", title);
        
        frag.setArguments(args);
        
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
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
    }
    
    private View createCustomView() {
		LinearLayout objLayoutView;
		ListView lstViewCalling;
		ArrayList<String> lstItems;
		ArrayAdapter<String> aryADTItems;
		
		objLayoutView = new LinearLayout(getActivity());
		lstViewCalling = new ListView(getActivity());
		lstItems = new ArrayList<String>();
		lstItems.add("��ȭ ���");
		lstItems.add("��ȭ ����");
		
		aryADTItems = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_single_choice, lstItems);
		
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
				Toast.makeText(getActivity(), strData, Toast.LENGTH_SHORT).show();
			}
		});
		objLayoutView.setOrientation(LinearLayout.VERTICAL);
		objLayoutView.addView(lstViewCalling);
		
		return objLayoutView;
	}
}

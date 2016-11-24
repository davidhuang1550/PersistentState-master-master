package com.example.marek.persistentstate;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by xlhuang3 on 11/24/2016.
 */
public class optionDialog extends DialogFragment{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Options");
        final EditText editText = new EditText(getActivity());

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        editText.setLayoutParams(layoutParams);
        alertDialog.setView(editText);

        alertDialog.setPositiveButton("Set", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(!(editText.getText().toString().equals(""))) {
                    ((MainActivity)getActivity()).setLimit(editText.getText().toString());
                    
                    SharedPreferences sp = getActivity().getSharedPreferences(((MainActivity)getActivity()).PREF_FILE_NAME, 0);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("maxSize",Integer.parseInt(editText.getText().toString()));
                    editor.commit();
                    
                    ((MainActivity)getActivity()).load();
                }
                else{
                    Toast.makeText(getActivity(),"Nothing was Set",Toast.LENGTH_SHORT).show();
                    // editText.setHint("Intput Some Characters");
                    //  alertDialog.setView(editText);
                }
            }
        });
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setShowsDialog(false);
                dismiss();
            }
        });
        return alertDialog.create();
    }
}

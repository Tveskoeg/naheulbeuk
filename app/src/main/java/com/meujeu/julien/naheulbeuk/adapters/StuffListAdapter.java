package com.meujeu.julien.naheulbeuk.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.meujeu.julien.naheulbeuk.R;
import com.meujeu.julien.naheulbeuk.table.items.Stuff;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Julien on 12/06/2017.
 */

public class StuffListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<Stuff>> _listDataChild;

    public StuffListAdapter(Context context, List<String> listDataHeader,
                            HashMap<String, List<Stuff>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final Stuff p = (Stuff) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.row_stuff, null);
        }


        TextView tt1 = convertView.findViewById(R.id.nomStuff);
        TextView tt2 = convertView.findViewById(R.id.prixStuff);
        TextView tt3 = convertView.findViewById(R.id.prOuDgtStuff);
        TextView tt4 = convertView.findViewById(R.id.malusStuff);
        TextView tt5 = convertView.findViewById(R.id.bonusStuff);
        TextView tt6 = convertView.findViewById(R.id.ruptureStuff);

        if (tt1 != null) {
            tt1.setText(p.getNom());
        }
        if (tt2 != null) {
            tt2.setText(p.getPrix());
        }
        if (tt3 != null) {
            tt3.setText(p.getPrOuDgts());
        }
        if (tt4 != null) {
            tt4.setText(p.getMalus());
        }
        if (tt5 != null) {
            tt5.setText(p.getBonus());
        }
        if (tt6 != null) {
            tt6.setText(p.getRupture());
        }


        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        TextView lblListHeader = convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        if (getChildrenCount(groupPosition) == 0) {
            convertView.setVisibility(View.INVISIBLE);

        } else {
            convertView.setVisibility(View.VISIBLE);
            //indicator.setImageResource( isExpanded ? R.drawable.list_group_expanded : R.drawable.list_group_closed );
        }
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
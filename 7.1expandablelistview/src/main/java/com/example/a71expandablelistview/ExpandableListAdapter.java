package com.example.a71expandablelistview;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ADMIN on 1/3/2018.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> expandleListGroupTitle;
    private HashMap<String, List<String>> expandableListDetails;

    public ExpandableListAdapter(Context context, List<String> expandleListGroupTitle, HashMap<String, List<String>> expandableListDetails) {
        this.context = context;
        this.expandleListGroupTitle = expandleListGroupTitle;
        this.expandableListDetails = expandableListDetails;
    }

    @Override
    public int getGroupCount() {
        //return 0;
        return this.expandleListGroupTitle.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        //return null;
        return this.expandleListGroupTitle.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        //return 0;
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        //return null;
        String listTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_group, null);
        }
        TextView listTitleTextView = convertView
                .findViewById(R.id.listGroupTitle);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);
        return convertView;
    }


    @Override
    public int getChildrenCount(int groupPosition) {
        //return 0;
        return this.expandableListDetails.get(this.expandleListGroupTitle.get(groupPosition)).size();
    }


    @Override
    public Object getChild(int groupPosition, int childPosition) {
        //return null;
        return this.expandableListDetails.get(this.expandleListGroupTitle.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        //return 0;
        return childPosition;
    }


    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        //return null;
        final String ExpandedListText = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }

        TextView expandableListTextView = convertView.findViewById(R.id.expandedListItem);
        expandableListTextView.setText(ExpandedListText);
        return convertView;
    }


    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        //return false;
        return true;
    }
}

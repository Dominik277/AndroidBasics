package android.basics;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class DemoSelectorActivity extends AppCompatActivity {







    private class ChaptersListAdapter extends BaseExpandableListAdapter{

    private String[] chapters = getResources().getStringArray(R.array.chapters);
    private String[][] exercises;

    public ChaptersListAdapter(){
        super();
        exercises = new String[chapters.length][];
        for (int i=0; i<exercises.length; i++){
            int resId = getResources().getIdentifier
                    ("chap" + (i+1),"array",getPackageName());
            exercises[i] = getResources().getStringArray(resId);
        }
    }


    @Override
    public int getGroupCount() {
        return 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}

}





package android.basics;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DemoSelectorActivity extends AppCompatActivity {







    private class ChaptersListAdapter extends BaseExpandableListAdapter {

        private String[] chapters = getResources().getStringArray(R.array.chapters);
        private String[][] exercises;

        public ChaptersListAdapter() {
            super();
            exercises = new String[chapters.length][];
            for (int i = 0; i < exercises.length; i++) {
                int resId = getResources().getIdentifier
                        ("chap" + (i + 1), "array", getPackageName());
                exercises[i] = getResources().getStringArray(resId);
            }
        }


        @Override
        public int getGroupCount() {
            return chapters.length;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return 0;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return "Chapter" + (groupPosition + 1) + ": " + chapters[groupPosition];
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return null;
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            TextView textView = getGenericView();
            textView.setText(getGroup(groupPosition).toString());
            return textView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            return null;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        public Class<? extends AppCompatActivity> getExcerciseClass(int groupPosition, int childPosition, long id) {
            String exerciseId = "chap" + (groupPosition + 1) + "ex" + (childPosition + 1);
            return ExerciseActivityMapper.getExerciseClass(exerciseId);
        }


    }

}





package android.basics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DemoSelectorActivity extends Activity {

    ExpandableListView elvChapters;
    ChaptersListAdapter elaAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_selector);
        setupChaptersListView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_demo_selector, menu);
        return true;
    }

    private void setupChaptersListView() {
        elvChapters = findViewById(R.id.expandableListView);
        elaAdapter = new ChaptersListAdapter();
        elvChapters.setAdapter(elaAdapter);
        elvChapters.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                String excerciseTitle = (String) elaAdapter.getChild(groupPosition,childPosition);
                Class<? extends Activity> excerciseClass = elaAdapter.getExcerciseClass(groupPosition,childPosition,id);
                if (excerciseClass != null){
                    Toast.makeText(DemoSelectorActivity.this,excerciseTitle,Toast.LENGTH_LONG).show();
                    startActivity(new Intent(DemoSelectorActivity.this,excerciseClass));
                }else {
                    Toast.makeText(DemoSelectorActivity.this,"Excercise not available!",
                            Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });
    }

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


        public TextView getGenericView() {
            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
            );
            TextView textView = new TextView(DemoSelectorActivity.this);
            textView.setLayoutParams(lp);
            textView.setTextSize(20);
            textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
            textView.setPadding(60, 20, 20, 20);
            return textView;
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

        public Class<? extends Activity> getExcerciseClass(int groupPosition, int childPosition, long id) {
            String exerciseId = "chap" + (groupPosition + 1) + "ex" + (childPosition + 1);
            return ExerciseActivityMapper.getExerciseClass(exerciseId);
        }


    }

}





package android.basics;

import android.app.Activity;

import java.util.HashMap;

public class ExerciseActivityMapper {

    private static ExerciseActivityMapper singleton;
    private HashMap<String,Class<? extends Activity>> exerciseClassMap;

    public ExerciseActivityMapper(){
        defineExerciseMappings();
    }

    public static Class<? extends Activity> getExerciseClass(String exerciseId){
        return getSingleton().exerciseClassMap.get(exerciseId);
    }

    private static ExerciseActivityMapper getSingleton(){
        if (singleton == null){
            singleton = new ExerciseActivityMapper();
        }
        return singleton;
    }

    private void defineExerciseMappings() {

        exerciseClassMap = new HashMap<String, Class<? extends Activity>>();

        exerciseClassMap.put("chap1ex1",BasicTextViewActivity.class);
        exerciseClassMap.put("cha3ex2",BasicTextViewActivity.class);
        exerciseClassMap.put("chap4ex1",BasicTextViewActivity.class);
        exerciseClassMap.put("chap5ex4",ActionBarMenuActivity.class);
        exerciseClassMap.put("chap6ex1",BasicImageDownloadActivity.class);
        exerciseClassMap.put("chap6ex2",AsyncTaskPerformActivity.class);
        exerciseClassMap.put("chap9ex1",ContactListActivity.class);

    }
}

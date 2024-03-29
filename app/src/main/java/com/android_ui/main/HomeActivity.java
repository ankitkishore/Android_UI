/*
 * Copyright (C) 2013 Manuel Peinado
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android_ui.main;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android_ui.blurdialogfragment.SampleActionBarActivity;
import com.android_ui.explosion_field.MainActivity;
import com.android_ui.fadingactionbar.*;
import com.android_ui.glassactionbardemo.*;
import com.android_ui.notboringactionbar.NoBoringActionBarActivity;
import com.android_ui.R;
import com.android_ui.spotlight.Spotlight;

public class HomeActivity extends ListActivity {
    private List<ActivityInfo> activitiesInfo = Arrays.asList(
            new ActivityInfo(ScrollViewActivity.class, R.string.activity_title_scrollview),
            new ActivityInfo(ListViewActivity.class, R.string.activity_title_listview),
            new ActivityInfo(LightBackgroundActivity.class, R.string.activity_title_light_bg),
            new ActivityInfo(LightActionBarActivity.class, R.string.activity_title_light_ab),
            new ActivityInfo(SampleFragmentActivity.class, R.string.activity_title_fragment),
            new ActivityInfo(NoParallaxActivity.class, R.string.activity_title_no_parallax),
            new ActivityInfo(NavigationDrawerActivity.class, R.string.activity_title_navigation),
            new ActivityInfo(HeaderOverlayActivity.class, R.string.activity_title_header_overlay),
            new ActivityInfo(WebViewActivity.class, R.string.activity_title_webview),
            new ActivityInfo(ShortContentActivity.class, R.string.activity_title_short_content),
            new ActivityInfo(ScrollViewActivity1.class, R.string.activity_title_scrollview1),
            new ActivityInfo(FixedHeaderActivity.class, R.string.activity_title_fixed_header),
            new ActivityInfo(ChangingContentActivity.class, R.string.activity_title_changing_content),
            new ActivityInfo(SettingsActivity.class, R.string.activity_title_settings),
            new ActivityInfo(NoBoringActionBarActivity.class, R.string.activity_title_no_boring_activity ),
            new ActivityInfo(MainActivity.class, R.string.activity_title_explosion_field),
            new ActivityInfo(Spotlight.class, R.string.activity_title_spotlight ),
            new ActivityInfo(SampleActionBarActivity.class, R.string.activity_title_blur_dialog ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        String[] titles = getActivityTitles();
        setListAdapter(new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, android.R.id.text1, titles));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Class<? extends Activity> class_ = activitiesInfo.get(position).activityClass;
        Intent intent = new Intent(this, class_);
        startActivity(intent);
    }

    private String[] getActivityTitles() {
        String[] result = new String[activitiesInfo.size()];
        int i = 0;
        for (ActivityInfo info : activitiesInfo) {
            result[i++] = getString(info.titleResourceId);
        }
        return result;
    }
}

package ru.sberbank.user7.packs;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends Activity {
private ListView packegeListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        packegeListView = (ListView) findViewById(R.id.ListPackages);
       List<PackageInfo> packageInfoList= getPackageManager().getInstalledPackages(0);
        packegeListView.setAdapter(new PackagesAdapter(packageInfoList));
    }
}

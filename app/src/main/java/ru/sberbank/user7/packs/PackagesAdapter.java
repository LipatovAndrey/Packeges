package ru.sberbank.user7.packs;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

import ru.sberbank.user7.packs.R;

/**
 * Created by user7 on 20.04.2017.
 */

public class PackagesAdapter extends BaseAdapter {
    private List<PackageInfo> packagesList;

   PackagesAdapter(List<PackageInfo> packageInfoList) {this.packagesList = Collections.unmodifiableList(packageInfoList);
    }



    @Override
    public int getCount() {
        return packagesList.size();
    }

    @Override
    public PackageInfo getItem(int position) {
        return packagesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (convertView==null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view= inflater.inflate(R.layout.package_list_item, parent, false);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.iv = (ImageView) view.findViewById(R.id.icon);
            viewHolder.tv1 = (TextView) view.findViewById(R.id.textView1);
            viewHolder.tv2 = (TextView) view.findViewById(R.id.textView2);

            view.setTag(viewHolder);
    }

    ViewHolder mViewHolder = (ViewHolder) view.getTag();
        PackageInfo packageInfo = getItem(position);

        if(packageInfo.applicationInfo != null){
            PackageManager pm = parent.getContext().getPackageManager();
            mViewHolder.tv2.setText(packageInfo.applicationInfo.loadLabel(pm));
            Drawable icon = pm.getApplicationIcon(packageInfo.applicationInfo);
            mViewHolder.iv.setImageDrawable(icon);
        }
        mViewHolder.tv1.setText(packageInfo.packageName);
        mViewHolder.tv2.setText(packageInfo.packageName);

        return view;
    }


    private static class ViewHolder{
        private ImageView iv;
        private TextView tv1, tv2;
    }
//
//    private static class loadInfoTask extends AsyncTask<void, void, Object>{
//        PackageInfo packageInfo;
//        PackageManager packageManager;
//        WeakReference<ImageView> img;
//        WeakReference<TextView> textref;
//
//        public loadInfoTask(PackageInfo packageInfo,PackageManager packageManager, ImageView imageTarget, TextView textTarget){
//            this.packageInfo = packageInfo;
//            this.packageManager = packageManager;
//             img = new WeakReference<ImageView>(imageTarget);
//            textref = new WeakReference<TextView>(textTarget);
//        }
//
//        @Override
//        protected void onPostExecute(ProcessInfo processInfo) {
//            ImageView imageView = img.get();
//            TextView textView = textref.get();
//
//        }
//
//        @Override
//        protected ProcessInfo doInBackground(void... params) {
//            return null;
//        }
//        static class ProcessInfo{
//            Drawable icon;
//            CharSequence title;
//            public ProcessInfo(Drawable icon,CharSequence title){
//                this.icon = icon;
//                this.title = title;
//            }
//
//
//        }
//    }
}

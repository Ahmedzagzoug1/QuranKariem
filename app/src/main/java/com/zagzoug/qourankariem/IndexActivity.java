package com.zagzoug.qourankariem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class IndexActivity extends AppCompatActivity {
    public static final String KEY_PAGE ="pagekey" ;
    ListView  listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView= (ListView) findViewById(R.id.lv_index);

        final Intent intent=new Intent(this,QouranPager.class);
        String indexType=getIntent().getStringExtra(QouranPager.KEY_INDEX);
        if (indexType.equals(QouranPager.INDEX_SOURA)){
            setTitle("سور القران");
            ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getSoraArray());
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    int pageNumber=  Page.getSorasPage()[position];
                    intent.putExtra(KEY_PAGE,604-pageNumber);
                    startActivity(intent);
                    finish();
                }
            });
        } else if (indexType.equals(QouranPager.INDEX_GOZA)){
            setTitle("اجزاء القران");
            ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getGozaArray());
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               int pageNumber=  Page.getGozaPage(position+1);
                intent.putExtra(KEY_PAGE,pageNumber);
                    startActivity(intent);
finish();
                }
            });

        }else if (indexType.equals(QouranPager.INDEX_PAGES)){
            setTitle("صفحات القران");
            ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getPageArray());
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                     intent.putExtra(KEY_PAGE,603-position);
                    startActivity(intent);
finish();
                }
            });
        }
}

    private List<String> getPageArray() {
        ArrayList<String>pageNames=new ArrayList<>();
        for (int i = 0; i <604 ; i++) {
            pageNames.add((i+1)+"");
        }
        return pageNames;    }

    private List<String> getGozaArray() {
        ArrayList<String>gozaNames=new ArrayList<>();
        for (int i = 0; i <30 ; i++) {
            gozaNames.add("الجزء "+Page.getGozaName()[i]);
        }
        return gozaNames;
    }
    private List<String> getSoraArray() {
        ArrayList<String>soraNames=new ArrayList<>();
        for (int i = 0; i <114 ; i++) {
            String name=" سوره "+Page.getSorasName()[i];
            String num="  ترتيبها: "+(i+1);
            String pageNum=" الصفحه : "+Page.getSorasPage()[i];
            String type;
            if (Page.getSoraType()[i]==1)
            type=" و هى  مكيه";
        else
            type=" و هى  مدنيه";
            soraNames.add(name+" "+num+"  "+pageNum+"\n"+type);

        }
        return soraNames;
    }
}

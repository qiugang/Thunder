package me.originqiu.thunder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import me.originqiu.library.CallBuilder;
import me.originqiu.library.ResponseData;
import me.originqiu.library.Thunder;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        Thunder.with(this)
               .assign(new CallBuilder().url("https://raw.github.com/square/okhttp/master/README.md")
                                        .buildGet())
               .finish(new Thunder.ResponseCallBack() {
                   @Override
                   public void onResponse(ResponseData response) {
                       textView.setText(response.getBody());
                       
                   }
               })
               .broken(new Thunder.FailureCallBack() {
                   @Override
                   public void onFailure(Exception e) {
                       textView.setText(e.getMessage());
                   }
               })
               .execute();
    }
    
    @Override
    public void onBackPressed() {
        finish();
    }
}

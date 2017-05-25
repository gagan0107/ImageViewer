package com.example.hp.imageviewer;
;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.example.hp.imageviewer.*;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    private View parentView;

    private ArrayList<MyData> worldpopulation;
    RecyclerView mRecyclerView;
     CardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


        worldpopulation=new ArrayList<MyData>();

    /**
     * Set up Android CardView/RecycleView
     */
     mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    /**
     * START: button set up
     */

           /* MyService service = ServiceFactory.createRetrofitService(MyService.class, MyService.SERVICE_ENDPOINT);
            for(String rank : Data.githubList) {
                service.getUser(rank)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<MyData>() {
                            @Override
                            public final void onCompleted() {
                                // do nothing
                            }

                            @Override
                            public final void onError(Throwable e) {
                                Log.e("GithubDemo", e.getMessage());
                            }

                            @Override
                            public final void onNext(MyData response) {
                                mCardAdapter.addData(response);
                            }
                        });
            }*/

        MyService api = RetroClient.getMyService();

        /**
         * Calling JSON
         */
        Call<WorldPopulation> call = api.getMyJSON();

        /**
         * Enqueue Callback will be call when get response...
         */
        call.enqueue(new Callback<WorldPopulation>() {
            @Override
            public void onResponse(Call<WorldPopulation> call, Response<WorldPopulation> response) {
                //Dismiss Dialog
                //dialog.dismiss();

                if(response.isSuccessful()) {
                    /**
                     * Got Successfully
                     */
                    worldpopulation = response.body().getWorldPopulation();
                    Log.d("***************","wp"+worldpopulation);

                    /**
                     * Binding that List to Adapter
                     */
                     adapter = new CardAdapter(getApplicationContext(),worldpopulation);

                    mRecyclerView.setAdapter(adapter);


                    //listView.setAdapter(adapter);

                } else {
                    Toast.makeText(getApplicationContext(), "SOMETHING WENT WRONG", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<WorldPopulation> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"ON FAILURE RUNNED",Toast.LENGTH_LONG).show();
            }
        });

    // else {
      //  Snackbar.make(parentView,"INTERNET NOT AVAILABLE", Snackbar.LENGTH_LONG).show();
    //}

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
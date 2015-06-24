package info.antoniogoncalves.nav_drawer_simple;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import com.getbase.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private static final String SELECTED_ITEM_ID = "selected";
    private Toolbar mToolbar;
    private NavigationView mDrawer;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private int mSelectedId;
    private com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mDrawer = (NavigationView) findViewById(R.id.navigationView);
        mDrawer.setNavigationItemSelectedListener(this);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.Open, R.string.Close);

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        mSelectedId = savedInstanceState == null ? R.id.workout1 : savedInstanceState.getInt(SELECTED_ITEM_ID);
        navigate(mSelectedId);

        //FAB button


        final FloatingActionButton workout = (FloatingActionButton) findViewById(R.id.Workout);
        workout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                workout.setTitle("New Workout!");
                navigate(R.id.Workout);
            }
        });
        final FloatingActionButton exercise = (FloatingActionButton) findViewById(R.id.Exercise);
        exercise.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                exercise.setTitle("New Exercise!");
                navigate(R.id.Exercise);
            }
        });
        // Test that FAMs containing FABs with visibility GONE do not cause crashes
    }

    private void navigate(int mSelectedId) {
        Intent intent = null;
        if(mSelectedId == R.id.workout3){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        }
        if(mSelectedId == R.id.workout2){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        }
        if(mSelectedId == R.id.Exercise){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        }
        if(mSelectedId == R.id.Workout){
            mDrawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        }


    }
// methods
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        menuItem.setChecked(true);
        mSelectedId = menuItem.getItemId();
        navigate(mSelectedId);
        return true;
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(SELECTED_ITEM_ID, mSelectedId);
    }
    @Override
    public void onBackPressed(){
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(mDrawer);
        }
        else{
            super.onBackPressed();
        }
    }
}


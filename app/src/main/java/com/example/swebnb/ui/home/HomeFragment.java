package com.example.swebnb.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.SearchManager;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.swebnb.MainActivity;
import com.example.swebnb.R;
import com.example.swebnb.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment<ViewPagerAdapter> extends Fragment {
   //image view
    ViewPager mViewPager;

    // images array
    int[] images = {R.drawable.ic_dashboard_black_24dp, R.drawable.ic_home_black_24dp,R.drawable.ic_notifications_black_24dp};

    // Creating Object of ViewPagerAdapter
//    ViewPagerAdapter mViewPagerAdapter = (ViewPagerAdapter) new com.example.swebnb.ViewPagerAdapter(getContext(), images);

    // List View object
    ListView listView;

    // Define array adapter for ListView
    ArrayAdapter<String> adapter;


    // Define array List for List View data
    ArrayList<String> mylist;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
       // initialise ListView with id
        listView = root.findViewById(R.id.listView);

        // Add items to Array List
        mylist = new ArrayList<>();
//        mylist.add("Kej");
//        mylist.add("GestHouse");
//        mylist.add("kyb");
        // Set adapter to ListView
        adapter
                = new ArrayAdapter<String>(getContext().getApplicationContext(), android.R.layout.simple_list_item_1, mylist);
        listView.setAdapter(adapter);

//        List<String> items = new ArrayList<String>();
//        items.add("string");
//        items.add("string");
//        items.add("string");
        // Set adapter to ListView
        // Initializing the ViewPager Object
        mViewPager = (ViewPager)root.findViewById(R.id.viewPagerMain);
        ViewPagerAdapter mViewPagerAdapter = (ViewPagerAdapter) new com.example.swebnb.ViewPagerAdapter(getContext(), images);
        mViewPager.setAdapter((PagerAdapter) mViewPagerAdapter);

        return root;
    }

//    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        // Inflate menu with items using MenuInflator
//        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.search_box_menu, menu);

        // Initialise menu item search bar
        // with id and take its object
        MenuItem searchViewItem
                = menu.findItem(R.id.search_bar);
        SearchView searchView
                = (SearchView) MenuItemCompat.getActionView(searchViewItem);

        // attach setOnQueryTextListener
        // to search view defined above
        searchView.setOnQueryTextListener(
                new SearchView.OnQueryTextListener() {

// Override onQueryTextSubmit method
// which is call
// when submitquery is searched

                    @Override
                    public boolean onQueryTextSubmit(String query)
                    {
                        // If the list contains the search query
                        // than filter the adapter
                        // using the filter method
                        // with the query as its argument
                        ArrayList list = new ArrayList<>();
                        if (list.contains(query)) {
                            adapter.getFilter().filter(query);
                        }
                        else {
                            // Search query not found in List View
                            Toast
                                    .makeText(getContext().getApplicationContext(),
                                            "Not found",
                                            Toast.LENGTH_LONG)
                                    .show();
                        }
                        return false;
                    }

                    // This method is overridden to filter
// the adapter according to a search query
// when the user is typing search
                    @Override
                    public boolean onQueryTextChange(String newText)
                    {
                        adapter.getFilter().filter(newText);
                        return false;
                    }
                });

        super.onCreateOptionsMenu(menu,inflater);
    }



}







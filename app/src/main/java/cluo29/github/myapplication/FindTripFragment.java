package cluo29.github.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * This class is used to map the google maps fragments in helper and places mode.
 */
public class FindTripFragment extends Fragment implements View.OnClickListener {
    Button helperMapButton;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_find_trip, null);

        //load default map as nearby places
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_trip_container, new DisplayMapFragment())
                .commit();

        //connect button
        helperMapButton = (Button) view.findViewById(R.id.helper);
        helperMapButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        ApiController.switchMode();

        // The default places mode
        if(!ApiController.isHelperMode){
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_trip_container, new DisplayMapFragment())
                    .commit();
        } else {

            //load map with the helper mode
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_trip_container, new DisplayHelperMapFragment())
                    .commit();
        }
    }
}

package com.example.rony.allaboutcse;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ResourceFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ResourceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResourceFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ListView subjectList;

    ArrayList<String> subject;
    ArrayList<String> details;

    ListViewCustomAdapter adapter;

    private OnFragmentInteractionListener mListener;

    public ResourceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ResourceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ResourceFragment newInstance(String param1, String param2) {
        ResourceFragment fragment = new ResourceFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_resource, container, false);

        getActivity().setTitle("Resources");

        subjectList =(ListView) rootView.findViewById(R.id.lvAlbumList);
        fillData();
        adapter = new ListViewCustomAdapter(getActivity().getApplicationContext(), subject, details);
        subjectList.setAdapter(adapter);

        subjectList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position,
                                    long id) {


                switch(position){

                    case 0:
                    {
                        Intent intent = new Intent(getActivity(), BookResActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 1:
                    {


                        Intent intent = new Intent(getActivity(), DocResActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 2:
                    {
                        Intent intent = new Intent(getActivity(), SolveResActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 3:
                    {
                        Intent intent = new Intent(getActivity(), YourResActivity.class);
                        startActivity(intent);
                        break;
                    }

                    default:
                        break;

                }

            }
        });


        return rootView;
    }

    private void fillData() {

        subject = new ArrayList<String>();
        details = new ArrayList<String>();

        subject.add("Reference Books PDF");
        subject.add("Documents");
        subject.add("Previous Board Question Solve");
        subject.add("Your Documents");


        details.add("Download pdf for available Books");
        details.add("Some Needed Documents");
        details.add("Subject Wise Question Solve");
        details.add("Upload Your Document");

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

package tutor.com.conductor;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Controller;

public class HomeController extends Controller {
    private View tree;

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_home, container, false);
        tree = view.findViewById(R.id.tree);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tree.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }

    @Override
    protected void onDestroyView(@NonNull View view) {
        super.onDestroyView(view);
        tree = null;
    }
}

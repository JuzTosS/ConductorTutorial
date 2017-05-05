package tutor.com.conductor;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Controller;

public class HomeController extends Controller {
    private boolean isGrown = false;
    private View tree;

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_home, container, false);
        tree = view.findViewById(R.id.tree);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isGrown = true;
                update();
            }
        });

        return view;
    }

    @Override
    protected void onAttach(@NonNull View view) {
        super.onAttach(view);
        update();
    }

    private void update() {
        tree.setVisibility(isGrown ? View.VISIBLE : View.GONE);
    }

    @Override
    protected void onDestroyView(@NonNull View view) {
        super.onDestroyView(view);
        tree = null;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("isGrown", isGrown);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        isGrown = savedInstanceState.getBoolean("isGrown");
    }
}

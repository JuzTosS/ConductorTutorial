package tutor.com.conductor;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;

public class HomeController extends Controller implements ConeController.ConeListener {
    private boolean isGrown = false;
    private int conesCount = 42;
    private View tree;

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_home, container, false);
        tree = view.findViewById(R.id.tree);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isGrown) {
                    getRouter().pushController(RouterTransaction.with(new ConeController(conesCount, HomeController.this)));
                } else {
                    isGrown = true;
                    update();
                }
            }
        });

        return view;
    }

    @Override
    public void conesLeft(int count) {
        conesCount = count;
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
        outState.putInt("conesCount", conesCount);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        isGrown = savedInstanceState.getBoolean("isGrown");
        conesCount = savedInstanceState.getInt("conesCount");
    }
}
